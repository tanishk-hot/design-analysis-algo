public class N_Queens {

    public static void main(String[] args) {
        int n = 4;
        int[] arr = new int[n];
        N_Queens nQueens = new N_Queens();
        nQueens.NQueens(arr, 0, n);
    }
    public boolean place(int k, int i, int[] arr){
        for(int j = 0; j < k; j++){
            if((arr[j] == i) || (arr[j]-i) == (j-k) || arr[j] - i == k - j){
                return false;
            }
        }
        return true;
    }
    private void printSolution(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    void NQueens(int[] arr, int k, int n){
        for(int i = 0; i < n;i++){
            if(place(k,i,arr)){
                arr[k] = i;
                if(k == n-1){
                    printSolution(arr,n);
                }
                else{
                    NQueens(arr, k+1,n);
                }
            }
        }
    }

}
