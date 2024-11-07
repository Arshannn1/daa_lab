package daa;



import java.util.Arrays;
import java.util.PriorityQueue;

public class heapSort {
    // Method to perform heapsort using a min-heap
    public static int[] heapsort(int[] array) {
        // Create a min-heap using PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all elements to the min-heap
        for (int num : array) {
            minHeap.offer(num);
        }

        // Extract elements from the min-heap to get them sorted
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
