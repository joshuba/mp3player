package mp3player.view;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import mp3player.business.MP3Player;

/**
 * Created by Leo on 15.11.2016.
 */
public class BottomLayout extends VBox {
    private Button playPause;
    private Button skip;
    private Button previous;
    private Button shuffle;
    private Button playlists;


    private ViewController viewController;

    public BottomLayout(double border,ViewController viewController) {
        super();
        this.viewController = viewController;

        //Volume Control erstellen
        HBox volumeControl = new HBox();

        Button muteButton = new Button("<)=");
        Slider volumeBar = new Slider();

        //Volume Control stylen
        volumeControl.setAlignment(Pos.CENTER_LEFT);
        volumeControl.setHgrow(volumeBar, Priority.ALWAYS);
        volumeControl.setPadding(new Insets(0,border,0,border));
        volumeControl.setSpacing(30);


        //Volume control zusammensetzen
        volumeControl.getChildren().addAll(muteButton,volumeBar);


        //controlButtons erstellen
        HBox controlBar = new HBox();
        previous = new Button("<<");
        playPause = new Button("|>");
        skip = new Button(">>");

        //controlButtons
        controlBar.getChildren().addAll(previous,playPause,skip);

        //ControlButtons stylen
        controlBar.setSpacing(30);
        controlBar.setAlignment(Pos.CENTER);


        //Buttonleiste erstellen
        BorderPane buttonBar = new BorderPane();

        shuffle  = new Button("~~");
        playlists = new Button("**");

        //Buttonleiste stylen
        buttonBar.setPadding(new Insets(border));

        //Buttonleiste zusammensetzen
        buttonBar.setLeft(shuffle);
        buttonBar.setCenter(controlBar);
        buttonBar.setRight(playlists);



        //Alles zusammenfügen
        this.getChildren().addAll(volumeControl,buttonBar);


        //ActionHandler initialisieren
        initHandler();
    }

    private void initHandler(){
        playPause.setOnAction((e) -> viewController.playHandler());
        skip.setOnAction((e) -> viewController.skipHandler());
    }



}
