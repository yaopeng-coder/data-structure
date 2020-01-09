import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-30 12:22
 **/
public class BubbleSort {


    /**
     * 冒泡排序算法
     * @param arr
     */
    public void bubbleSort(int[] arr){

        boolean flag = false; //标志位，若在一趟排序过程中未进行任何一次交换，则可以认为数组有序

        for(int j = 1; j < arr.length; j ++) {
            for (int i = 0; i < arr.length - j; i++) {
                int temp = 0;
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
            if(!flag)
                break;
            //重置标志位
            flag = false;
        }
    }

    public static void main(String[] args){
        int[] arr = {4,5,2,1,5,6,7};
        new BubbleSort().bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
