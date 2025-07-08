import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {
    public static void main(String[] args) {
        int numElements = 100000;

        // Test ArrayList
        List<Integer> arrayList = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.add(0, i); // Insert at the beginning
        }
        long endTime = System.nanoTime();
        long arrayListTime = endTime - startTime;
        System.out.println("ArrayList insertion time: " + arrayListTime + " nanoseconds");

        // Test LinkedList
        List<Integer> linkedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.add(0, i); // Insert at the beginning
        }
        endTime = System.nanoTime();
        long linkedListTime = endTime - startTime;
        System.out.println("LinkedList insertion time: " + linkedListTime + " nanoseconds");
    }
}