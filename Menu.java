import java.util.Scanner;
import java.io.IOException;
import java.lang.Runtime;
import javax.sound.sampled.*; 

public class Menu{
   
    
    static String[] mainMenuOptions = {"Guitar Setup","Chords","Exit"};
    static String[] chords = {"A","Am","B","Bm","C","Cm","D","Dm","E","Em","F","Fm","G","Gm"};
    static String[] distortedChords = {"A","D","E","G"};
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
            default:
            System.out.println("\n invalid input");
            try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();}
            mainmenu(guitar);
        }

        
    }


    //Guitar setup menu
    public static void guitarSetupMenu(Guitar guitar){
        clearScreen();
        Scanner reader = new Scanner(System.in);
        for(int i=0;i<guitarSetup.length;i++){
            System.out.println(i+1+". "+guitarSetup[i]+" ["+Guitar.getValue(i)+"]"  );
        }
        System.out.println("0. Back");
        System.out.print("Please enter a number: ");
        int n=reader.nextInt();
        switch(n){
            case 1:
                System.out.print("Set the guitar's volume(0-10): ");
                int vol=reader.nextInt();
                if(Integer.toString(vol).length()<1 || vol < 0 || vol > 10 ){
                    System.out.println("\n Invalid input");
                    try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();}
                    guitarSetupMenu(guitar);
                }
                Guitar.setValues(Integer.toString(vol), 0);
                guitar.setVolume(vol);
                guitarSetupMenu(guitar);
            break;
            case 2:
                System.out.println("\n Not available yet");
                try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();}
                guitarSetupMenu(guitar);
            break;
            case 3:
                Guitar.setValues(Boolean.toString(!Boolean.valueOf(Guitar.getValue(2))), 2);
                Guitar.isDistorted=!(Guitar.isDistorted);
                guitarSetupMenu(guitar);
            break;
            case 4:
                System.out.println("\n Not available yet");
                try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();}
                guitarSetupMenu(guitar);
            break;
            case 0:
                mainmenu(guitar);
            break;
            default:
            System.out.println("\n invalid input");
            try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();}
            guitarSetupMenu(guitar);
        }
    }
    
    
    //Chords menu
    public static void chordsMenu(Guitar guitar){
        clearScreen();
        Scanner chord = new Scanner(System.in);
        if (Guitar.isDistorted==false) {
            for(int i=0;i<chords.length;i++){
                if((i+1)%5==0){
                    System.out.print("["+(i+1)+". "+chords[i]+"]  ");
                    System.out.println();
                    System.out.println();
                }else{
                    System.out.print("["+(i+1)+". "+chords[i]+"]  ");
                }
            }
            System.out.println("\n\n0. Back");

            System.out.print("\nChoose a chord to play: ");
            int n=chord.nextInt();
            if (n>chords.length | n<0){
                System.out.println("\n invalid input");
                try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();}
                chordsMenu(guitar);
            }
            else if (n!=0){
                guitar.playChord(chords[n-1]);
            } else{
                mainmenu(guitar);
            }
            
            
            while(n!=0){
                clearScreen();
                for(int i=0;i<chords.length;i++){
                    if((i+1)%5==0){
                        System.out.print("["+(i+1)+". "+chords[i]+"]  ");
                        System.out.println();
                        System.out.println();

                    }else{
                        System.out.print("["+(i+1)+". "+chords[i]+"]  ");
                    }
                }
                System.out.println("\n\n0. Back");

                System.out.print("\nChoose a chord to play: ");
                n=chord.nextInt();
                if(n==0) mainmenu(guitar);
                guitar.playChord(chords[n-1]);
            }
        }else{
            for(int i=0;i<distortedChords.length;i++){
                if((i+1)%5==0){
                    System.out.print("["+(i+1)+". "+distortedChords[i]+"]  ");
                    System.out.println();
                    System.out.println();
                }else{
                    System.out.print("["+(i+1)+". "+distortedChords[i]+"]  ");
                }
            }
            System.out.println("\n\n0. Back");

            System.out.print("\nChoose a chord to play: ");
            int n=chord.nextInt();
            if (n!=0){
                guitar.playChord(distortedChords[n-1]);
            } else{
                mainmenu(guitar);
            }
            
            
            while(n!=0){
                clearScreen();
                for(int i=0;i<distortedChords.length;i++){
                    if((i+1)%5==0){
                        System.out.print("["+(i+1)+". "+distortedChords[i]+"]  ");
                        System.out.println();
                        System.out.println();

                    }else{
                        System.out.print("["+(i+1)+". "+distortedChords[i]+"]  ");
                    }
                }
                System.out.println("\n\n0. Back");

                System.out.print("\nChoose a chord to play: ");
                n=chord.nextInt();
                if(n==0) mainmenu(guitar);
                guitar.playChord(distortedChords[n-1]);
            }
        }
        
    }
    
    
    //Console clearing method
    public final static void clearScreen(){
        for(int i=0;i<50;i++){
            System.out.println();
        }
    }
}
