package model.pacman;

import javafx.scene.Node;

public abstract class Creature {
    private int x;
    private int y;
    private int v=3;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getV() {
        return v;
    }

    public Creature(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void move();
    public abstract Node getNode();
    public Creature remove(){
        return null;
    }

    public void setV(int v) {
        this.v = v;
    }
}
