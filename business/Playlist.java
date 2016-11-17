package mp3player.business;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 * Created by Leo on 17.11.2016.
 */
public class Playlist {
    private ArrayList<Track> trackList = new ArrayList<>();

    private int akt;
    private String root;

    public Playlist(String root) {
        this.akt = 0;
        this.root = root;
        readTracks();
    }

    private void readTracks() {
        File root = new File(this.root);

        File[] mp3Array = root.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".mp3");
            }
        });

        for (File f : mp3Array) {
            trackList.add(new Track(f.getAbsolutePath()));
        }
    }

    public Track getNext() {
        //nächster Song des letzten in Liste -> erster Song in Liste
        return get(++akt % trackList.size());
    }

    public Track getPrev() {
        //"umgekehrtes Modulo"
        if (akt == 0) {
            akt = trackList.size() - 1;
        } else if (akt > 0) {
            akt--;
        }

        return get(akt);

    }

    public Track getRand() {
        return null;
    }

    public Track get(int nr) {
        return trackList.get(nr);
    }

    public Track get(){
        return trackList.get(akt);
    }
}
