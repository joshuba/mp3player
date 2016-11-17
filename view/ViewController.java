package mp3player.view;

import mp3player.business.MP3Player;

/**
 * Created by Leo on 17.11.2016.
 */
public class ViewController {
    private MP3Player mp3Player;

    public ViewController(MP3Player mp3Player){
        this.mp3Player = mp3Player;
    }

    //dateiÄnderung

    public void playHandler(){
        mp3Player.play();
        mp3Player.setPlay();

    }
}
