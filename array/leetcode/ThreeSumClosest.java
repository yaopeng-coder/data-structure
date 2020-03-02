package leetcode;

import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-02 11:03
 **/
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        int result = nums[0] + nums[1] + nums[2];

        //-5 - 4 -3 -2 3  -1

        Arrays.sort(nums);


        //遍历
        for(int i = 0 ; i < nums.length - 1; i ++){
            int l = i + 1;
            int r = nums.length - 1;

            while( l < r){
                if(nums[i] + nums[l] + nums[r] == target){
                    return target;
                }else if(nums[i] + nums[l] + nums[r] < target){
                    int sum = nums[i] + nums[l] + nums[r];
                    if(Math.abs(sum - target) < Math.abs(result - target))
                        result = sum;
                    l ++;
                }else{
                    int sum = nums[i] + nums[l] + nums[r];
                    if(Math.abs(sum - target) < Math.abs(result - target))
                        result = sum;
                    r--;
                }

            }

        }

        return result;

    }
}
