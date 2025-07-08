import java.util.LinkedList;
import java.util.Queue;

public class PrintJobQueue {
    public static void main(String[] args) {
        // Create a Queue to simulate a print job queue
        Queue<String> printQueue = new LinkedList<>();

        // Add some print jobs to the queue
        printQueue.add("Job1");
        printQueue.add("Job2");
        printQueue.add("Job3");

        // Process the print jobs in the order they were added
        while (!printQueue.isEmpty()) {
            String job = printQueue.poll();
            System.out.println("Processing print job: " + job);
        }
    }
}