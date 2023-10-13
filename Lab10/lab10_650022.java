import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class lab10_650022 {
    // run : java lab10_650022 5 haha
    public static void main(String[] args) {
        // args[0] is "5" and args[1] is "haha"
        testBed(args);
    }

    private static void testBed(String[] args) {
        System.out.println("**AAAAAAAA**");
        // learn behavior of args
        System.out.print("command arguments are ");
        for (String s : args)
            System.out.println(s.trim()); // 5 haha
        System.out.println();
        System.out.println();

        System.out.println("**BBBBBBBB**");
        // review openning .csv file using .split()
        String row;
        String[] tokens;
        try (Scanner input = new Scanner(Paths.get("pack10_CSMovie/samples10.csv"))) {
            input.nextLine(); // skip header row
            while (input.hasNext()) {
                row = input.nextLine();
                tokens = row.split(",");
                for (String token : tokens)
                    System.out.print(token + " ");
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("from IO error");
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("**CCCCCCCC**");
        // test what if title contains comma(,)
        //ตัด (,)
        row = "\"This is, a sample title\", \"Horror\", \"10.0\"";
        tokens = row.split(",");
        System.out.println("There are " + tokens.length + " tokens");
        for (String token : tokens)
            System.out.println(token.trim() + " ");
        tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        System.out.println("There are " + tokens.length + " tokens");
        for (String token : tokens)
            System.out.println(token.trim() + " ");
    }

}
