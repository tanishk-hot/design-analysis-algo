import java.util.Arrays;

public class MaxCon {
    public static void main(String[] args) {

        int a = longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1});
        System.out.println(a);
    }
    public static int longestConsecutive(int[] nums) {
        int max = 0;
        int count = 1;
        Arrays.sort(nums);
        if(nums.length  <= 1){
            return nums.length;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1] != nums[i] + 1){
                count = 1;
            }
            if(nums[i+1] == nums[i] + 1){
                count++;
            }
            if(max < count){
                max = count;
            }
        }
        return max;
    }
}
