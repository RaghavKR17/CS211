import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/*
Raghav K.R
02/16/2024
CP 10

Results and Explanation:

Compares the performance of ArrayList and LinkedList for removing elements from the middle of the list. The goal was to understand which data structure performs better for this operation.

Observations:
- In my tests, ArrayList consistently performed faster than LinkedList when removing elements.
- The processing time for ArrayList.remove() was consistently lower than LinkedList.remove().
- I noticed that ArrayList's processing time was only a small fraction of LinkedList's processing time.

Explanation:
- Time Complexity (Big O): ArrayList has a time complexity of O(n) for removing elements from the middle, where n is the number of elements in the list. This is because ArrayList needs to shift subsequent elements after the removed element. In contrast, LinkedList has a time complexity of O(1) for removing elements from the middle, as it only requires adjusting pointers.
- Actual Processing Time: Despite LinkedList's theoretically better time complexity, ArrayList performed better in actual processing time. This is because ArrayList stores elements in contiguous memory locations, allowing for faster access and manipulation. On the other hand, LinkedList's scattered memory layout leads to more cache misses and slower performance.

Conclusion:
Based on my test and understanding of time complexity and actual processing time, I can confidently conclude that ArrayList is generally faster than LinkedList for removing elements from the middle of the list. This is especially true for large datasets.

*/

public class CP10_ArrayListVSLinkedList {

    static int howManyTests = 5;
    static int howManyData = 60000;

    static ArrayList<String> AL = new ArrayList<>();
    static LinkedList<String> LL = new LinkedList<>();
    static Random rand = new Random();

    public static void remove() {
		double TimeRemove_ArrayList = 0.0;
		double TimeRemove_LinkedList = 0.0;
		long startTime, endTime;
	
		for (int i = 0; i < howManyData / 2; i++) {
			int index2remove = rand.nextInt(AL.size());
	
			// ArrayList
			startTime = System.currentTimeMillis();
			AL.remove(index2remove);
			endTime = System.currentTimeMillis();
			TimeRemove_ArrayList += endTime - startTime;
	
			// LinkedList
			startTime = System.currentTimeMillis();
			LL.remove(index2remove);
			endTime = System.currentTimeMillis();
			TimeRemove_LinkedList += endTime - startTime;
		}
	
		System.out.println("\nRemoved: " + howManyData / 2);
		System.out.println("ArrayList: " + TimeRemove_ArrayList / 1000.0 + " Sec");
		System.out.println("LinkedList: " + TimeRemove_LinkedList / 1000.0 + " Sec");
	
		double percent = (TimeRemove_ArrayList / TimeRemove_LinkedList) * 100;
		System.out.printf("ArrayList's processing time is %.1f%% of LinkedList\n", percent);
	}
	
	

    public static void initialization() {
        AL.clear();
        LL.clear();
        for (int i = 0; i < howManyData; i++) {
            AL.add(Integer.toString(i)); 
            LL.add(Integer.toString(i));
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= howManyTests; i++) {
            initialization(); 
            System.out.printf("\nTest: " + i);
            remove();
        }
    }
}