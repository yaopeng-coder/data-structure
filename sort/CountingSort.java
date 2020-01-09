import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-02 14:51
 **/
public class CountingSort {


    /**
     * 计数排序，时间复杂度为O(n)
     * @param arr
     */
    public void countingSort(int[] arr){
        //1.找出最大的数，然后分配相应的桶
        int max = arr[0];
        for(int i = 1; i <arr.length; i++){
            if(max < arr[i])
                max = arr[i];
        }

        //// 申请一个计数数组bucket，下标大小[0,max]
        int[] bucket = new int[max + 1];

        //2.将数组中的数分配到相应的桶子中
        for(int i = 0; i < arr.length; i ++){
            bucket[arr[i]]++;
        }

        //依次累加，便于后面计算索引
        for(int i = 1; i <bucket.length; i++ ){
            bucket[i] = bucket[i - 1] + bucket[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] ret = new int[arr.length];

        // 计算排序的关键步骤
        for(int i = arr.length - 1; i >= 0; i --){

            //得到该元素应有的下标
            int index = bucket[arr[i]] - 1;
            ret[index] = arr[i];
            bucket[arr[i]] --;
        }

        for(int i = 0; i < arr.length; i ++){
            arr[i] = ret[i];
        }
    }



    public static void main(String[] args){

        int[] arr = {1,3,2,5,3,0,8,5,6,9,2,3,4,9,3,2,1,3,2,3,4};
        new CountingSort().countingSort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
