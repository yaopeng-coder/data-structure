package leetcode;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-02-28 09:45
 **/
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int index = 0; //[0,index)中元素均没有value
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != val){
                nums[index ++] = nums[i];
            }
        }
        return index;
    }
}
