import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapFrequency {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();

        // Split the input into words
        String[] words = input.split(" ");

        // Create a HashMap to store word frequencies
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Count the frequency of each word
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Print the word frequencies
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}