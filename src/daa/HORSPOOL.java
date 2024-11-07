package daa;

import java.util.HashMap;

public class HORSPOOL{

    // Function to create the shift table using HashMap
    public static HashMap<Character, Integer> createShiftTable(String pattern) {
        HashMap<Character, Integer> shiftTable = new HashMap<>();
        int patternLength = pattern.length();

        // Initialize all characters with pattern length
//        for (char ch = 0; ch < 256; ch++) {
//            shiftTable.put(ch, patternLength);
//        }

        // Update table with pattern-specific shifts
        for (int i = 0; i < patternLength - 1; i++) {
            shiftTable.put(pattern.charAt(i), patternLength - 1 - i);
        }

        return shiftTable;
    }

    // Function to check if the string matches using the Horspool algorithm
    public static int horspoolSearch(String text, String pattern) {
        HashMap<Character, Integer> shiftTable = createShiftTable(pattern);
        int textLength = text.length();
        int patternLength = pattern.length();
        int i = patternLength - 1;

        while (i < textLength) {
            int k = 0;
            // Compare the pattern with the text
            while (k < patternLength && pattern.charAt(patternLength - 1 - k) == text.charAt(i - k)) {
                k++;
            }
            // If the pattern matches
            if (k == patternLength) {
                return i - patternLength + 1; // Match found, return starting index
            } else {
                // Shift according to the shift table
                i += shiftTable.getOrDefault(text.charAt(i), patternLength);
            }
        }
        return -1; // No match found
    }

    public static void main(String[] args) {
        String text = "this is a simple example";
        String pattern = "example";

        int result = horspoolSearch(text, pattern);
        if (result != -1) {
            System.out.println("Pattern found at index: " + result);
        } else {
            System.out.println("Pattern not found.");
        }
    }
}
