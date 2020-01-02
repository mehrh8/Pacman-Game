package controller.pacman;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.pacman.CpuPlayer;
import model.pacman.Player;

import java.util.ArrayList;

public class Menu {
    private Group root;
    private Scene scene;
    private Stage stage;

    public Menu(Group root, Scene scene,Stage stage) {
        this.root = root;
        this.scene = scene;
        this.stage = stage;
        startMenu();
    }

    public void startMenu(){
        root =new Group();
        scene = new Scene(root,1140,780, Color.rgb(0,0,20));
        stage.setScene(scene);
        Text startMenuTitle = new Text();
        startMenuTitle.setText("Start Menu");
        startMenuTitle.setLayoutX(40);
        startMenuTitle.setLayoutY(150);
        startMenuTitle.setFont(new Font("tahoma",30));
        startMenuTitle.setFill(Color.HOTPINK);
        root.getChildren().add(startMenuTitle);

        //  Map Menu
        Text mapMenu =new Text();
        mapMenu.setText("Map:\t\t <- U\t\t\t\t\t\t\t\t\t\t\t\t\t\t I ->");
        mapMenu.setLayoutX(40);
        mapMenu.setLayoutY(220);
        mapMenu.setFont(new Font("tahoma",25));
        mapMenu.setFill(Color.HOTPINK);
        root.getChildren().add(mapMenu);

        ArrayList<Text> mapMenuItems = new ArrayList<Text>();
        Text mapMenuItem1 = new Text(); //Item 1
        mapMenuItem1.setText("Map 1");
        mapMenuItem1.setLayoutX(300);
        mapMenuItem1.setLayoutY(220);
        mapMenuItem1.setFont(new Font("tahoma",25));
        mapMenuItem1.setFill(Color.CADETBLUE);
        root.getChildren().add(mapMenuItem1);
        mapMenuItems.add(mapMenuItem1);
        Text mapMenuItem2 = new Text(); //Item 2
        mapMenuItem2.setText("Map 2");
        mapMenuItem2.setLayoutX(500);
        mapMenuItem2.setLayoutY(220);
        mapMenuItem2.setFont(new Font("tahoma",25));
        mapMenuItem2.setFill(Color.HOTPINK);
        root.getChildren().add(mapMenuItem2);
        mapMenuItems.add(mapMenuItem2);
        Text mapMenuItem3 = new Text(); //Item 3
        mapMenuItem3.setText("Map 3");
        mapMenuItem3.setLayoutX(700);
        mapMenuItem3.setLayoutY(220);
        mapMenuItem3.setFont(new Font("tahoma",25));
        mapMenuItem3.setFill(Color.HOTPINK);
        root.getChildren().add(mapMenuItem3);
        mapMenuItems.add(mapMenuItem3);

        //  Mode Menu
        Text modeMenu = new Text();
        modeMenu.setText("Mode:\t <- J\t\t\t\t\t\t\t\t\t\t\t\t\t\t K ->");
        modeMenu.setLayoutX(40);
        modeMenu.setLayoutY(290);
        modeMenu.setFont(new Font("tahoma",25));
        modeMenu.setFill(Color.HOTPINK);
        root.getChildren().add(modeMenu);

        ArrayList<Text> modeMenuItems = new ArrayList<Text>();
        Text modeMenuItem1 = new Text(); //Item 1
        modeMenuItem1.setText("1 Player");
        modeMenuItem1.setLayoutX(300);
        modeMenuItem1.setLayoutY(290);
        modeMenuItem1.setFont(new Font("tahoma",25));
        modeMenuItem1.setFill(Color.CADETBLUE);
        root.getChildren().add(modeMenuItem1);
        modeMenuItems.add(modeMenuItem1);
        Text modeMenuItem2 = new Text(); //Item 2
        modeMenuItem2.setText("Player vs CPU (F)");
        modeMenuItem2.setLayoutX(500);
        modeMenuItem2.setLayoutY(290);
        modeMenuItem2.setFont(new Font("tahoma",25));
        modeMenuItem2.setFill(Color.HOTPINK);
        root.getChildren().add(modeMenuItem2);
        modeMenuItems.add(modeMenuItem2);
        Text modeMenuItem3 = new Text(); //Item 3
        modeMenuItem3.setText("2 Players (F)");
        modeMenuItem3.setLayoutX(700);
        modeMenuItem3.setLayoutY(290);
        modeMenuItem3.setFont(new Font("tahoma",25));
        modeMenuItem3.setFill(Color.HOTPINK);
        root.getChildren().add(modeMenuItem3);
        modeMenuItems.add(modeMenuItem3);
        Text modeMenuItem4 = new Text(); //Item 4
        modeMenuItem4.setText("2 Player (R)");
        modeMenuItem4.setLayoutX(900);
        modeMenuItem4.setLayoutY(290);
        modeMenuItem4.setFont(new Font("tahoma",25));
        modeMenuItem4.setFill(Color.HOTPINK);
        root.getChildren().add(modeMenuItem4);
        modeMenuItems.add(modeMenuItem4);

        // Level Menu
        Text levelMenu = new Text();
        levelMenu.setText("Level:\t <- N\t\t\t\t\t\t\t\t\t\t\t\t\t\t M ->");
        levelMenu.setLayoutX(40);
        levelMenu.setLayoutY(360);
        levelMenu.setFont(new Font("tahoma",25));
        levelMenu.setFill(Color.HOTPINK);
        root.getChildren().add(levelMenu);

        ArrayList<Text> levelMenuItems = new ArrayList<Text>();
        Text levelMenuItem1 = new Text(); //Item 1
        levelMenuItem1.setText("Easy");
        levelMenuItem1.setLayoutX(300);
        levelMenuItem1.setLayoutY(360);
        levelMenuItem1.setFont(new Font("tahoma",25));
        levelMenuItem1.setFill(Color.CADETBLUE);
        root.getChildren().add(levelMenuItem1);
        levelMenuItems.add(levelMenuItem1);
        Text levelMenuItem2 = new Text(); //Item 2
        levelMenuItem2.setText("Hard");
        levelMenuItem2.setLayoutX(500);
        levelMenuItem2.setLayoutY(360);
        levelMenuItem2.setFont(new Font("tahoma",25));
        levelMenuItem2.setFill(Color.HOTPINK);
        root.getChildren().add(levelMenuItem2);
        levelMenuItems.add(levelMenuItem2);

        // Background Menu
        Text backgroundColorMenu = new Text();
        backgroundColorMenu.setText("BG:\t\t <- T\t\t\t\t\t\t\t\t\t\t\t\t\t\t Y ->");
        backgroundColorMenu.setLayoutX(40);
        backgroundColorMenu.setLayoutY(430);
        backgroundColorMenu.setFont(new Font("tahoma",25));
        backgroundColorMenu.setFill(Color.HOTPINK);
        root.getChildren().add(backgroundColorMenu);

        ArrayList<Text> backgroundColorMenuItems = new ArrayList<Text>();
        Text backgroundColorMenuItem1 = new Text(); //Item 1
        backgroundColorMenuItem1.setText("Black");
        backgroundColorMenuItem1.setLayoutX(300);
        backgroundColorMenuItem1.setLayoutY(430);
        backgroundColorMenuItem1.setFont(new Font("tahoma",25));
        backgroundColorMenuItem1.setFill(Color.CADETBLUE);
        root.getChildren().add(backgroundColorMenuItem1);
        backgroundColorMenuItems.add(backgroundColorMenuItem1);
        Text backgroundColorMenuItem2 = new Text(); //Item 2
        backgroundColorMenuItem2.setText("Navy");
        backgroundColorMenuItem2.setLayoutX(500);
        backgroundColorMenuItem2.setLayoutY(430);
        backgroundColorMenuItem2.setFont(new Font("tahoma",25));
        backgroundColorMenuItem2.setFill(Color.HOTPINK);
        root.getChildren().add(backgroundColorMenuItem2);
        backgroundColorMenuItems.add(backgroundColorMenuItem2);

        // Player1 Menu
        Text player1ColorMenu = new Text();
        player1ColorMenu.setText("Player1:\t <- G\t\t\t\t\t\t\t\t\t\t\t\t\t\t H ->");
        player1ColorMenu.setLayoutX(40);
        player1ColorMenu.setLayoutY(500);
        player1ColorMenu.setFont(new Font("tahoma",25));
        player1ColorMenu.setFill(Color.HOTPINK);
        root.getChildren().add(player1ColorMenu);

        ArrayList<Text> player1ColorMenuItems = new ArrayList<Text>();
        Text player1ColorMenuItem1 = new Text(); //Item 1
        player1ColorMenuItem1.setText("Gold");
        player1ColorMenuItem1.setLayoutX(300);
        player1ColorMenuItem1.setLayoutY(500);
        player1ColorMenuItem1.setFont(new Font("tahoma",25));
        player1ColorMenuItem1.setFill(Color.CADETBLUE);
        root.getChildren().add(player1ColorMenuItem1);
        player1ColorMenuItems.add(player1ColorMenuItem1);
        Text player1ColorMenuItem2 = new Text(); //Item 2
        player1ColorMenuItem2.setText("Light Green");
        player1ColorMenuItem2.setLayoutX(500);
        player1ColorMenuItem2.setLayoutY(500);
        player1ColorMenuItem2.setFont(new Font("tahoma",25));
        player1ColorMenuItem2.setFill(Color.HOTPINK);
        root.getChildren().add(player1ColorMenuItem2);
        player1ColorMenuItems.add(player1ColorMenuItem2);
        Text player1ColorMenuItem3 = new Text(); //Item 3
        player1ColorMenuItem3.setText("Red");
        player1ColorMenuItem3.setLayoutX(700);
        player1ColorMenuItem3.setLayoutY(500);
        player1ColorMenuItem3.setFont(new Font("tahoma",25));
        player1ColorMenuItem3.setFill(Color.HOTPINK);
        root.getChildren().add(player1ColorMenuItem3);
        player1ColorMenuItems.add(player1ColorMenuItem3);

        // Player2 Menu
        Text player2ColorMenu = new Text();
        player2ColorMenu.setText("Player2:\t <- V \t\t\t\t\t\t\t\t\t\t\t\t\t B ->");
        player2ColorMenu.setLayoutX(40);
        player2ColorMenu.setLayoutY(570);
        player2ColorMenu.setFont(new Font("tahoma",25));
        player2ColorMenu.setFill(Color.HOTPINK);
        root.getChildren().add(player2ColorMenu);

        ArrayList<Text> player2ColorMenuItems = new ArrayList<Text>();
        Text player2ColorMenuItem1 = new Text(); //Item 1
        player2ColorMenuItem1.setText("Gold");
        player2ColorMenuItem1.setLayoutX(300);
        player2ColorMenuItem1.setLayoutY(570);
        player2ColorMenuItem1.setFont(new Font("tahoma",25));
        player2ColorMenuItem1.setFill(Color.HOTPINK);
        root.getChildren().add(player2ColorMenuItem1);
        player2ColorMenuItems.add(player2ColorMenuItem1);
        Text player2ColorMenuItem2 = new Text(); //Item 2
        player2ColorMenuItem2.setText("Light Green");
        player2ColorMenuItem2.setLayoutX(500);
        player2ColorMenuItem2.setLayoutY(570);
        player2ColorMenuItem2.setFont(new Font("tahoma",25));
        player2ColorMenuItem2.setFill(Color.HOTPINK);
        root.getChildren().add(player2ColorMenuItem2);
        player2ColorMenuItems.add(player2ColorMenuItem2);
        Text player2ColorMenuItem3 = new Text(); //Item 3
        player2ColorMenuItem3.setText("Red");
        player2ColorMenuItem3.setLayoutX(700);
        player2ColorMenuItem3.setLayoutY(570);
        player2ColorMenuItem3.setFont(new Font("tahoma",25));
        player2ColorMenuItem3.setFill(Color.CADETBLUE);
        root.getChildren().add(player2ColorMenuItem3);
        player2ColorMenuItems.add(player2ColorMenuItem3);

        Text enterMenu = new Text();
        enterMenu.setText("Play(enter)");
        enterMenu.setLayoutX(40);
        enterMenu.setLayoutY(640);
        enterMenu.setFont(new Font("tahoma",30));
        enterMenu.setFill(Color.HOTPINK);
        root.getChildren().add(enterMenu);

        int[] indexMenu = {0,0,0,0,0,2};

        EventHandler<KeyEvent> eventHandlerMenu = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.I)
                {
                    if (indexMenu[0]!=mapMenuItems.size()-1){
                        mapMenuItems.get(indexMenu[0]).setFill(Color.HOTPINK);
                        indexMenu[0]+=1;
                        mapMenuItems.get(indexMenu[0]).setFill(Color.CADETBLUE);
                    }
                }
                else if (event.getCode() == KeyCode.U){
                    if (indexMenu[0]!=0){
                        mapMenuItems.get(indexMenu[0]).setFill(Color.HOTPINK);
                        indexMenu[0]-=1;
                        mapMenuItems.get(indexMenu[0]).setFill(Color.CADETBLUE);
                    }
                }
                else if (event.getCode() == KeyCode.K){
                    if (indexMenu[1]!=modeMenuItems.size()-1){
                        modeMenuItems.get(indexMenu[1]).setFill(Color.HOTPINK);
                        indexMenu[1]+=1;
                        modeMenuItems.get(indexMenu[1]).setFill(Color.CADETBLUE);
                    }
                }
                else if (event.getCode() == KeyCode.J){
                    if (indexMenu[1]!=0){
                        modeMenuItems.get(indexMenu[1]).setFill(Color.HOTPINK);
                        indexMenu[1]-=1;
                        modeMenuItems.get(indexMenu[1]).setFill(Color.CADETBLUE);
                    }
                }
                else if (event.getCode() == KeyCode.M){
                    if (indexMenu[2]!=levelMenuItems.size()-1){
                        levelMenuItems.get(indexMenu[2]).setFill(Color.HOTPINK);
                        indexMenu[2]+=1;
                        levelMenuItems.get(indexMenu[2]).setFill(Color.CADETBLUE);
                    }
                }
                else if (event.getCode() == KeyCode.N){
                    if (indexMenu[2]!=0){
                        levelMenuItems.get(indexMenu[2]).setFill(Color.HOTPINK);
                        indexMenu[2]-=1;
                        levelMenuItems.get(indexMenu[2]).setFill(Color.CADETBLUE);
                    }
                }
                else if (event.getCode() == KeyCode.Y){
                    if (indexMenu[3]!=backgroundColorMenuItems.size()-1){
                        backgroundColorMenuItems.get(indexMenu[3]).setFill(Color.HOTPINK);
                        indexMenu[3]+=1;
                        backgroundColorMenuItems.get(indexMenu[3]).setFill(Color.CADETBLUE);
                    }
                }
                else if (event.getCode() == KeyCode.T){
                    if (indexMenu[3]!=0){
                        backgroundColorMenuItems.get(indexMenu[3]).setFill(Color.HOTPINK);
                        indexMenu[3]-=1;
                        backgroundColorMenuItems.get(indexMenu[3]).setFill(Color.CADETBLUE);
                    }
                }
                else if (event.getCode() == KeyCode.H){
                    if (indexMenu[4]!=player1ColorMenuItems.size()-1){
                        player1ColorMenuItems.get(indexMenu[4]).setFill(Color.HOTPINK);
                        indexMenu[4]+=1;
                        player1ColorMenuItems.get(indexMenu[4]).setFill(Color.CADETBLUE);
                    }
                }
                else if (event.getCode() == KeyCode.G){
                    if (indexMenu[4]!=0){
                        player1ColorMenuItems.get(indexMenu[4]).setFill(Color.HOTPINK);
                        indexMenu[4]-=1;
                        player1ColorMenuItems.get(indexMenu[4]).setFill(Color.CADETBLUE);
                    }
                }
                else if (event.getCode() == KeyCode.B){
                    if (indexMenu[5]!=player2ColorMenuItems.size()-1){
                        player2ColorMenuItems.get(indexMenu[5]).setFill(Color.HOTPINK);
                        indexMenu[5]+=1;
                        player2ColorMenuItems.get(indexMenu[5]).setFill(Color.CADETBLUE);
                    }
                }
                else if (event.getCode() == KeyCode.V){
                    if (indexMenu[5]!=0){
                        player2ColorMenuItems.get(indexMenu[5]).setFill(Color.HOTPINK);
                        indexMenu[5]-=1;
                        player2ColorMenuItems.get(indexMenu[5]).setFill(Color.CADETBLUE);
                    }
                }
                else if (event.getCode() == KeyCode.ENTER){
                    startGame(indexMenu);
                    System.out.println(132);
                }
            }
        };
        scene.setOnKeyPressed(eventHandlerMenu);
    }
    public void startGame(int[] indexMenu){
        root =new Group();
        if (indexMenu[3]==0) scene = new Scene(root,1140,780, Color.rgb(0,0,20));
        else if (indexMenu[3]==1) scene = new Scene(root,1140,780, Color.NAVY);
        stage.setScene(scene);
        PacmanController controller = new PacmanController(root,scene,indexMenu[1]);

        if (indexMenu[0]==0) controller.getMap("Maps\\map1.txt");
        else if (indexMenu[0]==1) controller.getMap("Maps\\map2.txt");
        else if (indexMenu[0]==2) controller.getMap("Maps\\map3.txt");
        else System.out.println("Error: Not Map");

        controller.getScore();
        Color colorPlayer1=Color.GOLD;
        if (indexMenu[4]==0) colorPlayer1=Color.GOLD;
        else if (indexMenu[4]==1) colorPlayer1=Color.LIGHTGREEN;
        else if (indexMenu[4]==2) colorPlayer1=Color.RED;

        Color colorPlayer2=Color.GOLD;
        if (indexMenu[5]==0) colorPlayer2=Color.GOLD;
        else if (indexMenu[5]==1) colorPlayer2=Color.LIGHTGREEN;
        else if (indexMenu[5]==2) colorPlayer2=Color.RED;

        if (indexMenu[1]==0) controller.getPlayer(300,60,KeyCode.UP,KeyCode.DOWN,KeyCode.RIGHT,KeyCode.LEFT,colorPlayer1);
        else if (indexMenu[1]==1){
            controller.getPlayer(300,60,KeyCode.UP,KeyCode.DOWN,KeyCode.RIGHT,KeyCode.LEFT,colorPlayer1);
            controller.getCpuPlayer(600,60,colorPlayer2);
        }
        else if (indexMenu[1]==2 || indexMenu[1]==3){
            controller.getPlayer(600,60,KeyCode.UP,KeyCode.DOWN,KeyCode.RIGHT,KeyCode.LEFT,colorPlayer1);
            controller.getPlayer(300,60,KeyCode.W,KeyCode.S,KeyCode.D,KeyCode.A,colorPlayer2);
        }
        if (indexMenu[2]==0){
            controller.getGhost1(420,60);
            controller.getGhost1(420,660);
            controller.getGhost1(420,300);
            controller.getGhost2(60,660);
            controller.getGhost2(900,300);
            controller.getGhost3(420,480);
            ArrayList<Player> players=controller.getPlayers();
            for (Player player:players) {
                if (player.getClass()!= CpuPlayer.class){
                    controller.getGhost4(420,420,player);
                }
            }
        }
        else if (indexMenu[2]==1){
            controller.getGhost1(420,60);
            controller.getGhost2(60,660);
            controller.getGhost3(420,480);
            controller.getGhost3(540,480);
            ArrayList<Player> players=controller.getPlayers();
            for (Player player:players) {
                if (player.getClass()!= CpuPlayer.class){
                    controller.getGhost4(420,420,player);
                    controller.getGhost4(900,540,player);
                }
            }
        }
        controller.startGame();
    }
    public void gameOver(ArrayList<Player> players,int mode){
        root =new Group();
        scene = new Scene(root,1140,780, Color.rgb(0,0,20));
        stage.setScene(scene);
        Text gameOver = new Text();
        gameOver.setText("Game Over");
        gameOver.setLayoutX(440);
        gameOver.setLayoutY(360);
        gameOver.setFont(new Font("tahoma",60));
        gameOver.setFill(Color.HOTPINK);
        root.getChildren().add(gameOver);
        if (mode<3){
            Text score= new Text();
            int s=0;
            for (Player player:players) {
                s+=player.getScore();
            }
            score.setText("Score: "+s);
            score.setLayoutX(440);
            score.setLayoutY(200);
            score.setFont(new Font("tahoma",30));
            score.setFill(Color.HOTPINK);
            root.getChildren().add(score);
        }
        else {
            Text score= new Text();
            String s="";
            int i=0;
            int m=0;
            for (Player player:players) {
                if (player.getClass() != CpuPlayer.class) {
                    i += 1;
                    if (player.getHeart() == 0) {
                        m = 1;
                        break;
                    }
                }
            }
            if (m==1) {
                if (i == 1) {
                    s += "\n **Player 2 WIN**";
                } else if (i == 2) {
                    s += "\n **Player 1 WIN**";
                }
            }
            else {
                i=0;
                for (Player player : players) {
                    if (player.getClass() != CpuPlayer.class) {
                        if (player.getScore() > m) {
                            i++;
                            m = player.getScore();
                        }
                    }
                }
                if (i == 1) {
                    s += "\n **Player 1 WIN**";
                } else if (i == 2) {
                    s += "\n **Player 2 WIN**";
                }
            }
            score.setText(s);
            score.setLayoutX(440);
            score.setLayoutY(200);
            score.setFont(new Font("tahoma",30));
            score.setFill(Color.HOTPINK);
            root.getChildren().add(score);
        }
        Text start = new Text();
        start.setText("Start(ESC)");
        start.setLayoutX(440);
        start.setLayoutY(500);
        start.setFont(new Font("tahoma",30));
        start.setFill(Color.HOTPINK);
        root.getChildren().add(start);
        EventHandler<KeyEvent> eventHandlerA = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE) startMenu();
            }
        };
        scene.setOnKeyPressed(eventHandlerA);
    }
}
