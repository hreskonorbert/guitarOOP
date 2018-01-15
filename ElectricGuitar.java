public class ElectricGuitar extends Guitar{
    private boolean isDistorted;
    private String effect;
    AMP amplifier;

    public ElectricGuitar(String manufacturer,String bodyType,String color,int volume,String tuning,boolean isDistorted,String effect,AMP amplifier){
        super(manufacturer, bodyType, color, volume, tuning);
        this.isDistorted=isDistorted;
        this.effect=effect;
        this.amplifier=amplifier;
    }

    //getters for attributes
    public boolean getIsDistorted(){
        return isDistorted;
    }
    public String getEffect(){
        return effect;
    }
    public AMP getAmplifier(){
        return amplifier;
    }

    //setters for attributes
    public void setIsDistorted(boolean isDistorted){
        this.isDistorted=isDistorted;
    }
    public void setEffect(String effect){
        this.effect=effect;
    }
    public void setAmplifier(AMP amplifier){
        this.amplifier=amplifier;
    }
}