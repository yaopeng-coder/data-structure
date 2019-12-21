/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-21 19:49
 **/
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        this(10);
    }

    /**
     * 时间复杂度 o(1)
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 时间复杂度 o(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 入队，时间复杂度 o(1)
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队，时间复杂度 o(n)
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 得到队列首元素，时间复杂度 o(1)
     * @return
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }


    public int getCapacity(){
        return array.getCapacity();
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(String.format("Queue: size : %d \ntop[",getSize()));

        for(int i = 0; i < array.getSize(); i ++){
            res.append(array.get(i));

            if( i != array.getSize() - 1)
                res.append(",");
        }

        res.append("]tail");
        return res.toString();
    }
}
