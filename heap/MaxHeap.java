/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-08 21:23
 **/
public class MaxHeap<E extends Comparable> {

    private Array<E> array;


    public MaxHeap(int capacity){
        array = new Array<>(capacity);
    }

    public MaxHeap(){
        array = new Array<>();
    }

    public int getSize(){
        return array.getSize();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    /**
     * 返回给定索引的父节点的索引
     * @param index
     * @return
     */
    public int parent(int index){
        return (index - 1) / 2;
    }

    /**
     * 返回给定索引的左孩子节点的索引
     * @param index
     * @return
     */
    public int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回给定索引的右孩子节点的索引
     * @param index
     * @return
     */
    public int rightChild(int index){
        return index * 2 + 2;
    }

    /**
     * 添加一个节点，需保证堆的性质，完全二叉树，每个节点的值大于等于孩子节点的值
     * @param e
     */
    public void add(E e){
        array.addLast(e);
        siftUp(array.getSize() - 1);
    }

    /**
     * 递归上浮节点
     * @param index
     */
    private void siftUp(int index){
        if(index == 0 )
            return;

        if(array.get(index).compareTo(array.get(parent(index))) > 0){
            array.swap(index,parent(index));
            siftUp(parent(index));
        }
    }

    /**
     * 删除堆中的最大节点
     * @return
     */
    public E extractMax(){
        if(array.isEmpty())
            throw new IllegalArgumentException("error,the heap is empty");

        E max = array.get(0);
        array.swap(0,array.getSize() - 1);
        array.removeLast();
        siftDown(0);
        return max;
    }

    /**
     * 递归下沉某节点
     * @param index
     */
    private void siftDown(int index){

        if(leftChild(index) >= array.getSize())
            return;


        int j = leftChild(index);
        if(rightChild(index) < array.getSize() && array.get(leftChild(index)).compareTo(array.get(rightChild(index)))<0)
            j = rightChild(index);

        if(array.get(index).compareTo(array.get(j)) < 0){
            array.swap(index,j);
            siftDown(j);
        }

    }




}
