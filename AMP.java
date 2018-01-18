public class AMP{
    int volume;
    boolean isOn;

    public AMP(int volume,boolean isOn){
        this.volume=volume;
        this.isOn=isOn;
        Guitar.setValues(Boolean.toString(isOn), 4);
    }

    public int getVolume(){
        return volume;
    }

    public boolean getIsOn(){
        return isOn;
    }

    public void setVolume(int volume){
        this.volume=volume;
    }

    public void setIsOn(boolean isOn){
        this.isOn=isOn;
        Guitar.setValues(Boolean.toString(isOn), 4);
    }
}