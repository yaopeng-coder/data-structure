/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-21 19:56
 **/
public class TestQueue {

    public static void main(String[] args){

        ArrayQueue<Integer> queue = new ArrayQueue<>();

//        for(int i = 0; i < 20; i ++){
//            queue.enqueue(i);
//            System.out.println(queue);
//            if( i % 3 == 1){
//                queue.dequeue();
//                System.out.println(queue);
//            }
//        }

        LoopQueue<Integer> queue1 = new LoopQueue<>();
        for(int i = 0; i < 20; i ++){
            queue1.enqueue(i);
            System.out.println(queue1);
            if( i % 3 == 2){
                queue1.dequeue();
                System.out.println(queue1);
            }
        }



    }
}
