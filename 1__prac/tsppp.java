package popo2;

import java.util.*;

public class tsppp {
    static int[][] d = {
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };

    public static void main(String[] args) {
        int n = d.length;
        Map<String, int[]> memo = new HashMap<>();
        int startCity = 0;
        List<Integer> toVisit = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            toVisit.add(i);
        }

        int[] result = tsp(startCity, toVisit, memo, new ArrayList<>(List.of(startCity)));
        int minCost = result[0];
        List<Integer> bestPath = new ArrayList<>();
        for (int i = 1; i < result.length; i++) {
            bestPath.add(result[i]);
        }

        System.out.println("Minimum cost: " + minCost);
        System.out.println("Best path: " + bestPath);
    }

    private static int[] tsp(int curr, List<Integer> toVisit, Map<String, int[]> memo, List<Integer> path) {
        if (toVisit.isEmpty()) {
            int cost = d[curr][0];
            int[] result = new int[path.size() + 2];
            result[0] = cost;
            for (int i = 0; i < path.size(); i++) {
                result[i + 1] = path.get(i);
            }
            result[path.size() + 1] = 0;  // Add the starting city to close the loop
            return result;
        }

        String key = curr + "," + toVisit.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int minCost = Integer.MAX_VALUE;
        int[] bestResult = null;

        for (Integer next : toVisit) {
            List<Integer> remainingCities = new ArrayList<>(toVisit);
            remainingCities.remove(next);

            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(next);

            int[] subResult = tsp(next, remainingCities, memo, newPath);
            int newCost = subResult[0] + d[curr][next];

            if (newCost < minCost) {
                minCost = newCost;
                bestResult = new int[subResult.length + 1];
                bestResult[0] = minCost;

                // Copy the path from subResult into bestResult
                System.arraycopy(subResult, 1, bestResult, 2, subResult.length - 1);
                bestResult[1] = next;  // Set the next city in the best path
            }
        }

        memo.put(key, bestResult);
        return bestResult;
    }
}


//import copy
//
//d = [[0, 10, 15, 20],
//     [10, 0, 35, 25],
//     [15, 35, 0, 30],
//     [20, 25, 30, 0]]
//
//
//def tsp(curr, to_visit,  memo, path):
//    if not to_visit:
//                    # Return to the starting point
//        return d[curr][0], path + [0]  
//    
//    if (curr, tuple(to_visit)) in memo:
//        return memo[(curr, tuple(to_visit))]  # Retrieve saved result if exists
//    
//    ans = float('inf')
//    best_path = None  # Variable to store the best path
//    
//    for k in to_visit:
//        new_to_visit = copy.copy(to_visit)
//        new_to_visit.remove(k)
//        
//        # Get the cost and the path from this city
//        new_cost, sub_path = tsp(k, new_to_visit, memo, path + [k])
//        
//        new_cost += d[curr][k]
//        
//        if new_cost < ans:
//            ans = new_cost
//            best_path = sub_path  # Record the best path
//
//    memo[(curr, tuple(to_visit))] = (ans, best_path)
//    return ans, best_path
//
//
//n = len(d)
//memo = {}
//start_city = 0
//to_visit = list(range(1, n))  # Cities to visit except the start city
//
//# Call the tsp function
//min_cost, best_path = tsp(start_city, to_visit, memo, [start_city])
//
//# Print the results
//print("Minimum cost:", min_cost)
//print("Path:", best_path)
