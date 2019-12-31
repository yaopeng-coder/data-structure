import java.util.Random;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-22 13:36
 **/
public class TestCompareQueue {


    /**
     * 对于ArrayQueue,时间复杂度为o(n^2)
     * LoopQueue,时间复杂度为o(n)
     * LinkedListQueue 时间复杂度O(n)
     *
     * 数据规模为十万时，时间
     * ArrayQueue time :6.559617s
       LoopQueue timw :0.0202558s  扩容损耗
      LinkedListQueue time :0.0142153s
     * @param queue
     * @param opCount
     * @return
     */
    public static double test(Queue<Integer> queue, int opCount){
        Random random = new Random();

        long startTime = System.nanoTime();
     //   long time1 = System.currentTimeMillis();

        for(int i = 0; i < opCount; i ++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));

        for(int i = 0; i < opCount; i ++)
            queue.dequeue();

        long endTime = System.nanoTime();
   //     long time2 = System.currentTimeMillis();

        double res = (endTime - startTime) / 1000000000.0;
      //  double res1 = (time1 - time2)/1000.0000000;
      //  System.out.println("res1:"+ res1);

        return res;


    }



    public static void main(String[] args){

        int opCount = 100000;

        Queue<Integer> q1 = new ArrayQueue<>();
        Queue<Integer> q2 = new LoopQueue<>();
        Queue<Integer> q3 = new LinkedListQueue<>();


        double time1 = test(q1, opCount);
        double time2 = test(q2,opCount);
        double time3 = test(q3,opCount);

        System.out.println("ArrayQueue time :" + time1 + "s");
        System.out.println("LoopQueue time :" + time2 + "s");
        System.out.println("LinkedListQueue time :" + time3 + "s");




    }
}
