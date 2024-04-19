import java.util.ArrayList;

public class Heap211 {

    static public ArrayList<Integer> heap = new ArrayList<>();

    Heap211() {
        heap.add(0);  
    }

    int parent(int index) {
        return index / 2;
    }

    int leftChild(int index) {
        return index * 2;
    }

    int rightChild(int index) {
        return index * 2 + 1;
    }

    boolean hasParent(int index) {
        return index > 1;
    }

    boolean hasLeftChild(int index) {
        return leftChild(index) < heap.size();
    }

    boolean hasRightChild(int index) {
        return rightChild(index) < heap.size();
    }

    void swap(int a, int b) {
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
        System.out.println("\tswap: " + heap.get(a) + "<->" + heap.get(b));
    }

    int peekMin() {
        return heap.size() > 1 ? heap.get(1) : Integer.MIN_VALUE;
    }

    boolean isEmpty() {
        return heap.size() == 1;
    }

    void add(int value) {
        heap.add(value); // add as rightmost leaf

        System.out.println("   heap: " + printHeap());
        System.out.println("   bubble-up: start");

        // Bubble-up here

        int index = heap.size() - 1;
        while (hasParent(index) && heap.get(index) < heap.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }

        System.out.println("   bubble-up: end");
        System.out.println("   new heap: " + printHeap() + "\n");
    }

    int remove() {
        System.out.println("   heap: " + printHeap());

        int min = peekMin();
        heap.set(1, heap.get(heap.size() - 1)); // Move the last node to the first
        heap.remove(heap.size() - 1); // Delete the last node from the heap

        System.out.println("   Removed: " + min);
        System.out.println("   heap: " + printHeap());
        System.out.println("   bubble-down: start");

        // Bubble-down here

        int index = 1;
        while (hasLeftChild(index)) {
            int smallerChildIndex = leftChild(index);
            if (hasRightChild(index) && heap.get(rightChild(index)) < heap.get(leftChild(index))) {
                smallerChildIndex = rightChild(index);
            }

            if (heap.get(index) < heap.get(smallerChildIndex)) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }

        System.out.println("   bubble-down: end");
        System.out.println("   new heap: " + printHeap() + "\n");

        return min;
    }

    // Use this method as is
    public String printHeap() {
        StringBuilder result = new StringBuilder("[");
        
        if (heap.size() > 1) {
            result.append(heap.get(1));
        }

        for (int i = 2; i < heap.size(); i++) {
            result.append(", ").append(heap.get(i));
        }

        return result + "]";
    }
}
