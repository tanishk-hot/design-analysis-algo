import java.util.ArrayList;

public class RearrangeArray {
    public static void main(String[] args) {
        int[] newArr = rearrangeArray(new int[]  {3,1,-2,-5,2,-4});
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }
    }

    public static int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                neg.add(nums[i]);
            }
            else{
                pos.add(nums[i]);
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(neg.get(i) + " " + pos.get(i));
        }

        int posIndex = 0;
        int negIndex = 0;
        boolean flag = true;

        for (int i = 0; i < nums.length; i++) {
            if (flag && posIndex < pos.size()) {
                nums[i] = pos.get(posIndex++);
                flag = false;
            } else if (!flag && negIndex < neg.size()) {
                nums[i] = neg.get(negIndex++);
                flag = true;
            }
        }
        int i = Math.min(pos.size(), neg.size());
        while(i < Math.max(pos.size(), neg.size())){
            if(pos.size() > neg.size()) {
                nums[i] = pos.get(i);
            }
            else{
                nums[i] = neg.size();
            }

            i++;
        }


        return nums;
    }
}
