/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-08 21:23
 **/
public class MaxHeap<E extends Comparable<E>> {


    //堆可以方便地用数组存储。在数组上做事情，也比用指针快。
   // 代价则是，堆不能做快速的查找或者删除任意元素，它是专门针对“更”快速地寻找最大最小元素设计的动态数据结构。

    private Array<E> array;


    public MaxHeap(int capacity){
        array = new Array<>(capacity);
    }

    public MaxHeap(){
        array = new Array<>();
    }

    /**
     * 给定一个数组，将其转化成最大堆，Heapify的过程
     * 时间复杂度为O(n),计算很麻烦
     * @param arr
     */
    public MaxHeap(E[] arr){
        array = new Array<>(arr);
        //从第一个非叶子节点开始遍历下沉操作
        for(int i = parent(array.getSize() - 1); i >= 0; i --){
            siftDown(i);
        }
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

    public E findMax(){
        if(array.isEmpty())
            throw new IllegalArgumentException("error,the heap is empty");

       return array.get(0);
    }

    /**
     * 添加一个节点，需保证堆的性质，完全二叉树，每个节点的值大于等于孩子节点的值
     * 时间复杂度 O(log n)
     * @param e
     */
    public void add(E e){
        array.addLast(e);
        siftUpNR(array.getSize() - 1);
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
     * 非递归上浮节点
     * @param index
     */
    private void siftUpNR(int index){
        while(index > 0){
            if(array.get(index).compareTo(array.get(parent(index))) <= 0 )
                break;

            array.swap(index, parent(index));
            index = parent(index);
        }
    }

    /**
     * 删除堆中的最大节点
     * 时间复杂度 O(log n)
     * @return
     */
    public E extractMax(){


        E max = findMax();
        array.swap(0,array.getSize() - 1);
        array.removeLast();
        siftDownNR(0);
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

    /**
     * 非递归下沉某节点
     * @param index
     */
    private void siftDownNR(int index){

        //1.注意循环终止条件
        while(leftChild(index) < array.getSize()){

            //2.找出左右孩子中最大节点
            int j = leftChild(index);
            if(rightChild(index) < array.getSize() && array.get(leftChild(index)).compareTo(array.get(rightChild(index))) < 0)
                j = rightChild(index);

            //3.比较最大节点与父节点
            if(array.get(index).compareTo(array.get(j)) >= 0)
                break;

            array.swap(index,j);
            index = j;
        }

    }

    /**
     * 将堆中最大的元素和给定的元素进行替换
     * 时间复杂度 O(log n)
     * @param e
     * @return
     */
    public E replace(E e){


        E ret = findMax();
        array.set(0,e);
        siftDown(0);
        return ret;
    }





}
