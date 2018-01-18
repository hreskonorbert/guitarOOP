public class Guitar{
    private String manufacturer;
    private String bodyType;
    private String color;

    private String tuning;

    static String[] values = new String[5];
    

    public Guitar(String manufacturer,String bodyType,String color,String tuning){
        this.manufacturer=manufacturer;
        this.bodyType=bodyType;
        this.color=color;
        this.tuning=tuning;
    }
    // getters for attributes
    public String getManufacturer(){
        return manufacturer;
    }
    public String getBodyType(){
        return bodyType;
    }
    public String getColor(){
        return color;
    }
 
    public String getTuning(){
        return tuning;
    }
    public static String getValue(int index){
        return values[index];
    }

    //setters for attributes
    public static void setValues(String value,int index){
        values[index]=value;
    }
    public void setManufacturer(String manufacturer){
        this.manufacturer=manufacturer;
    }
    public void setBodyType(String bodyType){
        this.bodyType=bodyType;
    }
    public void setColor(String color){
        this.color=color;
    }
 
    public void setTuning(String tunin){
        this.tuning=tuning;
    }

    public void playChord(String chord, boolean isElectric, AMP amp,Guitar paramGuitar){
        if(isElectric==true){
            ElectricGuitar  eGuitar = (ElectricGuitar)paramGuitar;
            if(amp.getVolume()!=0 && amp.getIsOn()==true){
                if(eGuitar.isDistorted==false){
                    if(eGuitar.effect.equals("reverb")){
                        AudioControl.playAudio( "chords\\clean\\"+chord+".aif",(10-amp.getVolume())*(-3.0f));
                        try{Thread.sleep(500);}catch(Exception e){e.printStackTrace();}
                        AudioControl.playAudio( "chords\\clean\\"+chord+".aif",((10-amp.getVolume())*(-3.0f)-10.0f));
                        try{Thread.sleep(500);}catch(Exception e){e.printStackTrace();}
                        AudioControl.playAudio( "chords\\clean\\"+chord+".aif",((10-amp.getVolume())*(-3.0f)-15.0f));
                    }else{
                        AudioControl.playAudio( "chords\\clean\\"+chord+".aif",(10-amp.getVolume())*(-3.0f));
                    }
                }else{
                    if(eGuitar.effect.equals("reverb")){
                        AudioControl.playAudio( "chords\\distorted\\"+chord+".aif",(10-amp.getVolume())*(-3.0f));
                        try{Thread.sleep(500);}catch(Exception e){e.printStackTrace();}
                        AudioControl.playAudio( "chords\\distorted\\"+chord+".aif",((10-amp.getVolume())*(-3.0f)-10.0f));
                        try{Thread.sleep(500);}catch(Exception e){e.printStackTrace();}
                        AudioControl.playAudio( "chords\\distorted\\"+chord+".aif",((10-amp.getVolume())*(-3.0f)-15.0f));
                    }else{
                        AudioControl.playAudio( "chords\\distorted\\"+chord+".aif",(10-amp.getVolume())*(-3.0f));
                    }
                }
            }
        }else{

            AudioControl.playAudio( "chords\\clean\\"+chord+".aif",(10-amp.getVolume())*(-3.0f));
        }
        
        
        
    }


   
    



}