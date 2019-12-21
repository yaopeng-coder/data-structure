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


    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    @Override
    public int getSize() {
        return (tail + data.length - front) % data.length;
    }

    @Override
    public void enqueue(E e){
        if((tail+1) % data.length == front)
            resize( 2 * (data.length - 1));

        data[tail] = e;
        if((tail + 1) % data.length == 0){
            tail = 0;
        }else{
            tail++;
        }
    }

    @Override
    public E dequeue(){
        if(front == tail)
           throw new IllegalArgumentException("dqueue is fail, queue is empty");
        E res = data[front];
        if((front + 1) % data.length == 0){
            front = 0;
        }else {
            front++;
        }
        return res;
    }

    @Override
    public E getFront(){
        if(front == tail)
            throw new IllegalArgumentException("getFront fail, queue is empty");

        return data[front];
    }


    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];

        for(int i = 0; i < getSize(); i ++){
            newData[i] = data[ (i + front) % data.length];
        }

        int size = getSize();

        data = newData;
        front = 0;
        tail = size;

    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder(String.format("queue ,size:%d\n [",getSize()));

        for(int i = 0; i < getSize(); i ++){
            res.append(data[(i + front) % data.length]);
            if( i != getSize() - 1)
                res.append(",");
          }
        res.append("]");
        return res.toString();
    }


}
