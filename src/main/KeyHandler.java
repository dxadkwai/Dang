package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Keyboard input handler. Maps W/A/S/D keys to direction flags for player movement
public class KeyHandler implements KeyListener{


    public boolean upPressed, downPressed, leftPressed, rightPressed;
    
    // Called when key is typed (unused)
    @Override
    public void keyTyped(KeyEvent e) {
        }

    // Set direction flag to true when key is pressed
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed =true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed =true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed=true;
        }
    }

    // Set direction flag to false when key is released
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed =false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed =false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed=false;
        }

    }

    

   

    
    
}
