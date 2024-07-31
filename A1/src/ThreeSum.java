import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = 0; j < nums.length-2; j++) {
                for (int k = 0; k < nums.length-1; k++) {
                    if(i == j || j == k || k ==i){
                        continue;
                    }
                }
            }

        }
    }
}
