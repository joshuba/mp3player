package mp3player.business;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Leo on 17.11.2016.
 */
public class Track {

    private String title;
    private String artist;
    private String album;
    private String path;

    public Track (String path){
        try {
            Mp3File mp3File = new Mp3File(path);

            this.path = path;
            this.title = mp3File.getId3v2Tag().getTitle();
            this.artist = mp3File.getId3v2Tag().getArtist();
            this.album = mp3File.getId3v2Tag().getAlbum();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getPath() {
        return path;
    }

    public Image getCover(){
        try {
            Mp3File mp3File = new Mp3File(path);

            byte[] coverBytes = mp3File.getId3v2Tag().getAlbumImage();

            BufferedImage coverBuffered = ImageIO.read(new ByteArrayInputStream(coverBytes));

            return SwingFXUtils.toFXImage(coverBuffered, null);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }
}
