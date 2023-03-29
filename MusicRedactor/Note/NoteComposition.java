package MusicRedactor.Note;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import MusicRedactor.MusicalComposition;

import java.io.File;

public class NoteComposition extends MusicalComposition {

    private int bpm = 120;
    String[] notes;
    int[] noteTypes;

    public NoteComposition(String songName){
        super(songName);
    }

    public void setNotes(String[] notes){
        this.notes = notes;
    }

    public void setNoteTypes(int[] noteTypes){
        this.noteTypes = noteTypes;
    }

    public String[] getNotes(){
        return this.notes;
    }

    public int[] getNoteTypes(){
        return this.noteTypes;
    }

    @Override
    public String toString(){
        String myString = "";
        if(getNotes().length > 0){
            myString += "Notes:\n";
        }
        for(int i = 0; i < getNotes().length; i++){
            myString += getNotes()[i] + " " + getNoteTypes()[i]+ "\n";
        }
        myString += "Bpm: " + bpm + "\n";
        return myString;
    }

    private void playPause(){
        File soundFile = new File("AudioRedactorSounds/notes/pause.wav");
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
            Thread.sleep((int)(60000 / 200 / ((double) 1 / 4)));
            clip.stop();
        } catch (Exception e) {}
    }

    
    public void play(int bpm) {
        this.bpm = bpm;
        play();
    }
    
    @Override
    public void play() {
        super.play();
        playPause();
        for(int i = 0; i < getNotes().length; i++){
            File soundFile = new File("AudioRedactorSounds/notes/"+getNotes()[i]+".wav");
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(soundFile));
                clip.start();
                Thread.sleep((int)(60000 / bpm / ((double) getNoteTypes()[i] / 4)));
                clip.stop();
            } catch (Exception e) {
                System.out.println("Error: file \""+getNotes()[i]+".wav\" doesn't exist.");
            }
        }
    }
    
}
