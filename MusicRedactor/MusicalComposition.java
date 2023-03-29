package MusicRedactor;
import java.util.Scanner;

public class MusicalComposition {
    
    String songName;
    private String description = "Musical composition is a class which has two subclasses: NoteComposition and Mp3 Composition. Available methods: play(), toString(). ";
    

    public MusicalComposition(String songName){
        this.songName = songName;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public String toString(){
        return "Song name: " + songName +"\nDescription :"+description+"\n";  
    }

    public void play(){
        System.out.println("Playing: " + songName);
    }

    final public void apendDescription(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(description);
        description += scanner.nextLine();
        scanner.close();
    }

    public void printDescription(){
        System.out.println(description);
    }
}
    
