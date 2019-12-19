/**
 * 实现一个数组类
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-18 20:53
 **/
public class Array<E> {

    private E[] data; //数组data存放数据
    private int size;  //数组内元素的个数

    /**
     * Array带参数的构造函数，容量大小为capacity
     * @param capacity
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
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
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 向数组头部插入新元素e
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 向索引Index位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index , E e){

//        //ERROR判断索引是否合法
//        if(index < 0 || index > data.length - 1){
//            throw new IllegalArgumentException("add fail; index is illegal");
//        }

        //设计成有序的插入,是将数组做为集合类使用,只是存储数据，索引没有语义
        //如果设计成在任意位置插入值，但是不能超过数组本身的长度的时候，索引带有语义，把数组当做哈希表用
        if(index < 0 || index > size)
            throw new IllegalArgumentException("add fail , index is illegal");

        //判断数组是否已满
        if( size == data.length)
            resize(2 * data.length);



        //将索引后面的元素向后移一位
        for(int i = size -1; i >= index; i--){
            data[i+1] = data[i];
        }

        data[index] = e;

        size++;




    }


    /**
     * 得到索引index的数组元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("get fail, index is illegal");
        }

        return data[index];
    }

    /**
     * 将索引index的元素设置为新元素e
     * @param index
     * @param e
     */
    public void set(int index ,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("set fail, index is illegal");
        }

        data[index] = e;
    }


    /**
     * 数组是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for(int i = 0; i < size; i ++){
            if(data[i].equals(e))
                return true;
        }

        return false;
    }

    /**
     * 查找元素e的下标
     * @param e
     * @return
     */
    public int find(E e){
        for(int i = 0; i < size; i ++){
            if(data[i].equals(e))
                return i;
        }

        return -1;
    }

    /**
     * 删除数组头元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除数组末尾元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        int index = find(e);

        if(index != -1){
            remove(index);
        }else {
            throw new IllegalArgumentException("removeElement fail , the element is not exist in array");
        }

    }

    /**
     * 删除索引Index的元素
     * @param index
     * @return
     */
    public E remove(int index){

        if(index < 0 || index >= size)
            throw new IllegalArgumentException("remove fail , index is illegal");

        E res = data[index];

        for(int i = index + 1; i < size; i ++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;

        if(size == data.length / 2)
            resize(data.length / 2);

        return res;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];

        for(int i = 0; i < size; i ++){
            newData[i] = data[i];
        }

        data = newData;
    }


    /**
     * 重写toString函数
     * @return
     */
    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size is %d,  Array capacity is %d \n",size,data.length));
        res.append("[");

        for(int i = 0; i < size; i++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(",");
        }

        res.append("]");
        return res.toString();
    }



}
