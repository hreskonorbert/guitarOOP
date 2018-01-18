import java.io.*;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Main{
    
    
    public static void main(String[] args){
        Scanner inputsForGuitar = new Scanner(System.in);
        boolean dist=false;
        boolean electric=false;
        AMP amp = new AMP(10,true);
        
        System.out.print("Manufacturer: ");
        String manufacturer=inputsForGuitar.next();
        System.out.print("\nBody type: ");
        String bodyType=inputsForGuitar.next();
        System.out.print("\nColor: ");
        String color=inputsForGuitar.next();
        System.out.print("\nDefault volume(0-10): ");
        int volume=inputsForGuitar.nextInt();
        System.out.print("\nTuning(EADGbe/DADGbe): ");
        String tuning=inputsForGuitar.next();
        System.out.print("\nDistorted(y/n): ");
        String isDist = inputsForGuitar.next();
        if(isDist.equals("y")) dist=true;
        System.out.print("\nEffect(none/fuzz/reverb): ");
        String effect = inputsForGuitar.next();
      
        ElectricGuitar guitar = new ElectricGuitar(manufacturer, bodyType, color,tuning,amp,dist,effect);
      
        
        Menu.mainmenu(guitar,amp);
    }
}