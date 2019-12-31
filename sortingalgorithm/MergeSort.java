import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-31 14:25
 **/
public class MergeSort {


    /**
     * 归并排序 时间复杂度 O(N*logN) 空间复杂度 O(N)，稳定
     * @param arr
     * @param left
     * @param right
     */
    public void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid + 1,right);
            merge(arr,left,mid,right);

        }
    }

    public void merge(int[] arr, int left, int mid, int right){
        int[] tempArr = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;

        while(p1 <= mid && p2 <= right)
            tempArr[i ++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];

        while( p1 <= mid)
            tempArr[i ++] = arr[p1 ++];

        while(p2 <= right)
            tempArr[i ++] = arr[p2 ++];

        for(int j = 0; j < tempArr.length; j ++)
            arr[left + j] = tempArr[j];

    }

    public static void main(String[] args){

        int[] arr = {1,3,2,5,3,0,8,5,6,9,-1,3,0,-5,-3,2,3,4,9,3,2,1,3,2,3,4};
        new MergeSort().mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));


    }
}
