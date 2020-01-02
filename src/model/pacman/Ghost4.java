package model.pacman;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Ghost4 extends Ghost {
    private Player player;
    public Ghost4(int x, int y,Player player) {
        super(x, y);
        shape.setFill(player.getColor());
        this.player=player;
    }

    @Override
    public void selectDirection(ArrayList<Character> chMap) {
        falseDirection();
        int[] dirs = {1, 1, 1, 1};
        double[] D = {-1, -1, -1, -1};
        int x = getX() / 60;
        int y = getY() / 60;
        int px = player.getX() / 60;
        int py = player.getY() / 60;
        if (chMap.get(x + (y - 1) * 19) == 'W') {
            dirs[0] = 0;
        } else {
            D[0] = (x - px) * (x - px) + (y - 1 - py) * (y - 1 - py);
        }
        if (chMap.get(x + (y + 1) * 19) == 'W') {
            dirs[2] = 0;
        } else {
            D[2] = (x - px) * (x - px) + (y + 1 - py) * (y + 1 - py);
        }
        if (chMap.get(x + 1 + y * 19) == 'W') {
            dirs[1] = 0;
        } else {
            D[1] = (x + 1 - px) * (x + 1 - px) + (y - py) * (y - py);
        }
        if (chMap.get(x - 1 + y * 19) == 'W') {
            dirs[3] = 0;
        } else {
            D[3] = (x - 1 - px) * (x - 1 - px) + (y - py) * (y - py);
        }
        double min = Double.MAX_VALUE;
        int minIndex=-1;
        for (int i=0;i<4;i++) {
            if (D[i]>=0){
                if (min>D[i]){
                    min=D[i];
                    minIndex=i;
                }
            }
        }
        if (minIndex==0) moveUP=true;
        else if (minIndex==1) moveRIGHT=true;
        else if (minIndex==2) moveDOWN=true;
        else if (minIndex==3) moveLEFT=true;
    }

    @Override
    public void move() {
        if (countMove==20) countMove=0;
        countMove+=1;

        if (moveUP){
            setY(getY()-getV());
        }
        else if (moveDOWN){
            setY(getY()+getV());
        }
        else if (moveRIGHT){
            setX(getX()+getV());
        }
        else if (moveLEFT){
            setX(getX()-getV());
        }
        shape.setLayoutX(getX());
        shape.setLayoutY(getY());
    }
}


