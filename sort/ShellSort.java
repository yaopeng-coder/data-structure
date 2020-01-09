import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-31 09:44
 **/
public class ShellSort {


    /**
     * 希尔排序 不稳定
     * 希尔排序的复杂度和增量序列是相关的
     * { 1,2,4,8,...}这种序列并不是很好的增量序列，使用这个增量序列的时间复杂度（最坏情形）是O(n^2)
     * Hibbard提出了另一个增量序列{1,3,7，...,2^k-1}，这种序列的时间复杂度(最坏情形)为O(n^1.5)
     * Sedgewick提出了几种增量序列，其最坏情形运行时间为O（n^1.3）,其中最好的一个序列是{1,5,19,41,109,...}
     * @param arr
     */
    public void shellSort(int[] arr){

        for(int gap = arr.length / 2; gap >= 1; gap = gap / 2){

            for(int i = gap; i < arr.length; i ++){
//                int insertVal = arr[i];
//                int insertIndex = i - gap;
//                while(insertIndex >= 0 && insertVal < arr[insertIndex] ){
//                     arr[insertIndex + gap] = arr[insertIndex];
//                     insertIndex = insertIndex - gap;
//                }
//               arr[insertIndex + gap] = insertVal;

                int insertVal = arr[i];
                int insertIndex;

                for( insertIndex = i - gap; insertIndex >= 0 && insertVal < arr[insertIndex]; insertIndex -= gap){
                    arr[insertIndex + gap] = arr[insertIndex];
                }
                arr[insertIndex + gap] = insertVal;


            }

        }

    }


    public static void main(String[] args){

        int[] arr = {1,3,2,5,3,0,8,5,6,9,-1,3,0,-5,-3};
        new ShellSort().shellSort(arr);
        System.out.println(Arrays.toString(arr));


    }

}
