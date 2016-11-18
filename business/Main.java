package mp3player.business;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mp3player.view.MP3PlayerLayout;

/**
 * Created by Leo on 15.11.2016.
 */
public class Main extends Application {

    //efsdfsdfsd

    private Stage primaryStage;
    private final double border = 30.0;
    private final double minWidth = 275;
    private final String root = "music";

    private MP3Player mp3Player;

    @Override
    public void init() throws Exception {
        super.init();
        mp3Player = new MP3Player(root);
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        primaryStage.setTitle("BaBa - Player [closed beta v0x001]");

        MP3PlayerLayout mp3playerLayout = new MP3PlayerLayout(border,minWidth,primaryStage,mp3Player);

        Scene scene = new Scene(mp3playerLayout,400,600);

        primaryStage.setScene(scene);
        primaryStage.setMinWidth(minWidth);
        primaryStage.setMinHeight(550);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }


}
