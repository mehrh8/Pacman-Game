package model.pacman;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Ghost3 extends Ghost {
    public Ghost3(int x, int y) {
        super(x, y);
        shape.setFill(Color.BLUEVIOLET);
    }

    @Override
    public void selectDirection(ArrayList<Character> chMap) {
        falseDirection();
        int[] dirs ={1,1,1,1};
        int x = getX() / 60;
        int y = getY() / 60;
        if (chMap.get(x + (y-1) * 19) == 'W'){
            dirs[0]=0;
        }
        if (chMap.get(x + (y+1) * 19) == 'W'){
            dirs[2]=0;
        }
        if (chMap.get(x + 1 + y * 19) == 'W'){
            dirs[1]=0;
        }
        if (chMap.get(x - 1 + y * 19) == 'W'){
            dirs[3]=0;
        }
        int sdir=selectDir(dirs);
        if (sdir==0) moveUP=true;
        else if (sdir==1) moveRIGHT=true;
        else if (sdir==2) moveDOWN=true;
        else if (sdir==3) moveLEFT=true;
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

