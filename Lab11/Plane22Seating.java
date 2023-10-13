import java.util.Arrays;

public class Plane22Seating extends PlaneSeating{
    // Constructor
    public Plane22Seating(String args){
        super();
        String[] tokens = args.split(",");
        int numRow = tokens.length;
        int numCol = tokens[0].length();
        seating = new char[numRow][numCol];
        for(int i=0;i<tokens.length;i++){
            seating[i] = tokens[i].toCharArray();
            System.out.println(Arrays.toString(tokens));
        }
    }
    // เช็คว่ายังมีที่ว่างเหลือหรือไม่
    private boolean isFull(){
        for (int i = 0; i < seating.length; i++) {
            for (int j = 0; j < seating[i].length; j++) {
                if (seating[i][j] == '^') {
                    return true; 
                }
            }
        }
        return false;
    }
    
    public boolean reserveSeat(int row, int col){
        if (isFull()) {
            showSeating();
            return false;    
        }
        if (seating[row][col]=='^') {
            seating[row][col]='x';
            showSeating();
            return true;
        }
        else{ 
            showSeating();
            return false;
        }
    }
}
