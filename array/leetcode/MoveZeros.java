package leetcode;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-02-27 11:38
 **/
public class MoveZeros {

    // 283 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    public void moveZeroes(int[] nums) {
        int index = 0;// 表示Nums数组从[0，index)均为非0元素
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != 0 ){
                if( index != i){
                    int k = nums[index];
                    nums[index ++] = nums[i];
                    nums[i] = k;
                }else {
                    index ++;
                }
            }
        }
    }
}
