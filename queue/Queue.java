/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-21 19:48
 **/
public interface Queue<E> {

     int getSize();

     boolean isEmpty();

     void enqueue(E e);

     E dequeue();

     E getFront();

}
