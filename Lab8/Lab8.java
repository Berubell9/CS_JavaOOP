import java.util.*;
import java.util.stream.*;
import java.util.function.Consumer;
class Lab8{
    public static void main(String[] args) {
        System.out.println("----------Method Q0----------");
        q0();
        System.out.println("----------Method Q1----------");
        q1_halfEachNumber();
        System.out.println("----------Method Q2----------");
        q2_forEachSingerName();
        System.out.println("----------Method Q3----------");
        q3_lambda_comparator();
        System.out.println("----------Method Q4----------");
        q4_method_reference_comparator();
    }
    static void q0(){
        HalfValueInterface bb = new HalfValueInterface() {
            public void printHalf(int p){
                System.out.println(p/2);
            }   
        };
        bb.printHalf(12);
    }
    public static void q1_halfEachNumber() {
        List<Integer> nums = Arrays.asList(100, 105);

        System.out.println("Q1.1---");
        HalfValueInterface halfVal = /* q1.1 */ n -> System.out.println(n/2);
        for (int n : nums) {
            halfVal.printHalf(n);
        } 

        System.out.println("Q1.2---");
        Consumer<Integer> consumer = n -> /* q1.2 */ System.out.println(n/2);
        for (int n : nums) {
            consumer.accept(n);
        }

        System.out.println("Q1.3---");
        Consumer<Integer> halfMe = n -> System.out.println(n/2);
        nums./* q1.3 */ forEach(halfMe);

        System.out.println("Q1.4---");
        nums.forEach(/* q1.4 */ n -> System.out.println(n/2));

        System.out.println("Q1.5---");
        NumberProcessor np = new NumberProcessor();
        nums.forEach(/* q1.5 */ np::printHalf);
    }
    public static void q2_forEachSingerName() {
        List<Singer> singerList = Arrays.asList(
            new Singer("Aba","POP"),
            new Singer("Abi","POP"),
            new Singer("Abo","ROCK"),
            new Singer("Abe","ROCK")
        );
        //http://blog.marcinchwedczuk.pl/method-references-in-java-8
        System.out.println("Q2.1---");
        //lambda expression
        singerList.stream().map(/* q2.1 */ x -> x.getName()).collect(Collectors.toList())
        .forEach(System.out::println);

        System.out.println("Q2.2---");
        //method references
        singerList.stream().map(/* q2.2 */ Singer::getName)
        .forEach(System.out::println);
    }
    public static void q3_lambda_comparator() {
        List<Singer> singerList = Arrays.asList(
            new Singer("Aba","POP"),
            new Singer("Abi","POP"),
            new Singer("Abo","ROCK"),
            new Singer("Abe","ROCK")
        );
        Comparator<Singer> byStyle1 = new Comparator<>() {
            @Override
            public int compare(Singer o1, Singer o2) {
                return o1.getStyle().compareTo(o2.getStyle());
            } //by Enum .ordinal()
        };
        Collections.sort(singerList, byStyle1);
        singerList.forEach(System.out::println);

        //https://www.baeldung.com/java-8-sort-lambda
        System.out.println("Q3.1---");
        Comparator<Singer> byStyle2 = /* q3.1 */ (o1, o2) -> o1.getStyle().compareTo(o2.getStyle());
        Collections.sort(singerList, byStyle2);
        singerList.forEach(System.out::println);
    }
    public static void q4_method_reference_comparator() {
        List<Singer> singerList = Arrays.asList(
            new Singer("Aba","POP"),
            new Singer("Abi","ROCK"),
            new Singer("Abo","POP"),
            new Singer("Abe","ROCK")
        );
        //https://mkyong.com/java8/java-8-lambda-comparator-example/
        //method reference Page 7
        System.out.println("Q4.1---");
        //method reference 
        Comparator<Singer> byName = /* q4.1 */ Comparator.comparing(Singer::getName);
        Collections.sort(singerList, byName);
        singerList.forEach(System.out::println);

        System.out.println("Q4.2---");
        //lambda expression
        //ลบใช้กับ sortตัวเลข
        //singerList.sort( /* q4.2 */ (o1,o2) -> o1.getAge() - o2.getAge());
        //singerList.sort( /* q4.2 */ (o1,o2) -> o1.getStyle().compareTo(o2.getStyle()));
        singerList.sort( /* q4.2 */ Comparator.comparing(s -> s.getStyle()));
        singerList.forEach(System.out::println);
    }
}    