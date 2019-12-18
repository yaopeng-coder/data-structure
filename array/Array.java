/**
 * 实现一个数组类
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-18 20:53
 **/
public class Array {

    private int[] data; //数组data存放数据
    private int size;  //数组内元素的个数

    /**
     * Array带参数的构造函数，容量大小为capacity
     * @param capacity
     */
    public Array(int capacity){
        data = new int[capacity];
        size = 0 ;
    }

    /**
     * Array无参构造函数，默认初始容量大小为10
     */
    public Array(){
        this(10);
    }

    /**
     * 返回数组元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向数组末尾插入新元素e
     * @param e
     */
    public void addLast(int e){
        add(size,e);
    }

    /**
     * 向数组头部插入新元素e
     * @param e
     */
    public void addFirst(int e){
        add(0,e);
    }

    /**
     * 向索引Index位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index , int e){
        //判断数组是否已满
        if( size == data.length){
            throw new IllegalArgumentException("add fail ; Array is full");
        }

//        //ERROR判断索引是否合法
//        if(index < 0 || index > data.length - 1){
//            throw new IllegalArgumentException("add fail; index is illegal");
//        }

        //设计成有序的插入,是将数组做为集合类使用,只是存储数据，索引没有语义
        //如果设计成在任意位置插入值，但是不能超过数组本身的长度的时候，索引带有语义，把数组当做哈希表用
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add fail , index is illegal");
        }


        //将索引后面的元素向后移一位
        for(int i = size -1; i >= index; i--){
            data[i+1] = data[i];
        }

        data[index] = e;

        size++;




    }



}
