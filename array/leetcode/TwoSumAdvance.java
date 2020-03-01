package leetcode;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-01 10:40
 **/
public class TwoSumAdvance {

    int[] result  = new int[2];

    public int[] twoSum(int[] numbers, int target) {
        //二分查找法 时间复杂度为 O(N log n)


        for(int i = 0; i < numbers.length; i ++){
            int search = target - numbers[i];

            //二分查找
            Boolean  flag = bs(numbers,0,numbers.length - 1,search);
            if(flag){
                result[0] = i + 1;
                return result;
            }


        }

        throw new IllegalArgumentException("no result");
    }

    public Boolean bs (int[] nums , int left , int right ,int search){

        while(left <= right){

            int mid = left + (right - left) / 2;

            if( nums[mid] ==  search){
                this.result[1] = mid + 1;
                return true;
            }else if(nums[mid] < search){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        return false;


    }
}
