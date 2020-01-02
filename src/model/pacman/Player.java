package model.pacman;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player extends Creature {
    private KeyCode keyUP;
    private KeyCode keyDOWN;
    private KeyCode keyRIGHT;
    private KeyCode keyLEFT;
    private KeyCode keyMove;
    private KeyCode keyMoveNow;
    private Boolean moveChange=false;
    private Boolean moveNull=false;
    protected Circle shape;
    private Color color;
    private int countMove=0;
    private int score;
    private int heart;
    private boolean dontMove=false;
    private int feckless=0;

    public int getFeckless() {
        return feckless;
    }

    public void setFeckless(int feckless) {
        this.feckless = feckless;
    }

    public boolean isDontMove() {
        return dontMove;
    }

    public void setDontMove(boolean dontMove) {
        this.dontMove = dontMove;
    }

    public void setKeyMove(KeyCode keyMove) {
        this.keyMove = keyMove;
    }

    public KeyCode getKeyUP() {
        return keyUP;
    }

    public KeyCode getKeyDOWN() {
        return keyDOWN;
    }

    public KeyCode getKeyRIGHT() {
        return keyRIGHT;
    }

    public KeyCode getKeyLEFT() {
        return keyLEFT;
    }

    public void setMoveChange(Boolean moveChange) {
        this.moveChange = moveChange;
    }

    public void setMoveNull(Boolean moveNull) {
        this.moveNull = moveNull;
    }

    public KeyCode getKeyMoveNow() {
        return keyMoveNow;
    }

    public Color getColor() {
        return color;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public Player(int x, int y, KeyCode keyUP, KeyCode keyDown, KeyCode keyRIGHT, KeyCode keyLEFT, Color color) {
        super(x, y);
        this.keyUP = keyUP;
        this.keyDOWN = keyDown;
        this.keyRIGHT = keyRIGHT;
        this.keyLEFT = keyLEFT;
        this.keyMove=null;
        shape=new Circle(getX()+30,getY()+30,25, color);
        this.color=color;
        this.score=0;
        this.heart=2;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public KeyCode getKeyMove() {
        return keyMove;
    }

    public void setKeyMoveNow(KeyCode keyMoveNow) {
        this.keyMoveNow = keyMoveNow;
    }

    public void setShape(Circle shape) {
        this.shape = shape;
    }

    public Circle getShape() {
        return shape;
    }

    public int getCountMove() {
        return countMove;
    }

    public void setCountMove(int countMove) {
        this.countMove = countMove;
    }

    @Override
    public void move() {
        if (countMove < 0) {
            countMove += 1;
            return;
        }
        if (countMove == 20) {
            countMove = 0;
            if (feckless==5) {
                shape.setRadius(10);
                feckless-=1;
            }
            else if (0<feckless && feckless<5) {
                shape.setRadius(shape.getRadius()+4);
                feckless-=1;
                System.out.println(feckless);
            }
        }
        countMove += 1;
        if (keyMoveNow != null) {
            if (keyMoveNow == keyUP) {
                setY(getY() - getV());
            } else if (keyMoveNow == keyDOWN) {
                setY(getY() + getV());
            } else if (keyMoveNow == keyRIGHT) {
                setX(getX() + getV());
            } else if (keyMoveNow == keyLEFT) {
                setX(getX() - getV());
            }
            shape.setCenterX(getX() + 30);
            shape.setCenterY(getY() + 30);
        }
    }

    @Override
    public Node getNode() {
        return shape;
    }
}
