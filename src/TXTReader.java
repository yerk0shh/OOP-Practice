
import javax.swing.text.Document;
import java.net.URI;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TXTReader {
    public static void main(String args[]){
        String file = "C:\\Users\\Yerkebulan\\Desktop\\narxoz\\In Our Time by Ernest Hemingway.txt";
        File filename = new File(file);
        String fileName = filename.getName();
        try {
            List<String> lines = Files.lines(Paths.get(file))
                    .collect(Collectors.toList());

            Map<String, Long> PotokSlov = lines.stream()
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(word -> word.length()>5)
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

            long totalWords = lines.stream()
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(word -> !word.isEmpty())
                    .count();
            System.out.println(fileName+" Information:");
            System.out.println("Total words in TXT: "+totalWords);

            long uniqueWordsCounter = lines.stream()
                    .flatMap(line->Stream.of(line.split(" ")))
                    .filter(word->word.length()>3)
                    .map(String::toLowerCase)
                    .distinct()
                    .count();
            System.out.println("Total unique words: "+uniqueWordsCounter);

            String longestWord = PotokSlov.keySet().stream()
                    .max((w1,w2)->Integer.compare(w1.length(),w2.length()))
                    .orElse(null);
            System.out.println("The Longest word is - "+longestWord);

            int averageLength = (int) PotokSlov.keySet().stream()
                    .mapToInt(String::length)
                    .average()
                    .orElse(0);
            System.out.println("The average length of words - "+averageLength);
            
            System.out.println("Most used words:");
            PotokSlov.entrySet().stream()
                    .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())).limit(10)
                    .forEach(e -> System.out.println("Word - '"+e.getKey()+"' used "+e.getValue()+" times; "));




        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
