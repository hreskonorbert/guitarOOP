public class ElectricGuitar extends Guitar{
    private boolean distorted;
    private String effect;
    AMP amplifier;

    public ElectricGuitar(String manufacturer,String bodyType,String color,int volume,String tuning,boolean distorted,String effect,AMP amplifier){
        super(manufacturer, bodyType, color, volume, tuning);
        this.distorted=distorted;
        this.effect=effect;
        this.amplifier=amplifier;
    }
}