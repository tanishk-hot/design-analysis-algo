import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {

    public static void main(String[] args) {
        List<Integer> ans = maj2(new int[] {1,2});
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }


    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = mp.getOrDefault(nums[i] , 0);
            mp.put(nums[i], a + 1);
            if(mp.get(nums[i]) > n/3 ){
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static List<Integer> maj2(int[] nums){
        List<Integer> ans = new ArrayList<>();
        if(nums.length == 0){
            return ans;
        }
        Arrays.sort(nums);
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                count++;
            }
            else{
                if(count > nums.length/3){
                    ans.add(nums[i-1]);
                }
                count = 1;
            }
        }
        if(count > nums.length/3){
            ans.add(nums[nums.length-1]);
        }
        return ans;
    }

}
