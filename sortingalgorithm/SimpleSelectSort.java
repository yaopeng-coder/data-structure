/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-30 12:55
 **/
public class SimpleSelectSort {


    /**
     * 时间复杂度O(N^2)
     * 空间复杂度O(1)
     * 简单选择排序
     * @param arr
     */
    public void simpleSelectSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i ++){
            int min = arr[i];
            int minIndex = i;
            for(int j = i + 1; j < arr.length ; j ++){
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
      //      System.out.println(Arrays.toString(arr));

        }
    }


    public static void main(String[] args){

        int[] arr = {4,5,2,1,5,6,7};
        new SimpleSelectSort().simpleSelectSort(arr);

    }
}
