import java.util.Scanner;
import java.io.IOException;
import java.lang.Runtime;
import javax.sound.sampled.*; 

public class Menu{
   
    
    static String[] mainMenuOptions = {"Guitar Setup","Chords","Songs","Exit"};
    static String[] chords = {"A","Am","B","Bm","C","Cm","D","Dm","E","Em","F","Fm","G","Gm"};
    static String[] distortedChords = {"A","Am","B","Bm","C","Cm","D","Dm","E","Em","F","Fm","G","Gm"};
    static String[] guitarSetup = {"Volume","Tuning","Distortion","Effect","AMP is On"};
    static String[] songs ={"A borton ablakaba"};
    
    
    //Main menu
    public static void mainmenu(Guitar guitar,AMP amp){
        clearScreen();
        if(guitar instanceof ElectricGuitar){
            ElectricGuitar eGuitar = (ElectricGuitar)guitar;
            
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
                    guitarSetupMenu(eGuitar,amp);
                break;
                
                case 2:
                    chordsMenu(eGuitar,amp);
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
        }else{
            AcousticGuitar aGuitar = (AcousticGuitar)guitar;
            Scanner acousticMenu = new Scanner(System.in);
            System.out.println("1. Chords");
            System.out.println("2. Songs");
            System.out.println("3. exit");
            System.out.print("Choose an option: ");
            int l = acousticMenu.nextInt();
            switch(l){
                case 1:
                    chordsMenu(aGuitar, amp);
                break;
                case 2:
                    songsMenu(amp);
                break;
                case 3:
                    System.exit(0);
                break;
            }
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
                System.out.print("\nChoose an effect(none/reverb): ");
                String ef=reader.next();
                while((ef.equals("none") || ef.equals("reverb"))==false){
                    System.out.println("Invalid effect");
                    System.out.print("\nChoose an effect(none/reverb): ");
                    ef=reader.next();
                    
                }
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
    public static void chordsMenu(Guitar guitar, AMP amp){
        clearScreen();
        if(guitar instanceof ElectricGuitar){
            ElectricGuitar eGuitar = (ElectricGuitar)guitar;
        
        Scanner chord = new Scanner(System.in);
        if (eGuitar.isDistorted==false) {
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
                eGuitar.playChord(chords[n-1],true,amp,eGuitar);
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
                eGuitar.playChord(chords[n-1],true,amp,eGuitar);
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
                eGuitar.playChord(distortedChords[n-1],true,amp,eGuitar);
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
                eGuitar.playChord(distortedChords[n-1],true,amp,eGuitar);
            }
        }
    }else{
        Scanner aChord = new Scanner(System.in);
        AcousticGuitar aGuitar = (AcousticGuitar)guitar;
        for(int k=0;k<chords.length;k++){
            if((k+1)%5==0){
                System.out.print("["+(k+1)+". "+chords[k]+"]  ");
                System.out.println();
                System.out.println();

            }else{
                System.out.print("["+(k+1)+". "+chords[k]+"]  ");
            }
        }
        System.out.println("\n\n0. Back");
            
            
            System.out.print("\nChoose a chord to play: ");
            int n=aChord.nextInt();
            if (n>chords.length | n<0){
                System.out.println("\n invalid input");
                try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();}
                chordsMenu(aGuitar,amp);
            }
            else if (n!=0){
                aGuitar.playChord(chords[n-1],false,amp,aGuitar);
            } else{
                mainmenu(aGuitar,amp);
            }

            while(n!=0){
                clearScreen();
                for(int k=0;k<chords.length;k++){
                    if((k+1)%5==0){
                        System.out.print("["+(k+1)+". "+chords[k]+"]  ");
                        System.out.println();
                        System.out.println();

                    }else{
                        System.out.print("["+(k+1)+". "+chords[k]+"]  ");
                    }
                }
                System.out.println("\n\n0. Back");

                System.out.print("\nChoose a chord to play: ");
                n=aChord.nextInt();
                if(n==0) mainmenu(guitar,amp);
                aGuitar.playChord(chords[n-1],false,amp,aGuitar);
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
