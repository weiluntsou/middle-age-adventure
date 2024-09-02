package entity;


import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyG;
    public Player(GamePanel gp,KeyHandler keyG){
        this.gp = gp;
        this.keyG = keyG;
    }

}
