package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable {
    //screen settings
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;

    KeyHandler keyH = new KeyHandler();

    Thread gameThread;


    //set play's default postion
    int playerX = 100;
    int playerY = 100;
    int playerspeed = 4;

    public GamePanel(){
        this.setPreferredSize(new DimensionUIResource(screenWidth, screenHeight));
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
    public void run(){

        while (gameThread != null){
            long currenTime = System.nanoTime();

            // 1.UPDATE: update information such as character positions.
            update();

            // 2.DRAW: draw the screen with the update information.
            
            repaint();
        }


    }

    public void update(){
        if (keyH.upPressed == true){
            playerY -= playerspeed;
        }else if(keyH.downPressed == true){
            playerY += playerspeed;
        }else if(keyH.leftPressed == true){
            playerX -= playerspeed;
        }else if(keyH.rightPressed == true){
            playerX += playerspeed;
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize); 
        g2.dispose();
    }


    
}