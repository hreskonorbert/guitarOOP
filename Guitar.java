public class Guitar{
    private String manufacturer;
    private String bodyType;
    private String color;
    private int volume;
    private String tuning;
    private static String[] values = new String[4];
    

    public Guitar(String manufacturer,String bodyType,String color,int volume,String tuning){
        this.manufacturer=manufacturer;
        this.bodyType=bodyType;
        this.color=color;
        this.volume=volume;
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
    public int getVolume(){
        return volume;
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
    public void setVolume(int volume){
        this.volume=volume;
    }
    public void setTuning(String tunin){
        this.tuning=tuning;
    }

    //instance methods
    public void playChord(String chord){
        if(volume!=0){
            AudioControl.playAudio( "chords\\clean\\"+chord+".wav",volume-15.0f);
        }
        
        
    }



}