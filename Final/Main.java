import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        List<stream> user = Arrays.asList(
          new stream(1, "Test 01", 12, stream.Gender.male),  
          new stream(2, "Test 02", 20, stream.Gender.female),  
          new stream(3, "Test 03", 30, stream.Gender.male),  
          new stream(4, "Test 04", 30, stream.Gender.female),  
          new stream(5, "Test 05", 20, stream.Gender.female)
        );
        int[] num = {1, 2, 3, 4, 5};

        q1(user);
        q2(user);
        q3(user);
        q4(user);
        q11(num);
        
    }

    //หาอายุเฉลี่ย (.average() ต้องเเปลงเป็น double)
    public static void q1(List<stream> user){
        double average = user.stream()
        .mapToInt(stream::getAge)
        .average().getAsDouble();
        System.out.println("Average of age : "+average);
    }

    //หาอายุรวมของ user ทั้งหมด
    //https://www.baeldung.com/java-stream-sum
    public static void q2(List<stream> user){
        int sum = user.stream().mapToInt(stream::getAge).sum();

        int sum1 = user.stream().collect(Collectors.summingInt(stream::getAge));
        
        int sum2 = user.stream().map(stream::getAge).reduce(0,(a,b) -> a+b);

        System.out.println("Sum : "+sum);
        System.out.println("Sum collection : "+sum1);
        System.out.println("Sum reduce : "+sum2);
    }

    //จงกรองข้อมูลเฉพาะ user ที่เป็นผู้หญิงส่งออกเป็น list ใช้งานผ่าน Stream.filter และ Stream.reduce
    public static void q3(List<stream> user){
        List<stream> female = user.stream()
        .filter(e -> e.getSex() == stream.Gender.female)
        .collect(Collectors.toList());
        female.forEach(System.out::println);
       System.out.println(female);
    }

    //นับจำนวน user แบ่งกลุ่มตามเพศ
    public static void q4(List<stream> user){
        Map<stream.Gender, Integer> map = user.stream()
        .collect(Collectors.groupingBy(stream::getSex,Collectors.summingInt(p -> 1)));
        System.out.println(map);
    }


    //https://mkyong.com/java8/java-8-how-to-convert-a-stream-to-array/
    public static void q11(int[] num){
        Integer[] result = Arrays.stream(num)
        .map(x -> x * 2)
        .boxed()
        .toArray(Integer[]::new);
        System.out.println(Arrays.asList(result));
        System.out.println(Arrays.toString(result));
    }

}
