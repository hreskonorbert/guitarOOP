import java.util.Scanner;

public class Songs{

    public static void playEgyszeruDal(AMP amp){
            
            try{
            while(System.in.available()==0){
            
                    AudioControl.playAudio( "chords\\clean\\G.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(550);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\G.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\G.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(550);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\G.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\G.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\G.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\Em.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(550);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\Em.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\Em.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(550);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\Em.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\Em.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\Em.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\C.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(550);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\C.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\C.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(550);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\C.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\C.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\C.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\D.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(550);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\D.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\D.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(550);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\D.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\D.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
                    AudioControl.playAudio( "chords\\clean\\D.aif",(10-amp.getVolume())*(-3.0f));
                    try{Thread.sleep(300);}catch(Exception e){e.printStackTrace();}
            }
        }catch(Exception e){Menu.songsMenu(amp);}
        
       
    
        
    }
}