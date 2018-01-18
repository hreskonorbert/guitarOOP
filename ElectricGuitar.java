public class ElectricGuitar extends Guitar{
    boolean isDistorted;
    String effect;
    AMP amp;

    
    

    public ElectricGuitar(String manufacturer,String bodyType,String color,String tuning,AMP amp,boolean isDistorted,String effect){
        super(manufacturer, bodyType, color,tuning);
        this.isDistorted=isDistorted;
        this.effect=effect;
        this.amp=amp;
        Guitar.setValues(Integer.toString(amp.getVolume()), 0);
        Guitar.setValues(tuning, 1);
        Guitar.setValues(Boolean.toString(isDistorted), 2);
        Guitar.setValues(effect, 3);
        
    }

    //getters for attributes
    public boolean getIsDistorted(){
        return isDistorted;
    }
    public String getEffect(){
        return effect;
    }
    

    //setters for attributes
    public void setIsDistorted(boolean isDistorted){
        this.isDistorted=isDistorted;
    }
    public void setEffect(String effect){
        this.effect=effect;
    }

    
    
    
}