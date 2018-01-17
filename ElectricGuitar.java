public class ElectricGuitar extends Guitar{

    
    

    public ElectricGuitar(String manufacturer,String bodyType,String color,int volume,String tuning,boolean isDistorted,String effect){
        super(manufacturer, bodyType, color, volume, tuning);
        this.isDistorted=isDistorted;
        this.effect=effect;
        Guitar.setValues(Integer.toString(volume), 0);
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
        Guitar.isDistorted=isDistorted;
    }
    public void setEffect(String effect){
        Guitar.effect=effect;
    }
    
    
}