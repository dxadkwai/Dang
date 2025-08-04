package com.example.myapp

import android.content.Context
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import java.util.Locale

class TextToSpeechHelper(context: Context) : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech = TextToSpeech(context, this)
    private var latestMessage: String? = null
    private var isSpeaking = false

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    isSpeaking = true
                }

                override fun onDone(utteranceId: String?) {
                    isSpeaking = false
                    latestMessage?.let {
                        val messageToSpeak = latestMessage
                        latestMessage = null
                        speak(messageToSpeak!!)
                    }
                }

                override fun onError(utteranceId: String?) {}
            })
        }
    }

    fun speak(message: String) {
        if (isSpeaking) {
            latestMessage = message
        } else {
            isSpeaking = true
            val params = Bundle()
            params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "tts_message")
            tts.speak(message, TextToSpeech.QUEUE_FLUSH, params, "tts_message")
        }
    }

    fun shutdown() {
        tts.stop()
        tts.shutdown()
    }
}
