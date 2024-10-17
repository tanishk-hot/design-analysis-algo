#include <stdio.h>
struct Pair {
    int max;
    int min;
};
// Function to find maximum and minimum using the naive algorithm
struct Pair maxMinNaive(int arr[], int n) {
    struct Pair result;
    result.max = arr[0];
    result.min = arr[0];
    // Loop through the array to find the maximum and minimum values
    for (int i = 1; i < n; i++) {
        if (arr[i] > result.max) {
            result.max = arr[i]; // Update the maximum value if a larger element is found
        }
        if (arr[i] < result.min) {
            result.min = arr[i]; // Update the minimum value if a smaller element is found
        }
    }
    return result; // Return the pair of maximum and minimum values
}
int main() {
    int arr[] = {6, 4, 26, 14, 33, 64, 46};
    int n = sizeof(arr) / sizeof(arr[0]);
    struct Pair result = maxMinNaive(arr, n);
    printf("Maximum element is: %d\n", result.max);
    printf("Minimum element is: %d\n", result.min);
    return 0;
}