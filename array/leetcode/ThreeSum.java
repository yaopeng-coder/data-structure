package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-02 10:19
 **/
public class ThreeSum {


    //重点时如何保证不重复 两个地方保证
    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> list = new ArrayList();

        if(nums.length < 3)
            return list;

        //对数组进行排序
        Arrays.sort(nums);



        //遍历数组
        for(int i = 0; i < nums.length; i ++){

            //如果大于0 ，直接返回
            if(nums[i] > 0)
                break;

            //第一个地方保证
            while( i > 0 && i < nums.length && nums[i] == nums[i - 1])
                i ++;

            //双指针遍历
            int l = i + 1; int r = nums.length - 1;
            while( l < r){
                if(nums[i] + nums[l] + nums[r] == 0){

                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //第二个地方保证，仍然需要遍历  因为可能有多个解 但是为了去重，需要保证指针移到的下个元素和该元素不一样才行
                    while(l < r && nums[l] == nums [l + 1])
                        l++;
                    while(l < r && nums[r] == nums[r - 1])
                        r--;


                    //注意迭代
                    l++;
                    r--;

                }else if(nums[i] + nums[l] + nums[r] < 0){
                    l ++;
                }else{
                    r --;
                }

            }


        }

        return list;


    }




}
