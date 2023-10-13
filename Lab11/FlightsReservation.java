// จองไฟต์ไหน นั่งตรงไหน

public class FlightsReservation {
    private Flights flight;
    //private PlaneSeating seating = new Plane22Seating("xx_xx,xx_x^,^x_xx,x^_xx,xx_^x");
    String seatingString = "xx_xx,xx_x^,^x_xx,x^_xx,xx_^x";
    String[] seatingArray = seatingString.split(",");
    private PlaneSeating seating;
    /*  x หมายถึงขายไปแล้ว 
        _ หมายถึงทางเดิน 
        ^ หมายถึงจองได้
        xx_xx
        xx_x^
        ^x_xx
        x^_xx
        xx_^x
     */
    // Constructor
    public FlightsReservation(Flights flight){
        this.flight = flight;
        this.seating = new Plane22Seating(seatingString);
    }
    //setter
    public void setFlights(Flights newFlights){
        flight = newFlights;
    }
    public void setSeating(PlaneSeating newSeating){
        seating = newSeating;
    }
    //getter
    public Flights geFlights(){
        return flight;
    }
    public PlaneSeating geSeating(){
        return seating;
    }
    // เเสดงที่นั่ง
    public void showSeating(){
        for(int i = 0 ;i < seatingArray.length ; i++){
            System.out.println("row "+ (i+1) +" --> "+seatingArray[i]);
        }
    }
    // จองที่นั่ง
    public boolean reserveSeat(int row, int col) {
        for (int i = 0; i < seatingArray.length; i++) {
            String rowSeats = seatingArray[i];
            for (int j = 0; j < rowSeats.length(); j++) {
                if (row == i + 1 && col == j + 1) {
                    char seatChar = rowSeats.charAt(j);
                    if (seatChar == '^') {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
  
}