//def knapsack(weights, values, capacity):
//    n = len(weights)
//    # Create a 2D DP array, where dp[i][j] represents the max value for first i items with capacity j
//    dp = [[0] * (capacity + 1) for _ in range(n + 1)]
//
//    # Fill DP table
//    for i in range(1, n + 1):
//        for w in range(1, capacity + 1):
//            if weights[i - 1] <= w:
//                # Either take the current item (i-1) or leave it
//                dp[i][w] = max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]])
//            else:
//                # Can't take the current item, just carry forward the previous value
//                dp[i][w] = dp[i - 1][w]
//
//    return dp[n][capacity]
//
//# Example usage
//weights = [2, 3, 4, 5]
//values = [3, 4, 5, 6]
//capacity = 5
//max_value = knapsack(weights, values, capacity)
//print(f"Maximum value that can be taken in the knapsack: {max_value}")

package daa;

import java.util.Arrays;

public class kp{
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // Create a 2D DP array, where dp[i][j] represents the max value for first i items with capacity j
        int[][] dp = new int[n + 1][capacity + 1];

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    // Either take the current item (i-1) or leave it
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    // Can't take the current item, just carry forward the previous value
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        
        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
            	System.out.print(dp[i][w]);
            }
            System.out.println();}
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;
        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Maximum value that can be taken in the knapsack: " + maxValue);
    }
}

