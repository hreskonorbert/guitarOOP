import java.util.Scanner;
import java.io.IOException;
import java.lang.Runtime;
import javax.sound.sampled.*; 

public class Menu{
   
    
    static String[] mainMenuOptions = {"Guitar Setup","Chords","Songs","Exit"};
    static String[] chords = {"A","Am","B","Bm","C","Cm","D","Dm","E","Em","F","Fm","G","Gm"};
    static String[] distortedChords = {"A","D","E","G"};
    static String[] guitarSetup = {"Volume","Tuning","Distortion","Effect","AMP is On"};
    static String[] songs ={"A borton ablakaba"};
    
    
    //Main menu
    public static void mainmenu(ElectricGuitar guitar,AMP amp){
        clearScreen();

        if(amp.isOn==false){
            System.out.println("AMP is OFF. Go to guitar setup to turn it on\n");
        }

        for(int i=0;i<mainMenuOptions.length;i++){
            System.out.println(i+1+" "+mainMenuOptions[i]);
        }
        
        Scanner choice = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int n = choice.nextInt();
        
        switch(n){
            case 1:
                guitarSetupMenu(guitar,amp);
            break;
            
            case 2:
                chordsMenu(guitar,amp);
            break;
            case 4:
                System.exit(0);
            break;
            case 3:
                songsMenu(amp);
            default:
            System.out.println("\n invalid input");
            try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();}
            mainmenu(guitar,amp);
        }

        
    }


    public static void songsMenu(AMP amp){
        Scanner song = new Scanner(System.in);
        for(int i=0;i<songs.length;i++){
            System.out.println(i+1+". "+songs[i]);
        }
        System.out.print("\nChoose a song to play: ");
        int num=song.nextInt();
        switch(num){
            case 1:
                Songs.playEgyszeruDal(amp);
            break;
        }

    }

    //Guitar setup menu
    public static void guitarSetupMenu(ElectricGuitar guitar,AMP amp){
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
                    guitarSetupMenu(guitar,amp);
                }
                Guitar.setValues(Integer.toString(vol), 0);
                amp.setVolume(vol);
                guitarSetupMenu(guitar,amp);
            break;
            case 2:
                System.out.println("\n Not available yet");
                try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();}
                guitarSetupMenu(guitar,amp);
            break;
            case 3:
                Guitar.setValues(Boolean.toString(!Boolean.valueOf(Guitar.getValue(2))), 2);
                guitar.isDistorted=!(guitar.isDistorted);
                guitarSetupMenu(guitar,amp);
            break;
            case 4:
                System.out.print("\nChoose an effect(none/fuzz/reverb): ");
                String ef=reader.next();
                Guitar.setValues(ef, 3);
                guitar.setEffect(ef);
                guitarSetupMenu(guitar,amp);
            break;
            case 5:
                Guitar.setValues(Boolean.toString(!(amp.getIsOn())), 4);
                amp.setIsOn(!(amp.getIsOn()));
                guitarSetupMenu(guitar,amp);
            case 0:
                mainmenu(guitar,amp);
            break;
            default:
            System.out.println("\n invalid input");
            try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();}
            guitarSetupMenu(guitar,amp);
        }
    }
    
    
    //Chords menu
    public static void chordsMenu(ElectricGuitar guitar, AMP amp){
        clearScreen();
        Scanner chord = new Scanner(System.in);
        if (guitar.isDistorted==false) {
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
                chordsMenu(guitar,amp);
            }
            else if (n!=0){
                guitar.playChord(chords[n-1]);
            } else{
                mainmenu(guitar,amp);
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
                if(n==0) mainmenu(guitar,amp);
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
                mainmenu(guitar,amp);
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
                if(n==0) mainmenu(guitar,amp);
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
