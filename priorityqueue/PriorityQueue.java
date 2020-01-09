/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-09 10:30
 *
 *
 * 优先队列基于普通线性结构实现的话，入队 O(1),出队O(n)
 * 优先队列基于顺序线性结构实现的话，入队 O(n),出队O(1)
 * 优先队列基于最大堆实现的话，入队 O(log n),出队O(log n)
 **/
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap();
    }


    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);

    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
