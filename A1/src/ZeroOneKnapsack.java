public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] weights  = {3,4,6,5};
        int[] profits = {2,3,1,4};
        solution(weights,profits,8);
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
