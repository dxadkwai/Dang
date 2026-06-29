package main;
import javax.swing.*;

// Entry point of the 2D Adventure game application
public class Main{
    // Main entry point: Create game window and start the game
    public static void main(String[] args) {
        JFrame window = new JFrame() ;
        GamePanel gamePanel = new GamePanel();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        
        
        
        gamePanel.setupGame();
        gamePanel.startGameThread();
        

        

    }
}