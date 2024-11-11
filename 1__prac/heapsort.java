//package popo2;
//import java.util.*;
//
//public class heapsort {
//    
//    // Method to build the heap (Max-Heap)
//    private static void heapify(int[] arr) {
//        int n = arr.length;
//        // Start from the last non-leaf node and work upwards
//        for (int i = n / 2 - 1; i >= 0; i--) {
//            siftDown(i, arr, n);
//        }
//    }
//
//    // Helper method to move an element down in the heap
//    private static void siftDown(int k, int[] arr, int n) {
//        int value = arr[k];
//        int half = n / 2; // last non-leaf node
//        while (k < half) {
//            int leftChild = 2 * k + 1;  // Left child index
//            int rightChild = leftChild + 1;  // Right child index
//            int largerChild = leftChild;
//
//            // Check if the right child is larger than the left
//            if (rightChild < n && arr[rightChild] > arr[leftChild]) {
//                largerChild = rightChild;
//            }
//
//            // If the value is larger than or equal to the larger child, we're done
//            if (value >= arr[largerChild]) {
//                break;
//            }
//
//            // Swap the current element with the larger child
//            arr[k] = arr[largerChild];
//            k = largerChild;
//        }
//        arr[k] = value;
//    }
//
//    // Main Heapsort method that uses heapify
//    public static List<Integer> heapsort(int[] arr) {
//        // Step 1: Convert the array to a heap
//         heapify(arr);
//
//        // Step 2: Sort the array using heap sort
//        ArrayList<Integer> sortedArr = new ArrayList<>();
//        
//        // Create a priority queue (min-heap)
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        for (int num : arr) {
//            minHeap.offer(num);
//        }
//        
//        // Extract the elements from the heap and add to the sorted list
//        while (!minHeap.isEmpty()) {
//            sortedArr.add(minHeap.poll());
//        }
//
//        return sortedArr;
//    }

//    public static void main(String[] args) {
//        // Test the heapsort method
//        int[] arr = {1, 2, 37, 8, 3, 99, 4};
//        System.out.println(heapsort(arr));
//    }
//}


package popo2;

public class heapsort {
    
    												// Method to build the heap (Min-Heap) with 1-based indexing
    private static void heapify(int[] arr) {
        int n = arr.length - 1; 					// Ignore the 0th index for 1-based indexing
        												// Start from the last non-leaf node and work upwards
        for (int i = n / 2; i >= 1; i--) {
            siftDown(i, arr, n);
        }
    }

   																	// Helper method to move an element down in the heap for Min-Heap
    private static void siftDown(int k, int[] arr, int n) {
        int value = arr[k];
        while (k <= n / 2) {											 // Loop until `k` has no children
            int leftChild = 2 * k;
            int rightChild = leftChild + 1;
            int smallerChild = leftChild;

																			// Check if the right child exists and is smaller than the left
            if (rightChild <= n && arr[rightChild] < arr[leftChild]) {
                smallerChild = rightChild;
            }

            																		// If value is smaller than or equal to the smaller child, we're done
            if (value <= arr[smallerChild]) {
                break;
            }

            																	// Move the smaller child up
            arr[k] = arr[smallerChild];
            k = smallerChild;
        }
        arr[k] = value;
    }

    																						// Heapsort method that sorts the array in ascending order
    public static void heapsort(int[] arr) {
        int n = arr.length - 1;																	 // Ignore the 0th index for 1-based indexing

        																				// Step 1: Convert the array to a min-heap
        heapify(arr);

        																	// Step 2: Sort the array using heap sort (by repeatedly removing the root)
        for (int end = n; end > 1; end--) {
        															// Swap the root of the min-heap with the last element
            int temp = arr[1];
            arr[1] = arr[end];
            arr[end] = temp;

																						// Reduce the heap size by one and heapify the root element
            siftDown(1, arr, end - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 4, 10, 3, 5, 1}; // 0th index ignored for 1-based indexing
        heapsort(arr);
        
        // Print sorted array (ignoring the 0th index)
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // Expected Output: 10 5 4 3 1
    }
}













