import java.io.*;
import javax.sound.sampled.*;

public class Main{
    
    
    public static void main(String[] args){
     
       
      
        Guitar fender = new ElectricGuitar("fender", "stratocaster", "red", 10, "EADGbe",false,"none");
        Menu.mainmenu(fender);
    }
}