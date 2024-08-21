package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame windonw = new JFrame();
        windonw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windonw.setResizable(false);
        windonw.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        windonw.add(gamePanel);

        windonw.pack();

        windonw.setLocationRelativeTo(null);
        windonw.setVisible(true);
    }
    
}