import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;


public class AudioControl{
    
    public static Mixer mixer;
    public static Clip clip;
    
    
    public static void playAudio(String url,float volume){
        Mixer.Info[] mixInfo = AudioSystem.getMixerInfo();
        
        mixer = AudioSystem.getMixer(mixInfo[0]);
        DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
        try{
            clip = (Clip)mixer.getLine(dataInfo);
        }catch(LineUnavailableException e){
            e.printStackTrace();
        }

        try{
            URL soundUrl = Main.class.getResource(url);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundUrl);
            clip.open(audioStream);
        }catch(LineUnavailableException e){
            e.printStackTrace();
        }catch(UnsupportedAudioFileException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(volume);

        clip.start();
        
    }
} 