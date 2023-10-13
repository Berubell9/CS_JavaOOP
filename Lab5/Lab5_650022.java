import java.util.*;
public class Lab5_650022 {
    static int[] data = { 28, 58, 8, 77, 48, 39 };
    static ArrayProcessor q1NumberOfEvenElement; // 4
    static ArrayProcessor q2IndexOfLargestEvenValue; // 1
    static ArrayProcessor myMedian; // n/2th element of sorted = 48
    public static void main(String[] args) {
        q1(); // 4
        q2(); // 1
        oneline(); // 48
    }
    public static void q1(){
        //จำนวนของเลขคู่ในอาเรย์
        q1NumberOfEvenElement = (arr) -> {
            int cnt=0;
            for(int i : data)if(i%2 == 0)cnt++;
            return cnt;
        };
        System.out.println("q1 : "+q1NumberOfEvenElement.calculate(data));
    }
    public static void q2(){
        //indexของเลขคู่ที่ใหญ่ที่สุด
        q2IndexOfLargestEvenValue = (arr) ->{
            int temp = data[0];
            int cnt = 0;
            for(int i : data){
                if(temp>i && i%2==0){
                    temp = i;
                    cnt++;
                }
            }
            return cnt;
        };
        System.out.println("q2 : "+q2IndexOfLargestEvenValue.calculate(data));
    }
    static void oneline() {
        int[] tmp = Arrays.copyOf(data, data.length);
        Arrays.sort(tmp);
        //ค่ากลาง
        /* q3 */ //one statement
        myMedian = (arr) -> data[data.length/2];
        System.out.println("q3 : "+myMedian.calculate(tmp)); // 48
    }
}