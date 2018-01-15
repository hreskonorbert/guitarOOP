public class Guitar{
    private String manufacturer;
    private String bodyType;
    private String color;
    private int volume;
    private String tuning;
    

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

    //setters for attributes
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



}