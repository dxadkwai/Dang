package com.example.myapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.Size
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.example.myapp.ui.theme.BoundingBox
import kotlinx.coroutines.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : ComponentActivity() {
    private lateinit var cameraExecutor: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cameraExecutor = Executors.newSingleThreadExecutor()
        if (allPermissionsGranted()) {
            setContent { MainScreen(cameraExecutor) }
        } else {
            requestPermissions()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions() {
        requestPermissions(REQUIRED_PERMISSIONS, 10)
    }

    companion object {
        private val REQUIRED_PERMISSIONS = mutableListOf(
            Manifest.permission.CAMERA
        ).apply {
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }.toTypedArray()
    }
}

// 🎥 CameraManager - Quản lý CameraX
class CameraManager(
    private val lifecycleOwner: LifecycleOwner,
    private val context: Context,
    private val imageProcessor: (Bitmap) -> Unit,
    private val cameraExecutor: ExecutorService
) {
    private var lastProcessedTime = 0L
    fun startCamera(previewView: PreviewView) {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build()
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            preview.setSurfaceProvider(previewView.surfaceProvider)

            val imageAnalyzer = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .setOutputImageFormat(ImageAnalysis.OUTPUT_IMAGE_FORMAT_RGBA_8888)
                .build()
                .also { analysis ->
                    analysis.setAnalyzer(cameraExecutor) { imageProxy ->
                        val currentTime = System.currentTimeMillis()
                        if (currentTime - lastProcessedTime < 250) {
                            imageProxy.close()
                            return@setAnalyzer
                        }
                        lastProcessedTime = currentTime

                        try {
                            val bitmapBuffer = Bitmap.createBitmap(
                                imageProxy.width,
                                imageProxy.height,
                                Bitmap.Config.ARGB_8888
                            )
                            imageProxy.use { bitmapBuffer.copyPixelsFromBuffer(imageProxy.planes[0].buffer) }
                            val matrix = Matrix().apply {
                                postRotate(imageProxy.imageInfo.rotationDegrees.toFloat()) // Xoay ảnh về đúng hướng
                            }
                            val rotatedBitmap = Bitmap.createBitmap(
                                bitmapBuffer, 0, 0, bitmapBuffer.width, bitmapBuffer.height,
                                matrix, true
                            )
                            imageProcessor(rotatedBitmap)
                        } catch (e: Exception) {
                            Log.e("CameraManager", "Error converting image: ${e.message}")
                        } finally {
                            imageProxy.close()
                        }
                    }
                }

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    lifecycleOwner, cameraSelector, preview, imageAnalyzer
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }, ContextCompat.getMainExecutor(context))
    }
}
// 🖼️ Chuyển ImageProxy thành Bitmap
fun ImageProxy.toBitmap(): Bitmap {
    val buffer = planes[0].buffer
    val bytes = ByteArray(buffer.remaining())
    buffer.get(bytes)
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}

// 🧠 DetectorManager - Xử lý ảnh trong Coroutine
class DetectorManager(
    private val context: Context,
    private val ttsHelper: TextToSpeechHelper
) {
    private var currentToast: Toast? = null
    private var lastMessage: String? = null
    private var toastShowing = false
    private var toast: Toast? = null
    private val detector = Detector(
        context = context,
        modelPath = "bbest2.tflite",
        labelPath = null,
        detectorListener = object : Detector.DetectorListener {
            override fun onEmptyDetect() {}

            override fun onDetect(boundingBoxes: List<BoundingBox>, inferenceTime: Long) {}

            override fun onOCRCompleted(detectedTexts: List<String>) {

                if (detectedTexts.isNotEmpty()) {
                    val hasBus = detectedTexts.any { it.trim().equals("Bus", ignoreCase = true) }

                    // Chuyển tất cả về String để tránh lỗi
                    val filteredTexts = detectedTexts.map { it.trim() } // Loại bỏ khoảng trắng
                        .filter { it.isNotEmpty() && !it.equals("Bus", ignoreCase = true) }
                        .map { it.toString() } // Đảm bảo tất cả là String

                    val filteredTextStr = filteredTexts.joinToString("") // Nối không có dấu phẩy
                    val result = filteredTextStr.split(", ").joinToString("")
//                    val result = filteredTextStr.joinToString("")
                    Log.d("DEBUG", "filteredTexts: $filteredTexts, type: ${filteredTexts.javaClass.name}")
                    Log.d("DEBUG", "filteredTextStr: $filteredTextStr, type: ${filteredTextStr.javaClass.name}")

                    val message = if (hasBus) {
                        if (filteredTextStr.isNotEmpty()) {
                            "Bus: $result"
                        } else {
                            "Bus"
                        }
                    } else {
                        result
                    }

                    Log.d("DEBUG", "Final message: $message")

                    if (message.isNotEmpty() && message != lastMessage) {
                        lastMessage = message
                        ttsHelper.speak(message)

                        Handler(Looper.getMainLooper()).post {
                            toast?.cancel()
                            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
                            toast?.show()
                        }
                    }


                }



            }
        },
        message = { message -> Log.e("Detector", message) }
    )

//    private fun showToast(message: String) {
//        toastShowing = true
//        currentToast?.cancel()
//
//        currentToast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
//        currentToast?.show()
//
//        Handler(Looper.getMainLooper()).postDelayed({
//            toastShowing = false
//        }, Toast.LENGTH_SHORT.toLong())
//    }

    private var isProcessing = false

    fun processImage(bitmap: Bitmap) {
        if (isProcessing) return // Bỏ qua nếu đang xử lý ảnh khác

        CoroutineScope(Dispatchers.IO).launch {
            isProcessing = true
            detector.detect(bitmap)
            isProcessing = false
        }
    }
}

// 🏠 MainScreen - Kết hợp Camera và Nhận diện
@Composable
fun MainScreen(cameraExecutor: ExecutorService) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val previewView = remember { PreviewView(context) }
    val ttsHelper = remember { TextToSpeechHelper(context) }
    val detectorManager = remember { DetectorManager(context, ttsHelper) }
    val cameraManager = remember { CameraManager(lifecycleOwner, context, detectorManager::processImage, cameraExecutor) }

    DisposableEffect(Unit) {
        cameraManager.startCamera(previewView)
        onDispose { cameraExecutor.shutdown() }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AndroidView(
            factory = { previewView },
            modifier = Modifier.fillMaxSize()
        )
    }
}
