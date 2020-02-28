package leetcode;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-02-28 09:46
 **/
public class removeDuplicatesAdvance {

    // public int removeDuplicates(int[] nums) {
    //     if(nums.length <= 2)
    //         return nums.length;

    //      int index = 1;
    //      for(int i = 2; i < nums.length; i ++){
    //          if(!(nums[index - 1] == nums[index] && nums[index] == nums[i])){
    //              nums[++ index] = nums[i];
    //          }
    //      }
    //      return index + 1;
    // }

    public int removeDuplicates(int[] nums) {

        if(nums.length <= 0)
            return nums.length;

        int index = 1; int count = 1;

        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == nums[i - 1]){
                count ++;
            }else{
                count = 1;
            }
            if(count <= 2)
                nums[index ++] = nums[i];
        }
        return index;
    }
}
