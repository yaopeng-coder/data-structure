import java.util.Random;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-30 13:21
 **/
public class Compare {

    public static void main(String[] args){
        Random random = new Random();
        int[] arr = new int[1000000];
        for(int i = 0; i <arr.length; i ++){
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }

        long startTime = System.nanoTime();

        //冒泡时间：25.3183559s（十万）
       //   new BubbleSort().bubbleSort(arr);

        //快速排序 0.2328577（百万）
        new QuickSort().quickSort(arr,0,arr.length - 1);

        //简单选择排序：6.9415147s（十万）
        // new SimpleSelectSort().simpleSelectSort(arr);

         //简单插入排序:2.2622407（十万）
      //  new InsertSort().insertSort(arr);

        //希尔排序 0.4535101 不稳定（百万）
       // new ShellSort().shellSort(arr);

        //归并排序 :0.4019824（百万）
       // new MergeSort().mergeSort(arr,0,arr.length - 1 );

        //基数排序 0.1776644（百万）
       // new RadixSort().radixSort(arr);


        long endTime  = System.nanoTime();
        double res = (endTime - startTime) / 1000000000.0;
        System.out.println(res);




    }
}
