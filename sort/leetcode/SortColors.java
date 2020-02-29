package leetcode;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-02-29 09:29
 **/
public class SortColors {


    public void sortColors1(int[] nums) {
        //使用计数排序
        int[] count = new int[3];

        for(int i = 0; i < nums.length; i ++){
            count[nums[i]] ++;
        }

        for(int i = 0 ; i <count[0]; i ++){
            nums[i] = 0;
        }

        for(int i = count[0] ; i <count[0] + count[1]; i ++){
            nums[i] = 1;
        }
        for(int i = count[0] + count[1] ; i <nums.length; i ++){
            nums[i] = 2;
        }

    }


    public void sortColors(int[] nums){

        //[0 , zero] == 0   [zero + 1 , i) == 1; [two ,n] == 2;

        int zero = -1; int two = nums.length ;

        for(int i = 0 ; i < two;){
            if(nums[i] == 1){
                i ++ ;
            }else if(nums[i] == 0){
                //swap nums[++zero],nums[i] ,且 i ++
                swap(nums,++ zero, i);
                i ++;
            }else{

                //swap nums[--two] , nums[i]
                swap(nums,--two,i);
            }



        }

    }

    public void swap(int[] nums, int index1 , int index2){

        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2 ] = temp;

    }

}
