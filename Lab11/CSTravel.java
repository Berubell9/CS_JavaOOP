import java.util.HashMap;
import java.util.Map;
class Main{
    public static void main(String[] args) {
        CSTravel csTravel = new CSTravel();
        FlightsReservation flight6003 = csTravel.getFlight("cs6003");
        flight6003.showSeating();
        System.out.println("------------");
        boolean isSuccess;
        isSuccess = flight6003.reserveSeat(2,3);
        System.out.println("reserving 2, 3 result = " + isSuccess + "..no change.");
        System.out.println("------------");
        isSuccess = flight6003.reserveSeat(3,1);
        System.out.println("reserving 3, 1 result = " + isSuccess);
    }
}
class CSTravel{
    private Map<String,FlightsReservation> catalog = new HashMap<>();
    private Flights cs6003 = new Flights("cs6003", City.BKK, City.ICN, DayOfWeek.Mon, Time.pm1);
    private Flights cs6004 = new Flights("cs6004", City.BKK, City.ICN, DayOfWeek.Tue, Time.pm2);
    private Flights cs6005 = new Flights("cs6005", City.BKK, City.NRT, DayOfWeek.Wed, Time.pm3);
    private Flights cs6006 = new Flights("cs6006", City.BKK, City.SIN, DayOfWeek.Thr, Time.pm4);
    private Flights cs6007 = new Flights("cs6007", City.ICN, City.BKK, DayOfWeek.Fri, Time.pm5);
    { //executed when new operator is executed …no need constructor
        catalog.put("cs6003", new FlightsReservation(cs6003));
        catalog.put("cs6004", new FlightsReservation(cs6004));
        catalog.put("cs6005", new FlightsReservation(cs6005));
        catalog.put("cs6006", new FlightsReservation(cs6006));
        catalog.put("cs6007", new FlightsReservation(cs6007));
    }
    
    public FlightsReservation getFlight(String code){
        return catalog.get(code);
    }
}