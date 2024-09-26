package daa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {
    public static List<Integer> mergeSort(List<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }

        // Divide the list into two halves
        int mid = arr.size() / 2;
        List<Integer> leftHalf = new ArrayList<>(arr.subList(0, mid));
        List<Integer> rightHalf = new ArrayList<>(arr.subList(mid, arr.size()));

        // Recursively sort each half
        List<Integer> leftSorted = mergeSort(leftHalf);
        List<Integer> rightSorted = mergeSort(rightHalf);

        // Merge the sorted halves
        return merge(leftSorted, rightSorted);
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Append remaining elements
        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Initialize an ArrayList of integers
        List<Integer> arr = new ArrayList<>();

        // Loop to take input for each element
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        System.out.println("Original array: " + arr);
        long dd = System.nanoTime();
        List<Integer> sortedArr = mergeSort(arr);
        long fd = System.nanoTime();
        System.out.println("Sorted array: " + sortedArr);
        System.out.println("time takes is " + (fd - dd) + " millsex");

        scanner.close(); // Close the scanner
    }
}
