package main;

import java.awt.*;
import javax.swing.*;

import entity.Player;
import tile.Tile;
import tile.TileManager;

// import entity.Player;


public class GamePanel extends JPanel implements Runnable{
    //screen settings
    final int originalTileSize = 16; //16x16 tiles --> standard size for retro
    final int scale = 3;

    public final int tileSize = originalTileSize*scale;//48*48
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    final int screenWidth = tileSize*maxScreenCol;//768 pixel
    final int screenHeight = tileSize*maxScreenRow;//576 pixel

    // FPS
    int FPS = 60;


    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread = new Thread();
    Player player = new Player(this,keyH);

    //set plaer's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();


    }


    @Override
    // public void run() {

    //     double drawInterval = 1000000000/FPS;
    //     double nextDrawTime = System.nanoTime() + drawInterval;

        
    //     while(gameThread!=null) {

            
    //         //update information such as character position
    //         update();

    //         // //draw the screen with the updated information
    //         repaint(); //how to call paintComponent

            

    //         try {
    //             double remainingTime = nextDrawTime - System.nanoTime();
    //             remainingTime = remainingTime/1000000;

    //             if (remainingTime < 0) {
    //                 remainingTime = 0;
    //             }

    //             Thread.sleep((long) remainingTime);

    //             nextDrawTime += drawInterval;

    //         } catch (InterruptedException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }


    //     }

    // }

    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {
            currentTime = System.nanoTime();;

            delta += (currentTime - lastTime )/drawInterval;
            lastTime = currentTime;
            if(delta > 1) {
                update();
                repaint();
                delta --;

            }





            
        }
    }

    public void update() {

        player.update();
        
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);

        player.draw(g2);

        g2.dispose();

    }


}
