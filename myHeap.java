/* 
Raghav Krishna Ranganathan
Student ID #: 203035901
March 1st, 2024

This program implements a min-heap data structure (Heap211) using an ArrayList. It provides methods to add elements to the heap,
remove the minimum element, and maintain the min-heap property by performing bubble-up and bubble-down operations. Each operation
is accompanied by print statements to visualize the changes to the heap.

Min-heap can be handy for managing tasks in to-do lists. Tasks are nodes, sorted by priority (e.g., deadline or importance),
ensuring critical tasks are completed promptly, aiding efficient task management.

*/
import java.util.Random;

public class myHeap {

    final static int HOW_MANY_TESTS = 20;

    public static void main(String[] args) {
        System.out.println("CP 16. MinHeap (Winter 2024)");

        // create an instance of Random class
        Random random = new Random();

        // create an instance of Heap211 class
        Heap211 minHeap = new Heap211();

        for (int test = 1; test <= HOW_MANY_TESTS; test++) {

            // generate a random number to decide the action is 'add' or 'remove'
            int whatAction = random.nextInt(2);

            if (whatAction == 0) { // if the action is 'add'

                // generate a node number using random number (e.g., 0~49)
                int node = random.nextInt(50);
                System.out.println("Action " + test + ": Add " + node);

                // add node to the heap by calling 'add' method in Heap211 class
                minHeap.add(node);

            } else { // if the action is 'remove'

                if (minHeap.isEmpty()) {
                    // if the heap is empty, skip this action, do not count this action
                    test = test - 1;
                } else {
                    System.out.println("Action " + test + ": Remove min");

                    // remove the min value from the heap by calling 'remove' method in Heap211 class
                    int min = minHeap.remove();
                }
            }
        }
    }
}
