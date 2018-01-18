import java.io.*;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Main{
    
    
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        boolean dist=false;
        
        AMP amp = new AMP(10,false);

        Guitar eGuitar =new ElectricGuitar("Fender","Stratocaster","red","EADGbe",amp,false,"none");
        Guitar guitar =new AcousticGuitar("Cort", "Dreadnought", "Red", "EADGbe");
        
        System.out.println("Choose a guitar");
        System.out.println("1. "+eGuitar.getManufacturer()+" Electric guitar");
        System.out.println("2. "+guitar.getManufacturer()+" Acoustic guitar");
        int choice = reader.nextInt();
        switch(choice){
            case 1:
            Menu.mainmenu(eGuitar,amp);
            break;
            case 2:
            Menu.mainmenu(guitar,amp);
            break;
        }
      
      
        
        
    }
}