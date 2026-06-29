package main;

import java.awt.*;
import javax.swing.*;

import entity.Player;
import object.SuperObject;
import tile.Tile;
import tile.TileManager;
import object.OBJ_Key;

// Main game panel: Manages game loop, rendering, entities, and game state at 60 FPS
public class GamePanel extends JPanel implements Runnable{
    //screen settings
    final int originalTileSize = 16; //16x16 tiles --> standard size for retro
    final int scale = 3;

    public final int tileSize = originalTileSize*scale;//48*48
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize*maxScreenCol;//768 pixel
    public final int screenHeight = tileSize*maxScreenRow;//576 pixel

    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize*maxWorldCol;
    public final int worldHeight = tileSize*maxWorldRow;
    



    // FPS
    int FPS = 60;


    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread = new Thread();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[10];

    //set plaer's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    // Constructor: Initialize game panel with display settings and input handling
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }


    public void setupGame() {
        aSetter.setObject();
    }
    // Start the game loop thread
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();


    }


    

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


    // Main game loop: Update game state and render at target FPS using delta timing
    @Override
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

    // Update all game entities (player, NPCs, objects) once per frame
    public void update() {

        player.update();
        
    }

    // Render game world: Draw tiles and all entities on screen
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        //TILE 

        tileM.draw(g2);

        //OBJECT
        for (int i=0; i<obj.length;i++) {
            if(obj[i]!=null){
                obj[i].draw(g2,this);
            }
        }

        //PLAYER

        player.draw(g2);



        g2.dispose();

    }


}
