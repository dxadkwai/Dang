import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.ArrayDeque;
import java.util.Deque;

public class queue {
    public static void main(String[] args) {
        // Queue <Integer> priorityQueue = new PriorityQueue<>();


        // priorityQueue.add(30);
        // priorityQueue.add(20);
        // priorityQueue.add(10);

        // System.out.println("Priority Queue " + priorityQueue);

        // int removedElement = priorityQueue.poll();
        // System.out.println("removed element " + removedElement);

        Deque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst("First");
        arrayDeque.addLast("Last");
        arrayDeque.addLast("Third");
        System.out.println("Array Deque " + arrayDeque);

        String removedFirst = arrayDeque.removeFirst();
        System.out.println("Removed first "+ removedFirst);
        System.out.println("Array again " + arrayDeque);



    }
    
}
