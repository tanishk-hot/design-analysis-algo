class Solution {
    public int longestConsecutive(int[] nums) {
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