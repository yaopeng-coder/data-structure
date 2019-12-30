import java.util.Random;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-30 13:21
 **/
public class Compare {

    public static void main(String[] args){
        Random random = new Random();
        int[] arr = new int[100000];
        for(int i = 0; i <arr.length; i ++){
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }

        long startTime = System.nanoTime();

        //冒泡时间：25.3183559s
       //   new BubbleSort().bubbleSort(arr);

        //简单排序时间：6.9415147s
      //   new SimpleSelectSort().simpleSelectSort(arr);

         //简单插入排序:2.2622407
        new InsertSort().insertSort(arr);


        long endTime  = System.nanoTime();
        double res = (endTime - startTime) / 1000000000.0;
        System.out.println(res);


    }
}
