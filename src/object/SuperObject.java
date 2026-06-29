package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

// Base class for interactive game objects (keys, chests, items) with position and collision
public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;


    // draw method, used to draw the objects of the keys - same steps as drawing the tiles because it is taking the same screenX and screenY on the tile
    public void draw(Graphics2D g2, GamePanel gp) {
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX+gp.tileSize>gp.player.worldX - gp.player.screenX && 
                    worldY+gp.tileSize>gp.player.worldY - gp.player.screenY &&
                    worldX-gp.tileSize<gp.player.worldX+gp.player.screenX &&   
                    worldY-gp.tileSize<gp.player.worldY+gp.player.screenY) {

                g2.drawImage(image, screenX,screenY, gp.tileSize,gp.tileSize,null);
                
            }
        

    }
    
}
