package daa;



import java.util.Arrays;
import java.util.PriorityQueue;

public class heapSort {
  
    public static int[] heapsort(int[] array) {
      
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        
        for (int num : array) {
            minHeap.offer(num);
        }

       
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = minHeap.poll(); // Get the minimum element
        }

        return sortedArray;
    }

    // Main method to test the heapsort
    public static void main(String[] args) {
        int[] array = {4, 10, 3, 5, 1,-99};
        System.out.println("Unsorted array: " + Arrays.toString(array));

        int[] sortedArray = heapsort(array);

        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }
}
