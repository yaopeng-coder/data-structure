import java.util.Random;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-22 13:36
 **/
public class TestCompareStack {


    /**
     *
     * 数据规模为十万时，时间
     * ArrayStack time :0.0322291s 需要扩容
       LinkedListStack time :0.0144603s new 一个Node会需要耗时间
     * @param stack
     * @param opCount
     * @return
     */
    public static double test(Stack<Integer> stack, int opCount){
        Random random = new Random();

        long startTime = System.nanoTime();

        for(int i = 0; i < opCount; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));

        for(int i = 0; i < opCount; i ++)
            stack.pop();

        long endTime = System.nanoTime();

        double res = (endTime - startTime) / 1000000000.0;

        return res;


    }



    public static void main(String[] args){

        int opCount = 100000;

        Stack<Integer> s1 = new ArrayStack<>();
        Stack<Integer> s2 = new LinkedListStack<>();


        double time1 = test(s1, opCount);
        double time2 = test(s2,opCount);

        System.out.println("ArrayStack time :" + time1 + "s");
        System.out.println("LinkedListStack time :" + time2 + "s");




    }
}
