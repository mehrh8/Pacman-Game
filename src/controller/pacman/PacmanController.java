package controller.pacman;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.pacman.*;
import view.pacman.PacmanView;

import java.util.ArrayList;

public class PacmanController<pubilc> {
    private int NOO;
    private int NOC;
    private Group root;
    private Scene scene;
    private ArrayList<Node> smallCircle=new ArrayList<Node>();
    private ArrayList<Node> bigCircle=new ArrayList<Node>();
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
    private ArrayList<Character> chMap;
    private int counterSmallCircle=0;
    private int moveGhost=0;
    private int mode;
    private static Text score;
    public PacmanController(Group root, Scene scene,int mode) {
        this.root=root;
        this.scene=scene;
        this.mode=mode;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void getMap(String mapPath) {
        Map map = new Map(mapPath);
        chMap = map.getMap();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 247; i++) {
            if (chMap.get(i).equals('W')) {
                Rectangle r = new Rectangle((i % 19) * 60, (i / 19) * 60, 60, 60);
                r.setFill(Color.rgb(100, 100, 100));
                r.setArcHeight(2);
                r.setArcWidth(2);
                r.setSmooth(true);
                root.getChildren().add(r);
            } else if (chMap.get(i).equals('O')) {
                Circle c = new Circle((i % 19) * 60 + 30, (i / 19) * 60 + 30, 5, Color.YELLOW);
                c.setSmooth(true);
                smallCircle.add(c);
                root.getChildren().add(c);
            } else if (chMap.get(i).equals('C')) {
                Circle c = new Circle((i % 19) * 60 + 30, (i / 19) * 60 + 30, 10, Color.ORANGE);
                c.setSmooth(true);
                bigCircle.add(c);
                root.getChildren().add(c);
            }
        }
    }
    public void getScore(){
        score=new Text();
        score.setText("Score");
        score.setLayoutX(60);
        score.setLayoutY(30);
        score.setFont(new Font("tahoma",25));
        score.setFill(Color.HOTPINK);
        root.getChildren().add(score);
    }
    public Player getPlayer(int x, int y, KeyCode keyUP, KeyCode keyDown, KeyCode keyRIGHT, KeyCode keyLEFT,Color color) {
        Player player = new Player(x,y,keyUP,keyDown,keyRIGHT,keyLEFT,color);
        root.getChildren().add(0,player.getNode());
        players.add(player);
        return player;
    }
    public Player getCpuPlayer(int x, int y,Color color) {
        CpuPlayer cpuPlayer = new CpuPlayer(x,y,color,chMap);
        root.getChildren().add(cpuPlayer.getNode());
        players.add(cpuPlayer);
        return cpuPlayer;
    }
    public void getGhost1(int x, int y){
        Ghost1 ghost = new Ghost1(x,y);
        root.getChildren().add(ghost.getNode());
        ghosts.add(ghost);
    }
    public void getGhost2(int x, int y){
        Ghost2 ghost = new Ghost2(x,y);
        root.getChildren().add(ghost.getNode());
        ghosts.add(ghost);
    }
    public void getGhost3(int x, int y){
        Ghost3 ghost = new Ghost3(x,y);
        root.getChildren().add(ghost.getNode());
        ghosts.add(ghost);
    }
    public void getGhost4(int x, int y,Player player){
        Ghost4 ghost = new Ghost4(x,y,player);
        root.getChildren().add(ghost.getNode());
        ghosts.add(ghost);
    }
    public void startGame(){
        final int[] countGame = {0};
        AnimationTimer game = new AnimationTimer() {
            long lastUpdateTime=0;
            public void handle(long nowTime) {
                if (nowTime - lastUpdateTime >= 4_000_000) {
                    lastUpdateTime = nowTime;

                    countGame[0] += 1;
                    for (Creature item : players) {
                        item.move();
                    }
                    for (Creature item : ghosts) {
                        item.move();
                    }

                    this.contactGhost();
                    if (countGame[0] == 20) {
                        countGame[0] = 0;
                        for (Player player : players) {
                            if (player.getClass()!=CpuPlayer.class) {
                                int x = player.getX() / 60;
                                int y = player.getY() / 60;
                                if (player.getKeyMove() == player.getKeyUP()) {
                                    if (chMap.get(x + (y - 1) * 19) != 'W') player.setKeyMoveNow(player.getKeyMove());
                                } else if (player.getKeyMove() == player.getKeyDOWN()) {
                                    if (chMap.get(x + (y + 1) * 19) != 'W') player.setKeyMoveNow(player.getKeyMove());
                                } else if (player.getKeyMove() == player.getKeyRIGHT()) {
                                    if (chMap.get(x + 1 + y * 19) != 'W') player.setKeyMoveNow(player.getKeyMove());
                                } else if (player.getKeyMove() == player.getKeyLEFT()) {
                                    if (chMap.get(x - 1 + y * 19) != 'W') player.setKeyMoveNow(player.getKeyMove());
                                }
                                if (player.getKeyMoveNow() == player.getKeyUP()) {
                                    if (chMap.get(x + (y - 1) * 19) == 'W') player.setKeyMoveNow(null);
                                } else if (player.getKeyMoveNow() == player.getKeyDOWN()) {
                                    if (chMap.get(x + (y + 1) * 19) == 'W') player.setKeyMoveNow(null);
                                } else if (player.getKeyMoveNow() == player.getKeyRIGHT()) {
                                    if (chMap.get(x + 1 + y * 19) == 'W') player.setKeyMoveNow(null);
                                } else if (player.getKeyMoveNow() == player.getKeyLEFT()) {
                                    if (chMap.get(x - 1 + y * 19) == 'W') player.setKeyMoveNow(null);
                                }
                            }
                        }
                        if (moveGhost==0)
                            for (Ghost ghost:ghosts) {
                                ghost.selectDirection(chMap);
                        }
                        else {
                            for (Ghost ghost:ghosts){
                                ghost.falseDirection();
                            }
                            moveGhost-=1;
                        }

                        this.contactSmallCircle();
                        this.contactBigCircle();
                        this.updateScore();

                    }
                }
            }

            private void contactSmallCircle() {
                for (Node item:smallCircle) {
                    Circle c=(Circle)item;
                    if(c.getRadius()!=0) {
                        for (Player player : players) {
                            if (c.getCenterX()-30==player.getX() && c.getCenterY()-30==player.getY()){
                                c.setRadius(0);
                                counterSmallCircle+=1;
                                player.setScore(player.getScore()+1);
                                break;
                            }
                        }
                    }
                }
            }

            private void contactBigCircle() {
                for (Node item:bigCircle) {
                    Circle c=(Circle)item;
                    if(c.getRadius()!=0) {
                        for (Player player : players) {
                            if (c.getCenterX()-30==player.getX() && c.getCenterY()-30==player.getY()){
                                c.setRadius(0);
                                counterSmallCircle+=1;
                                moveGhost=5;
                                break;
                            }
                        }
                    }
                }
            }

            private void contactGhost() {
                int a=0;
                for (Ghost ghost : ghosts) {
                    a+=1;
                    for (Player player : players) {
                        if (Math.abs(ghost.getX()-player.getX())<30 && Math.abs(ghost.getY()-player.getY())<30){
                            if (player.getClass()==CpuPlayer.class){
                                player.setX(120);
                                player.setY(120);
                                player.setV(0);
                                ((CpuPlayer)player).getShape().setFill(Color.rgb(0,0,0,0));
                            }
                            else {
                                if (player.getFeckless()==0) {
                                    if (player.getHeart() == 0) {
                                        PacmanView.menu.gameOver(players, mode);
                                        this.stop();
                                    } else {
                                        player.setHeart(player.getHeart() - 1);
                                        player.setX(120);
                                        player.setY(120);
                                        player.getShape().setCenterX(player.getX() + 30);
                                        player.getShape().setCenterY(player.getY() + 30);
                                        player.setCountMove(player.getCountMove() - 20);
                                        player.setKeyMove(player.getKeyUP());
                                        player.setKeyMoveNow(player.getKeyUP());
                                        player.getShape().setRadius(10);
                                        player.setFeckless(5);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            private void updateScore(){
                if (mode<3) {
                    int score = 0;
                    for (Player player : players) {
                        score += player.getScore();
                    }
                    PacmanController.score.setText("Score: " + score);
                    if (score==smallCircle.size()) {
                        this.stop();
                    }
                }
                else{
                    int score = 0;
                    String ans="";
                    for (Player player : players) {
                        ans+="Score: ";
                        ans+=player.getScore();
                        ans+=" | ";
                        score += player.getScore();
                    }
                    PacmanController.score.setText(ans);
                    if (score==smallCircle.size()) System.out.println("Win");
                }
            }

        };
        EventHandler<KeyEvent> eventHandlerPlayers = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                for (Player player:players) {
                    if (event.getCode() == player.getKeyUP()) {
                        player.setKeyMove(player.getKeyUP());
                        player.setDontMove(false);
                    }
                    else if (event.getCode() == player.getKeyDOWN()) {
                        player.setKeyMove(player.getKeyDOWN());
                        player.setDontMove(false);
                    }
                    else if (event.getCode() == player.getKeyRIGHT()) {
                        player.setKeyMove(player.getKeyRIGHT());
                        player.setDontMove(false);
                    }
                    else if (event.getCode() == player.getKeyLEFT()) {
                        player.setKeyMove(player.getKeyLEFT());
                        player.setDontMove(false);
                    }
                }
                game.start();
            }
        };
        scene.setOnKeyPressed(eventHandlerPlayers);
    }

}
