import java.io.*;
import javax.sound.sampled.*;

public class Main{
    
    
    public static void main(String[] args){
        
        Guitar fender = new Guitar("fender", "stratocaster", "red", 10, "EADGbe");
        Menu.mainmenu(fender);
    }
}