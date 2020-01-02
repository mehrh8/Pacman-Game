package model.pacman;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;

public abstract class Ghost extends Creature {
    protected Boolean moveUP=new Boolean(false);
    protected Boolean moveDOWN=new Boolean(false);
    protected Boolean moveRIGHT=new Boolean(false);
    protected Boolean moveLEFT=new Boolean(false);
    protected int countMove=0;
    protected Polygon shape;
    public Ghost(int x, int y) {
        super(x, y);
        shape=new Polygon(30,5,5,12,5,48,11.25,55,17.5,48,23.75,55,30,48,36.25,55,42.5,48,48.75,55,55,48,55,12,30,5,30,20,37,20,40,17,43,20,40,23,37,20,23,20,20,23,17,20,20,17,23,20,30,20,30,5);
        shape.setLayoutX(getX());
        shape.setLayoutY(getY());
    }

    @Override
    public Node getNode() {
        return shape;
    }

    public abstract void selectDirection(ArrayList<Character> chMap);
    public void falseDirection(){
        moveUP=false;
        moveDOWN=false;
        moveRIGHT=false;
        moveLEFT=false;
    }
    public int selectDir(int[] dir){
        int sum=0;
        int[] ans={0,0,0,0};
        for (int item:dir) {
            sum+=item;
        }
        int rand = (int)(Math.random()*sum);
        for (int i =0;i<dir.length;i++){
            if (dir[i]==1){
                if (rand==0) return i;
                else rand-=1;
            }
        }
        return -1;
    }
}
