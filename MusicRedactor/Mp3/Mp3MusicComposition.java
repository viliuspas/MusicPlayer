package MusicRedactor.Mp3;
import MusicRedactor.MusicalComposition;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import javax.sound.sampled.AudioInputStream;

public class Mp3MusicComposition extends MusicalComposition {

    private int songLengthInSeconds;
    private String songName;

    public Mp3MusicComposition(String songName){
        super(songName);
        this.songName = songName;
        getDefaultSongLength();
    }

    public void setSongLengthInSeconds(int songLengthInSeconds){
        this.songLengthInSeconds = songLengthInSeconds;
    }

    public int getSongLengthInSeconds(){
        return this.songLengthInSeconds;
    }

    private void getDefaultSongLength(){
        File soundFile = new File("AudioRedactorSounds/"+songName+".wav");
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            setSongLengthInSeconds((int)clip.getMicrosecondLength() / 1000 / 1000);
        } catch (Exception e) {}
    }

    @Override
    public String toString(){
        return "Song Name: "+songName+"\nSongLength: "+songLengthInSeconds+" seconds.";
    }

    @Override
    public void play() {
        System.out.println("");
        super.play();
        File soundFile = new File("AudioRedactorSounds/"+songName+".wav");
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep((long) ((songLengthInSeconds) * 1000));
            clip.stop();
        } catch (Exception e) {
            System.out.println("Error: file \""+songName+".wav\" doesn't exist.");
        }
    }    
    
}
