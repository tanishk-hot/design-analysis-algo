public class ZeroOneKnapsack {
    public static void main(String[] args) {

        // Test case 1: Standard case
        int[] weights1 = {3, 4, 6, 5};
        int[] profits1 = {2, 3, 1, 4};
        int capacity1 = 8;
        System.out.println("Test case 1: " + solution(weights1, profits1, capacity1));
        // Expected output: 6
        // Explanation: Choose items with weights 3 and 5 for a total profit of 2 + 4 = 6.

        System.out.println("\n\nTest case 2:\n\n");

        // Test case 2: Larger capacity
        int[] weights2 = {5, 4, 6, 3};
        int[] profits2 = {10, 40, 30, 50};
        int capacity2 = 10;
        System.out.println("Test case 2: " + solution(weights2, profits2, capacity2));
        // Expected output: 90
        // Explanation: Choose items with weights 4 and 3 for a total profit of 40 + 50 = 90.

        System.out.println("\n\nTest case 3:\n\n");

        // Test case 3: Edge case with zero capacity
        int[] weights3 = {1, 2, 3};
        int[] profits3 = {10, 20, 30};
        int capacity3 = 0;
        System.out.println("Test case 3: " + solution(weights3, profits3, capacity3));
        // Expected output: 0
        // Explanation: Capacity is zero, so no items can be taken.

        System.out.println("\n\nTest case 4:\n\n");

        // Test case 4: Edge case with all items too heavy
        int[] weights4 = {10, 20, 30};
        int[] profits4 = {60, 100, 120};
        int capacity4 = 5;
        System.out.println("Test case 4: " + solution(weights4, profits4, capacity4));
        // Expected output: 0
        // Explanation: All items are heavier than the capacity, so no items can be taken.

        System.out.println("\n\nTest case 5:\n\n");

        // Test case 5: All items fit exactly into the capacity
        int[] weights5 = {1, 2, 3};
        int[] profits5 = {10, 20, 30};
        int capacity5 = 6;
        System.out.println("Test case 5: " + solution(weights5, profits5, capacity5));
        // Expected output: 60
        // Explanation: All items can be taken for a total profit of 10 + 20 + 30 = 60.
    }





    public static int solution(int[] weights, int[] profits, int capacity){
        int len1 = weights.length;
        int[][] mat = new int[len1 + 1][capacity + 1];  //all entries are zero already

        System.out.println("This is the original matrix: ");
        print(mat, capacity);

        for(int i = 1; i <= len1; i++){
            for(int w = 0; w <= capacity; w++){
                if(i == 0 || w == 0){
                    mat[i][w] = 0;
                } else if (weights[i-1] <= w) {
                    mat[i][w] = Math.max(profits[i - 1] + mat[i -1][w - weights[i -1]], mat[i-1][w]);
                }
                else{
                    mat[i][w] = mat[i-1][w];
                }
            }
        }

        System.out.println("\n\n\nNew matrix:");
        print(mat, capacity);
        return mat[len1][capacity];
    }

    static void print(int[][] mat , int capacity){
        for(int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++) {
                if(j == 0){
                    System.out.print(" [ ");
                }
                System.out.print(mat[i][j] );

                if(j == capacity){
                    System.out.print(" ] ");
                    continue;
                }
                System.out.print(" , ");
            }
            System.out.println();
        }
    }
}
