import java.io.*;
import javax.sound.sampled.*;

public class Main{
    
    
    public static void main(String[] args){
        AePlayWave aw = new AePlayWave( "chords\\Am.wav" );
        aw.start();
    }
}