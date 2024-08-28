import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,0,1};
        //expected output = 3
        System.out.println(longest(arr));
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
    public static int longest(int[] nums){
        int max = 0;

        if(nums.length  <= 1){
            return nums.length;
        }
        Arrays.sort(nums);

        int j = 1;
        int count = 1;
        while(j < nums.length) {
            if (nums[j] == nums[j-1]) {
                j++;
                continue;
            }
            if (nums[j-1] + 1 == nums[j]) {
                count++;
            }else{
                max = Math.max(max, count);
                count =1;
            }
            j++;
        }
        max = Math.max(max, count);
        return max;
    }
}
