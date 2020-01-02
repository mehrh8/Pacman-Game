package view.pacman;

import controller.pacman.Menu;
import controller.pacman.PacmanController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.pacman.Ghost;
import model.pacman.Ghost1;
import model.pacman.Player;

public class PacmanView extends Application {

    public static Menu menu;
    @Override
    public void start(Stage stage) throws Exception {
        Group root =new Group();
        Scene scene = new Scene(root,1140,780, Color.rgb(0,0,20));
        stage.setScene(scene);
        stage.setTitle("Pacman");
        stage.setResizable(false);
        stage.show();
        menu = new Menu(root,scene,stage);
        /*
        PacmanController controller = new PacmanController(root,scene);
        controller.getMap("Maps\\map1.txt");
        Player player1 = controller.getPlayer(600,300, KeyCode.UP,KeyCode.DOWN,KeyCode.RIGHT,KeyCode.LEFT,Color.GOLD);
        controller.getGhost1(600,540);
        controller.getGhost2(600,540);
        controller.getGhost3(180,180);
        controller.getGhost4(180,180,player1);
        controller.startGame();
         */
    }
}
