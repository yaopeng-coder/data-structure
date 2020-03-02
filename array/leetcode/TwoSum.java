package leetcode;

import java.util.*;

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


    //对两数之和进行改造，假设也有多解
    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> list = new ArrayList();

        if(nums.length < 2)
            return list;

        //对数组进行排序
        Arrays.sort(nums);



        //遍历数组
        int l = 0 ; int r = nums.length - 1;
        while( l < r){
            if(nums[l] + nums[r] == 9){
                list.add(Arrays.asList(nums[l], nums[r]));

                while( l < r && nums[l] == nums[l + 1])
                    l ++;

                while( l < r && nums[r] == nums[r - 1])
                    r--;

                l++;
                r--;
            }else if(nums[l] + nums[r] < 9){
                l++;
            }else{
                r --;
            }

        }





        return list;


    }
}
