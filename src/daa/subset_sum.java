package daa;



public class subset_sum {

    // Define the global array
    static int[] arr = {3, 34, 4, 12, 5, 2};

    // Method to check if there is a subset with the given sum
    public static boolean isSubsetSum(int target, int n) {
        // Base cases
        if (target == 0) {
            return true;
        }
        if (n < 0) {
            return false;
        }

        // If the current element is greater than the remaining sum, skip it
        if (arr[n] > target) {
            return isSubsetSum(target, n - 1);
        }

        // Check if including or excluding the current element meets the target sum
        return isSubsetSum(target, n - 1) || isSubsetSum(target - arr[n], n - 1);
    }

    public static void main(String[] args) {
        // Example usage
        int target = 9;
        System.out.println(isSubsetSum(target, arr.length - 1));  // Output: true (e.g., subset [4, 5] or [3, 2, 4] sums to 9)
    }
}
//
//
//# Define the global array
//arr = [3, 34, 4, 12, 5, 2]
//
//def find_subset_sum(target, n, current_subset):
//    # Base cases
//    if target == 0:
//        return current_subset  # Return the subset if the target is achieved
//    if n < 0:
//        return None  # Return None if no valid subset is found
//
//    # If the current element is greater than the remaining sum, skip it
//    if arr[n] > target:
//        return find_subset_sum(target, n - 1, current_subset)
//
//    # Case 1: Exclude the current element
//    result_exclude = find_subset_sum(target, n - 1, current_subset)
//    if result_exclude:
//        return result_exclude  # If excluding worked, return the subset
//
//    # Case 2: Include the current element
//    result_include = find_subset_sum(target - arr[n], n - 1, current_subset + [arr[n]])
//    return result_include  # Return the result if including worked
//
//# Example usage
//target = 9
//subset = find_subset_sum(target, len(arr) - 1, [])
//if subset:
//    print(f"Subset that sums to {target}: {subset}")
//else:
//    print(f"No subset found that sums to {target}")
