package mp3player.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import mp3player.business.Main;

/**
 * Created by Leo und Josh on 15.11.2016.
 */
public class TopLayout extends VBox {
    public TopLayout(double border) {
        super();


        this.setAlignment(Pos.CENTER);


        //Song - Infos erstellen
        VBox songInfos = new VBox();

        Label title = new Label("Unknown Title");
        Label artist = new Label("Unknown Artist");
        Label album = new Label("Unknown Album");

        //Song - Infos stylen
        songInfos.setAlignment(Pos.CENTER);
        songInfos.setPadding(new Insets(20));

        //Song - Infos hinzufügen
        songInfos.getChildren().addAll(title,artist,album);


        //Fortschrittsbalken erstellen
        HBox progressBarBox = new HBox();
        Slider progressBar = new Slider();

        //Fortschrittsbalken stylen
        progressBarBox.setHgrow(progressBar, Priority.ALWAYS);
        progressBarBox.setAlignment(Pos.CENTER);
        progressBarBox.setPadding(new Insets(0,border,5,border));

        //Fortschrittsbalken zusammensetzen
        progressBarBox.getChildren().add(progressBar);

        //TimeBox erstellen
        AnchorPane timeBox = new AnchorPane();

        Label leftTime = new Label("0:00");
        Label rightTime = new Label("1:25");

        //TimeBox stylen
        timeBox.setLeftAnchor(leftTime,border);
        timeBox.setRightAnchor(rightTime,border);



        //TimeBox zusammensetzen
        timeBox.getChildren().addAll(leftTime,rightTime);


        //Alles zusammenfügen
        this.getChildren().addAll(songInfos,progressBarBox,timeBox);

    }
}
