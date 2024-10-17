import java.util.ArrayList;
import java.util.List;

public class SumOfSubsets {

    // Function to solve the sum of subsets problem
    public static void sumOfSubsets(int[] arr, int targetSum) {
        List<Integer> currentSubset = new ArrayList<>();
        findSubsets(arr, 0, 0, targetSum, currentSubset);
    }

    // Recursive backtracking function to find subsets that sum to the target
    private static void findSubsets(int[] arr, int index, int currentSum, int targetSum, List<Integer> currentSubset) {
        // Base case: If the current sum equals the target, print the subset
        if (currentSum == targetSum) {
            System.out.println(currentSubset);
            return;
        }

        // If we have reached the end of the array or exceeded the target sum, backtrack
        if (index >= arr.length || currentSum > targetSum) {
            return;
        }

        // Include the current element in the subset
        currentSubset.add(arr[index]);
        findSubsets(arr, index + 1, currentSum + arr[index], targetSum, currentSubset);

        // Exclude the current element (backtrack)
        currentSubset.remove(currentSubset.size() - 1); // Remove the last element
        findSubsets(arr, index + 1, currentSum, targetSum, currentSubset);
    }

    // Main function to test the algorithm
    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 18, 12, 20, 15}; // Set of numbers
        int targetSum = 35;                     // Target sum to find

        System.out.println("Subsets that sum up to " + targetSum + " are:");
        sumOfSubsets(arr, targetSum);
    }
}


/*
Output:

Subsets that sum up to 35 are:
[10, 7, 18]
[10, 5, 20]
[5, 18, 12]
[20, 15]
*
*/