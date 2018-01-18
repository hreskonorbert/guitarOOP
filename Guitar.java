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


   
    



}