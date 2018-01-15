import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class VolumeControl{

    public static void decreaseVolume(int num,String path){
        
    try{
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
            new File(path));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        FloatControl gainControl = 
            (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-num); // Reduce volume by 10 decibels.
        clip.start();
    }catch(Exception e){}
    }

    /*public void increaseVolume(int num,String path){
        
        
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
            new File(path));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        FloatControl gainControl = 
            (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(+num); // Reduce volume by 10 decibels.
        clip.start();
    }*/
}