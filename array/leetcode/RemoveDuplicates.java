package leetcode;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-02-28 09:45
 **/
public class RemoveDuplicates {

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
            if(count <= 1)
                nums[index ++] = nums[i];
        }
        return index;
    }
}
