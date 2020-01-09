import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-31 16:30
 **/
public class RadixSort {


    /**
     * 基数排序，时间复杂度 O(N),空间复杂度 O(N + K)
     * 稳定
     * @param arr
     */
    public void radixSort(int[] arr){

        //1. 先找出数组中的最大数
        int max = 0;
        for(int num : arr){
            if(max < num)
                max = num;
        }

        //求出最大数的位数，以便循环多少次
        int keysNum = (max + "").length();
        int[][] bucket = new int[10][arr.length]; // 二维数组十个桶，来装数据
        int[] order = new int[10]; //一维数组来统计每个桶中元素的个数
        int n = 1; //代表位数对应的数：1,10,100...
        int index = 0; //桶排序好后复制时原数组的下标


        while( keysNum > 0){
            //2.将数组中的数据分配到各个桶中
            for(int i = 0; i < arr.length; i ++){
                int digital = (arr[i] / n) % 10;
                bucket[digital][ order[digital] ] = arr[i];
                order[digital] ++ ;
            }

            //3.将桶中的数据复制到原数组中
            for(int i = 0; i < 10; i ++ ){
                if(order[i] != 0){
                    for(int j = 0; j < order[i]; j ++){
                        arr[index++] = bucket[i][j];
                    }
                }
                order[i] = 0;//注意，将桶里计数器置0，用于下一次位排序
            }

            n = n * 10;
            index = 0;
            keysNum -= 1;
        }
    }

    public static void main(String[] args){

        int[] arr = {1,3,2,5,3,0,8,5,6,9,2,3,4,9,3,2,1,3,2,3,4};
        new RadixSort().radixSort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
