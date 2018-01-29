import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;


public class AudioControl{
    
    public static Mixer mixer;
    public static Clip clip;
    
    
    public static void playAudio(String url,float volume){
        Mixer.Info[] mixInfo = AudioSystem.getMixerInfo();
        boolean isOk=false;
        int counter =0;
        while(isOk==false){
            try{

            mixer = AudioSystem.getMixer(mixInfo[counter]);
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
            isOk=true;
            clip.start();
        }catch(Exception e){
            counter++;
        }
    }
        

                
    }
} 