import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOfNames {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Sort the list alphabetically
        Collections.sort(names);

        // Print the sorted list
        for (String name : names) {
            System.out.println(name);
        }
    }
}