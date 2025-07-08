import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDescOrder {
    public static void main(String[] args) {
        // Create a TreeSet with a custom comparator for descending order
        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        // Add some integers to the TreeSet
        treeSet.add(5);
        treeSet.add(3);
        treeSet.add(8);
        treeSet.add(1);

        // Print the sorted integers in descending order
        for (Integer num : treeSet) {
            System.out.println(num);
        }
    }
}