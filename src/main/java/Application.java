import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {

    /**
     * The main application can be run by providing a string to the command line
     * It will
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new Error("Expected a single argument");
        }
        System.out.println(Arrays.toString(topThreeWords(args[0])));
    }


    /**
     * topThreeWords is a function that takes in a String and returns a String array of the top 3 most occurring words.
     * It is case insensitive and apostrophes can be part of words, though they will be counted as a separate word if they contain one or more.
     * @param input
     * @return
     */
    public static String[] topThreeWords(String input) {

        String lowercaseInput = input.toLowerCase();
        Map<String, Integer> wordCountMap = new LinkedHashMap<>(); // use a LinkedHashMap for predictable ordering
        Pattern pattern = Pattern.compile("(?i)([A-Z']+)");
        Matcher matcher = pattern.matcher(lowercaseInput);

        while (matcher.find()) {
            String word = matcher.group();
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        List<String> sortedEntries = wordCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map((entry) -> entry.getKey())
                .collect(Collectors.toCollection(ArrayList::new));


        return sortedEntries.size() > 3 ? sortedEntries.subList(0, 3).toArray(new String[0]) : sortedEntries.toArray(new String[0]);
    }
}
