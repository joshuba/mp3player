package mp3player.business;

import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;

/**
 * Created by BaBaAG on 17.11.2016.
 */
public class MP3Player {
    private String root;
    private Playlist playlist;
    private boolean play;

    private SimpleMinim simpleMinim;
    private SimpleAudioPlayer player;
    Track aktTrack;

    public MP3Player(String root) {
        this.root = root;
        this.playlist = new Playlist(root);
        this.play = false;

        simpleMinim = new SimpleMinim(true);
        aktTrack = playlist.get();
    }

    public void play() {

        if (player == null){

            player = simpleMinim.loadMP3File(aktTrack.getPath());
        }
        player.play();

    }

    public void play(Track t){

        simpleMinim.stop();

        setAktTrack(t);
        player.play();
    }

    //MP3Player beenden
    public void stop() {
        simpleMinim.stop();
    }

    public void pause() {
        player.pause();
    }

    public void skip() {
        aktTrack = playlist.getNext();
            if(play) {
                play(aktTrack);
            }else{
                setAktTrack(aktTrack);
            }
        }

    public void previous() {
        aktTrack = playlist.getPrev();
        if(play) {
            play(aktTrack);
        }else{
            setAktTrack(aktTrack);
        }
    }

    private void setAktTrack(Track t){
        aktTrack = t;
        player = simpleMinim.loadMP3File(t.getPath());
    }

    public void setPlay() {
        play = !play;
    }

    public boolean getPlay(){ return play; }

}
