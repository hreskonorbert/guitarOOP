import java.util.Scanner;
import java.io.IOException;
import java.lang.Runtime;
import javax.sound.sampled.*; 

public class Menu{
   
    
    static String[] mainMenuOptions = {"Guitar Setup","Chords","Exit"};
    static String[] chords = {"Am","B","C","Cm","Back"};
    static String[] guitarSetup = {"Volume","Tuning","Distortion","Effect"};
    
    
    //Main menu
    public static void mainmenu(Guitar guitar){
        clearScreen();
        for(int i=0;i<mainMenuOptions.length;i++){
            System.out.println(i+1+" "+mainMenuOptions[i]);
        }
        
        Scanner choice = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int n = choice.nextInt();
        
        switch(n){
            case 1:
                guitarSetupMenu(guitar);
            break;
            
            case 2:
                chordsMenu(guitar);
            break;
            case 3:
                System.exit(0);
            break;
        }

        
    }


    //Guitar setup menu
    public static void guitarSetupMenu(Guitar guitar){
        clearScreen();
        Scanner reader = new Scanner(System.in);
        for(int i=0;i<guitarSetup.length;i++){
            System.out.println(i+1+". "+guitarSetup[i]+" ["+Guitar.getValue(i)+"]");
        }
        System.out.println("5. Back");
        System.out.print("Please enter a number: ");
        int n=reader.nextInt();
        switch(n){
            case 1:
                System.out.print("Set the guitar's volume(0-10): ");
                int vol=reader.nextInt();
                Guitar.setValues(Integer.toString(vol), 0);
                guitar.setVolume(vol);
                guitarSetupMenu(guitar);
            break;
            case 5:
                mainmenu(guitar);
            break;
        }
    }
    
    
    //Chords menu
    public static void chordsMenu(Guitar guitar){
        clearScreen();
        Scanner chord = new Scanner(System.in);
        for(int i=0;i<chords.length;i++){
            System.out.println(i+1+". "+chords[i]);
        }
       

        System.out.print("Choose a chord to play: ");
        int n=chord.nextInt();
        
        guitar.playChord(chords[n-1]);
        
        while(n!=6){
            clearScreen();
            for(int i=0;i<chords.length;i++){
                System.out.println(i+1+". "+chords[i]);
            }
   

            System.out.print("Choose a chord to play: ");
            n=chord.nextInt();
            if(n==5) mainmenu(guitar);
            guitar.playChord(chords[n-1]);
        } 
        
    }
    
    
    //Console clearing method
    public final static void clearScreen(){
        for(int i=0;i<50;i++){
            System.out.println();
        }
    }
}
