import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-31 12:41
 **/
public class QuickSort {


    /**
     * 快速排序，挖坑法 + 分治法
     * 时间复杂度 O(N*logN) 空间复杂度 O(N * log N) 不稳定
     * @param arr
     * @param left
     * @param right
     */
    public void quickSort(int[] arr, int left, int right){
        if(left < right){
            int l = left;
            int r = right;
            int temp = arr[l]; //第一个坑
            while(l < r){
                //从右向左找第一个小于temp的数
                while( l < r && arr[r] >= temp)
                    r --;
                if( l < r)
                    //将第一个坑给填了，然后arr[r]成了新坑，这是将 l++;
                    arr[l++] = arr[r];

                //从左向右找第一个大于temp的数，
                while( l < r && arr[l] <= temp)
                    l ++;
                if(l < r)
                    arr[r--] = arr[l];

            }
            //
            arr[l] = temp;
            //分治递归调用
            quickSort(arr,left,l-1);
            quickSort(arr,l+1,right);

        }
    }

    public static void main(String[] args){

        int[] arr = {1,3,2,5,3,0,8,5,6,9,-1,3,0,-5,-3,2,3,4,9,3,2,1,3,2,3,4};
        new QuickSort().quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));


    }
}
