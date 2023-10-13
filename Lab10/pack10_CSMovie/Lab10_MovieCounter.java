package pack10_CSMovie;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lab10_MovieCounter {
    ArrayList<CSMovie> mList = new ArrayList<>();
    Set<String> uniqueTitle = new HashSet<>();
    public Lab10_MovieCounter() {
        String row;
        int rowCount = 1;
        int incompleteCount = 0;
        String title;
        String rating;
        String genre;
        Integer year;
        String skipped_released;
        Double score;
        Integer votes;
        String director;
        String skipped_writer;
        String star;
        String country;
        Integer budget;
        Long gross;
        String company;
        Integer runtime;

        try(Scanner input = new Scanner(Paths.get("pack10_CSMovie/movies.csv"))) {
            input.nextLine(); //skip header row
            while (input.hasNext()) {
                row = input.nextLine();
                rowCount++;
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (tokens.length < 15) {
                    incompleteCount++;
                    System.out.println(rowCount + " " + incompleteCount + " is incompleted");
                    continue; //skip this row
                } 
                title = tokens[0];   
                rating = tokens[1];
                genre = tokens[2];
                year = Integer.parseInt(tokens[3]);
                score = Double.parseDouble(parseDouble(tokens[5]));
                votes = (int) (Double.parseDouble(parseDouble(tokens[6])));
                director = tokens[7];
                star = tokens[9];
                country = tokens[10];
                budget = (int)(Double.parseDouble(parseDouble(tokens[11])));
                gross = (long)(Double.parseDouble(parseDouble(tokens[12])));
                company = tokens[13];
                runtime = (int)(Double.parseDouble(parseDouble(tokens[14])));
                if (!uniqueTitle.contains(title)) {
                    mList.add(new CSMovie(title, rating, genre, 
                    year, score, votes, 
                    director, star, country, 
                    budget, gross, company, 
                    runtime));
                }   
                uniqueTitle.add(title);
            }
            System.out.print("There are " + incompleteCount + " rows of incompleted data ");
            System.out.println("from " + rowCount + " rows. (" + uniqueTitle.size()+ ") unique titles.");
            System.out.println("list size is " + mList.size());
        } catch (IOException e) {
            System.out.println("from IO error");
            e.printStackTrace();
        }
    }
    // ใส่ค่า default กรณีที่ token นั้นๆเป็น missing data
    private static String parseDouble(String str) {
        if (str.isEmpty())
            return ".0";
        return str;
    }

    public Double q1() {
        // https://www.somkiat.cc/java-8-start-with-stream-api/
        Double average = mList.stream()
            .mapToDouble(CSMovie::getScore)
            .average()
            .getAsDouble();
        // Double average = mList.stream().mapToDouble(e -> e.getScore()).average().getAsDouble();
        return average;
    }

    public List<CSMovie> q2() {
        List<CSMovie> movie = mList.stream()
            .filter(e -> e.getVotes() > 1900000)
            .collect(Collectors.toList());
        return movie;
    }

    public CSMovie q3() {
        // https://www.geeksforgeeks.org/stream-max-method-java-examples/
        CSMovie movie = mList.stream()
            .max(Comparator.comparing(CSMovie::getGross))
            .get();
        return movie;
    }  

    public List<String> q4() {
        // https://www.geeksforgeeks.org/stream-map-java-examples/
        List<String> genre = mList.stream()
            .map(CSMovie::getGenre)
            .collect(Collectors.toList());
        return genre;
    }

    public List<String> q5() { 
        // https://mkyong.com/java8/java-8-how-to-sort-list-with-stream-sorted/
        List<String> movie = mList.stream()
            .sorted(Comparator.comparingInt(CSMovie::getRuntime))
            .map(e -> String.format("%-55s --> %s",e.getTitle(), e.getRuntime()))
            .limit(5)
            .collect(Collectors.toList());
        return movie;
    }

    public CSMovie[] q6() {
        // https://stackoverflow.com/questions/42977137/creating-an-object-from-optionalobject
        CSMovie[] budget = new CSMovie[2];
        // highest
        budget[0] = mList.stream()
            .sorted(Comparator.comparingInt(CSMovie::getBudget).reversed())
            .findFirst()
            .orElse(null);
        // Lowest
        budget[1] = mList.stream()
            .sorted(Comparator.comparingInt(CSMovie::getBudget))
            .findFirst()
            .orElse(null);
        return budget;
    }

    public List<CSMovie> q7(String genre) {
        List<CSMovie> movieByGenre = mList.stream()
            .sorted(Comparator.comparing(CSMovie::getScore).reversed())
            .limit(3)
            .collect(Collectors.toList());
        return movieByGenre;
    }
    public List<CSMovie> q8() {
        // https://www.tabnine.com/code/java/methods/java.util.Comparator/thenComparing
        List<CSMovie> movie = mList.stream()
            .filter(m -> m.getGenre().equals("Action"))
            .sorted(Comparator.comparing(CSMovie::getScore)
            .reversed()
            .thenComparing(CSMovie::getTitle))
            .limit(3)
            .collect(Collectors.toList());
        return movie;
    }
    public Map<String,Long> q9() {
        // https://codingnconcepts.com/java/streams-with-map-java-8/
        Map<String,Long> sum = new HashMap<>();
        sum = mList.stream()
            .collect(Collectors.groupingBy(CSMovie::getGenre, Collectors.summingLong(CSMovie::getGross)));
        return sum;
    }
    // q10 และ q11 ใช้ hint
    public Map<String,Long> q10() {
        // https://codingnconcepts.com/java/streams-with-map-java-8/
        Map<String,Long> topTenCompany = new HashMap<>();
        topTenCompany = mList.stream()
            .collect(Collectors.groupingBy(CSMovie::getCompany, Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
            .limit(10)
            .collect(Collectors.toMap(Map.Entry::getKey ,Map.Entry::getValue));
        return topTenCompany;
    }
    public CSMovie q11() {
        // Function most 'a' 
        Function<CSMovie, Integer> countVowel = m -> {
            long cnt = 0;
            String titlename = m.getTitle();
            cnt = titlename.chars().filter(c -> c == 'a' || c == 'A').count();
            return (int)cnt;
        };
        Optional<CSMovie> m;
        m = mList.stream()
            .max(Comparator.comparing(countVowel));
        return m.get();
    }
}
// https://www.baeldung.com/java-split-string-commas