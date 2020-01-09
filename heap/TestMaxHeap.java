import java.util.Arrays;
import java.util.Random;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-08 21:53
 **/
public class TestMaxHeap {

    public static double testHeap(Integer[] testArr, boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> heap;
        if(isHeapify){
            heap = new MaxHeap<>(testArr);
        }else {
            heap = new MaxHeap<>();
            for(Integer num : testArr){
                heap.add(num);
            }
        }

        int[] arr = new int[testArr.length];

        for(int i = 0; i < testArr.length; i++){
            arr[i] = heap.extractMax();
        }
        System.out.println(Arrays.toString(arr));

        for(int i = 1; i < testArr.length; i ++){
            if(arr[i -1] < arr[i])
                throw new IllegalArgumentException("error");
        }

        System.out.println("test is pass");

        long endTime = System.nanoTime();
        double result = (endTime - startTime) / 1000000000.0;
        return result;



    }



    public static void main(String[] args){
//
//        int n = 100000;
//
//        Random random = new Random();
//        MaxHeap<Integer> heap = new MaxHeap<>(n);
//
//        for (int i = 0; i < n; i++) {
//            heap.add(random.nextInt(Integer.MAX_VALUE));
//        }
//        int[] arr = new int[n];
//
//        for(int i = 0; i < n; i++){
//            arr[i] = heap.extractMax();
//        }
//
//        for(int i = 1; i < n; i ++){
//            if(arr[i -1] < arr[i])
//                throw new IllegalArgumentException("error");
//        }
//
//        System.out.println("test is success");

        int n = 100;

        Random random = new Random();
        Integer[] testArr = new Integer[n];

        for (int i = 0; i < n; i++) {
            testArr[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(testArr,true);
        System.out.println("with heapify , time:" + time1 + "s");

        double time2 = testHeap(testArr,false);
        System.out.println("without heapify , time:" + time2 + "s");


    }



}
