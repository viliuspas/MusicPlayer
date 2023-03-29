import MusicRedactor.MusicalComposition;
import MusicRedactor.Mp3.Mp3MusicComposition;
import MusicRedactor.Note.NoteComposition;

public class Main {
    public static void main(String[] args){
    
        MusicalComposition sound1 = new NoteComposition("My_Song");
        ((NoteComposition)sound1).setNotes(new String[]{"G", "D", "E", "C"});
        ((NoteComposition)sound1).setNoteTypes(new int[]{4, 8, 4, 4});
        sound1.play();

        MusicalComposition sounds[] = new MusicalComposition[2];

        for(int i = 0; i < 2; i++)
        {
            sounds[i] = new Mp3MusicComposition("sound"+i);
            ((Mp3MusicComposition)sounds[i]).setSongLengthInSeconds(2);
            sounds[i].play();
        }

        MusicalComposition sound2 = new Mp3MusicComposition("Wow");
        ((Mp3MusicComposition)sound2).setSongLengthInSeconds(3);
        sound2.apendDescription();
        sound2.printDescription();
        sound2.play();
    }
}
