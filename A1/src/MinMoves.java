import java.util.Arrays;

public class MinMoves {
    public static void main(String[] args) {
        int a = minMovesToSeat(new int[] {3,1,5} , new int[] {2,7,4});
        System.out.println(a);
    }
    public static int minMovesToSeat(int[] seats, int[] students) {
        int moves = 0;
        Arrays.sort(seats);
        Arrays.sort(students);

        for(int i = 0; i < seats.length; i++){
            moves += Math.abs(students[i] - seats[i]);
        }
        return moves;
    }
}
