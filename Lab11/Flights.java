public class Flights {
    private String code;
    private City source;
    private City destination;
    private DayOfWeek day;
    private Time departTime;
    // Constructor
    public Flights(String code,City source,City destination,DayOfWeek day,Time departTime){
        this.code = code;
        this.source = source;
        this.destination = destination;
        this.day = day;
        this.departTime = departTime;
    }
    //setter
    public void setCode(String newCode){
        code = newCode;
    }
    public void setSource(City newSource){
        source = newSource;
    }
    public void setDestination(City newDestination){
        destination = newDestination;
    }
    public void setDay(DayOfWeek newDay){
        day = newDay;
    }
    public void setDepartTime(Time newDepartTime){
        departTime = newDepartTime;
    }
    //getter
    public String getCode(){
        return code;
    }
    public City getSource(){
        return source;
    }
    public City getDestination(){
        return destination;
    }
    public DayOfWeek getDay(){
        return day;
    }
    public Time getDepartTime(){
        return departTime;
    }
    public String toString(){
        return "Flights ["+getCode()+" ,"+getSource()+" to"+getDestination()+" ,"+getDay()+" ,Time = "+getDepartTime()+" ]";
    }
}
