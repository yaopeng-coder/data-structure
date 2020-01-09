import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-30 14:02
 **/
public class InsertSort {


    /**
     * 插入排序，时间复杂度O(N^2),其实是O(N*N-1 / 2)
     * 空间复杂度O(1)
     * @param arr
     */
    public void insertSort(int[] arr){

        for(int i = 1; i < arr.length; i ++){

            int insertVal = arr[i];
            int insertIndex = i - 1;
            while(insertIndex >= 0 && arr[insertIndex] > insertVal){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex -- ;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }


    public static void main(String[] args){

        int[] arr = {1,3,2,5,3,0,8,5,6,9};
        new InsertSort().insertSort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
