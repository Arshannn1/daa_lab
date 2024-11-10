//package daa;
//
//import java.util.*;
//
//
//public class subset_sum {
//
//    // Define the global array
//    static int[] arr = {3, 34, 4, 12, 5, 2};
//
//    // Method to check if there is a subset with the given sum
//    public static boolean isSubsetSum(int target, int n) {
//        // Base cases
//        if (target == 0) {
//        
//            return true;
//        }
//        if (n < 0) {
//            return false;
//        }
//
//        // If the current element is greater than the remaining sum, skip it
//        if (arr[n] > target) {
//            return isSubsetSum(target, n - 1);
//        }
//
//        // Check if including or excluding the current element meets the target sum
//        return isSubsetSum(target, n - 1) || isSubsetSum(target - arr[n], n - 1);
//    }
//
//    public static void main(String[] args) {
//    	
//        // Example usage
//        int target = 9;
//        System.out.println(isSubsetSum(target, arr.length - 1));  // Output: true (e.g., subset [4, 5] or [3, 2, 4] sums to 9)
//    }
//}

package daa;

import java.util.*;

public class subset_sum {

    // Define the global array
    static int[] arr = {3, 34, 4, 12, 5, 2};

    // Method to check if there is a subset with the given sum
    public static boolean isSubsetSum(int target, int n, ArrayList<Integer> list) {
        // Base cases
        if (target == 0) {
            System.out.println(list);
            return true;
        }
        if (n < 0) {
            return false;
        }

        // If the current element is greater than the remaining sum, skip it
        if (arr[n] > target) {
            return isSubsetSum(target, n - 1, list); // Exclude the current element
        }

        // Case 1: Exclude the current element
        if (isSubsetSum(target, n - 1, list)) {
            return true; // If excluding worked, return true
        }

        // Case 2: Include the current element
        list.add(arr[n]); // Include the current element
        if (isSubsetSum(target - arr[n], n - 1, list)) {
            return true; // If including worked, return true
        }

//        // Backtrack: remove the element if no valid subset is found
        list.remove(list.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Example usage
        int target = 9;
        if (!isSubsetSum(target, arr.length - 1, list)) {
            System.out.println("No subset found that sums to " + target);
        }
    }
}
