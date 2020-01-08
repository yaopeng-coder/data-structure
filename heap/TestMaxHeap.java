import java.util.Random;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-08 21:53
 **/
public class TestMaxHeap {
    public static void main(String[] args){

        int n = 100000;

        Random random = new Random();
        MaxHeap<Integer> heap = new MaxHeap<>(n);

        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = heap.extractMax();
        }

        for(int i = 1; i < n; i ++){
            if(arr[i -1] < arr[i])
                throw new IllegalArgumentException("error");
        }

        System.out.println("test is success");



    }



}
