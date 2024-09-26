package daa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class quicksort {
    public static List<Integer> qsort(List<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        int mid = arr.size() / 2;
        int pivot = arr.get(mid);
        List<Integer> remain = new ArrayList<>(arr);
        remain.remove(mid);
        
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        for (Integer i : remain) {
            if (i < pivot) {
                left.add(i);
            } else if (i > pivot) {
                right.add(i);
            }
        }
        
        List<Integer> sorted = new ArrayList<>();
        sorted.addAll(qsort(left));
        sorted.add(pivot);
        sorted.addAll(qsort(right));
        
        return sorted;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Create a list to hold the elements
        List<Integer> arr = new ArrayList<>();

        // Input elements into the list
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        System.out.println("Original array: " + arr);
        List<Integer> sortedArr = qsort(arr);
        System.out.println("Sorted array: " + sortedArr);

        scanner.close(); // Close the scanner
    }
}
