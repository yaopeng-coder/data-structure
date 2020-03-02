package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-02 11:20
 **/
public class FourSum {


        public List<List<Integer>> fourSum(int[] nums, int target) {

            List<List<Integer>> list = new ArrayList();

            Arrays.sort(nums);


            for(int i = 0; i < nums.length; i++){

                //保证不重复第一点
                while( i > 0 && i < nums.length && nums[i] == nums[i - 1])
                    i ++;



                for(int j = i + 1; j < nums.length; j ++){


                    //注意保证不重复是j > i+1
                    while( j > i + 1 && j < nums.length && nums[j] == nums[j - 1])
                        j ++;

                    int l = j + 1;
                    int r = nums.length -1 ;
                    while( l < r ){
                        if(nums[i] + nums[j] + nums[l] + nums[r] == target){
                            list.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                            while( l < r && nums[l] == nums[ ++l]);
                            while(l < r && nums[r] == nums[--r]);
                        }else if(nums[i] + nums[j] + nums[l] + nums[r] < target){
                            l ++;
                        }else {
                            r --;
                        }

                    }


                }


            }

            return list;
        }
}
