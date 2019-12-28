/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-21 20:22
 **/
public class LoopQueue<E>  implements Queue<E>{

    private E[] data;
    private int front,tail;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = tail = 0;
    }

    public LoopQueue(){
        this(10);
    }


    /**
     * 时间复杂度 o(1)
     * @return
     */
    @Override
    public boolean isEmpty(){
        return front == tail;
    }


    /**
     * 时间复杂度 o(1)
     * @return
     */
    public int getCapacity(){
        return data.length - 1;
    }

    /**
     * 时间复杂度 o(1)
     * @return
     */
    @Override
    public int getSize() {
        return (tail + data.length - front) % data.length;
    }

    /**
     * 时间复杂度 o(1) ，均摊
     * @param e
     */
    @Override
    public void enqueue(E e){
        if((tail+1) % data.length == front)
            resize( 2 * (data.length - 1));

        data[tail] = e;
        tail = (tail + 1) % data.length;
//        if((tail + 1) % data.length == 0){
//            tail = 0;
//        }else{
//            tail++;
//        }
    }

    /**
     * 时间复杂度 o(1)，均摊
     * @return
     */
    @Override
    public E dequeue(){
        if(front == tail)
           throw new IllegalArgumentException("dqueue is fail, queue is empty");
        E res = data[front];
        //方便垃圾回收
        data[front] = null;

        front = (front + 1) % data.length;
//        if((front + 1) % data.length == 0){
//            front = 0;
//        }else {
//            front++;
//        }
        if(getSize() == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return res;
    }

    /**
     * 时间复杂度 o(1)
     * @return
     */
    @Override
    public E getFront(){
        if(front == tail)
            throw new IllegalArgumentException("getFront fail, queue is empty");

        return data[front];
    }


    /**
     * 时间复杂度 o(n)
     * @param newCapacity
     */
    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];

        for(int i = 0; i < getSize(); i ++){
            newData[i] = data[ (i + front) % data.length];
        }

        //注意，这里一定要先getSize,如果在之后，front改变了会影响getSize的结果
        int size = getSize();

        data = newData;
        front = 0;
        tail = size;

    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder(String.format("queue ,size:%d  capacity:%d\n [",getSize(),getCapacity()));

        for(int i = 0; i < getSize(); i ++){
            res.append(data[(i + front) % data.length]);
            if( i != getSize() - 1)
                res.append(",");
          }
        res.append("]");
        return res.toString();
    }


}
