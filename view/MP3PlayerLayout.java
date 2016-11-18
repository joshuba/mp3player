package mp3player.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import mp3player.business.MP3Player;

/**
 * Created by Leo on 15.11.2016.
 */
public class MP3PlayerLayout extends BorderPane{
    private ViewController viewController;

    public MP3PlayerLayout(double border, double minWidth, Stage stage, MP3Player mp3Player) {
        super();
        this.viewController = new ViewController(mp3Player);


        this.setMinWidth(minWidth);

        //TopLayout
        this.setTop(new TopLayout(border));

        //CenterLayout
        HBox coverBox = new HBox();

        ImageView coverImage = new ImageView("file:music/cover.jpg");

        //coverBox stylen
        coverBox.setAlignment(Pos.CENTER);
        coverImage.setPreserveRatio(true);
        coverImage.fitWidthProperty().bind(stage.widthProperty().subtract(2*border));
        coverImage.fitHeightProperty().bind(stage.heightProperty().subtract(2*border));

        //coverImage.fitHeightProperty().bind(stage.heightProperty());

        //coverBox zusammensetzen
        coverBox.getChildren().setAll(coverImage);

        //src
        this.setCenter(coverBox);

        //BottomLayout
        this.setBottom(new BottomLayout(border,viewController));

    }


}
