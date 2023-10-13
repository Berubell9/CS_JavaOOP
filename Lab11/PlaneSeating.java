public abstract class PlaneSeating{
    protected String planeType;
    protected char[][] seating;
    // Constructor
    // public PlaneSeating(String planeType ,char[][] seating){
    //     this.planeType = planeType;
    //     this.seating = seating;

    // }
    public void showSeating(){
        for (int i = 0; i < seating.length; i++) {
            System.out.printf("row %d --> ",i+1);
            for (int j = 0; j < seating[i].length; j++) {
                System.out.print(seating[i][j]);
                
            }
            System.out.println();
        }
    }
    public abstract boolean reserveSeat(int row, int col);
}
