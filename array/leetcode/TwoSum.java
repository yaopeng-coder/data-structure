package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-01 10:07
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        //两遍哈希法
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i ++){
            map.put(nums[i],i);
        }

        for(int i = 0; i < nums.length; i ++){
            int searchEle = target - nums[i];

            if(map.containsKey(searchEle) && map.get(searchEle) != i)
                return new int[]{map.get(searchEle),i};
        }

        throw new IllegalArgumentException("no  result");
    }


    public int[] twoSum1(int[] nums, int target) {

        //一遍哈希法
        Map<Integer,Integer> map = new HashMap();


        for(int i = 0; i < nums.length; i ++){
            int searchEle = target - nums[i];

            if(map.containsKey(searchEle) ){
                return new int[]{map.get(searchEle),i};
            }else {
                map.put(nums[i],i);
            }
        }

        throw new IllegalArgumentException("no  result");
    }
}
