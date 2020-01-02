package model.pacman;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class CpuPlayer extends Player {
    private Boolean moveUP=new Boolean(false);
    private Boolean moveDOWN=new Boolean(false);
    private Boolean moveRIGHT=new Boolean(false);
    private Boolean moveLEFT=new Boolean(false);
    private Circle shape;
    private Color color;
    private int countMove=0;
    private ArrayList<Character> chMap;

    public ArrayList<Character> getChMap() {
        return chMap;
    }

    public void setChMap(ArrayList<Character> chMap) {
        this.chMap = chMap;
    }

    public CpuPlayer(int x, int y, Color color, ArrayList<Character> chMap) {
        super(x, y,KeyCode.DIGIT0,KeyCode.DIGIT0,KeyCode.DIGIT0,KeyCode.DIGIT0,color);
        shape=new Circle(getX()+30,getY()+30,25, color);
        this.chMap=chMap;
    }

    public Circle getShape() {
        return shape;
    }

    public void setShape(Circle shape) {
        this.shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCountMove() {
        return countMove;
    }

    public void setCountMove(int countMove) {
        this.countMove = countMove;
    }

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
    public void selectDirection() {
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
        if (countMove==20) {
            countMove=0;
            selectDirection();
        }
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
        shape.setCenterX(getX()+30);
        shape.setCenterY(getY()+30);
    }

    @Override
    public Node getNode() {
        return shape;
    }
}
