/**
 *
 * 相比数组，虽然可能很多方法复杂度为o(n)，但是他是动态数据结构，节省内存
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-27 16:44
 **/
public class LinkedList<E> {

    private class Node<E>{
        private E e;
        private Node next;

        public Node(E e){
            this.e = e;
            next = null;
        }

        private Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        private Node(){
            e = null;
            next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node dummyHead;
    private int size;


    public LinkedList(){
        // head 代表虚拟节点
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 得到链表的长度
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 时间复杂度O(1)
     * 添加到链表的头部
     * @param e
     */
    public void addFirst(E e){
        add(e,0);
    }

    /**
     * 时间复杂度O(n)
     * 添加到链表的index位置
     * @param e
     * @param index
     */
    public void add(E e ,int index){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("add fail,index is illegal");


            Node prev = dummyHead;
            for(int i = 0; i < index ; i ++)
                prev = prev.next;

            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;

           // prev.next = new Node(e,prev.next);

            size ++;
    }

    /**
     * 时间复杂度O(n)
     * 添加到链表的尾部
     * @param e
     */
    public void addLast(E e){
        add(e,size);
    }

    /**
     * 时间复杂度O(n)
     * 更新Index的元素
     * @param e
     * @param index
     */
    public void set(E e,int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("set fail,index is illegal");

        Node cur = dummyHead.next;
        for(int i = 0; i < index ; i ++)
            cur = cur.next;

        cur.e = e;
    }

    /**
     * 时间复杂度O(n)
     * 得到下标为Index的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("get fail,index is illegal");

        Node cur = dummyHead.next;
        for(int i = 0; i < index; i ++)
            cur = cur.next;

        return (E)cur.e;
    }

    /**
     * 时间复杂度O(1)
     * 得到链表的首个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 时间复杂度O(n)
     * 得到链表的最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 时间复杂度O(n)
     * 判断链表是否包含某元素
     * @param e
     * @return
     */
    public boolean contain(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }

        return false;
    }

    /**
     * 时间复杂度O(n)
     * 删除某个元素
     * @param index
     * @return
     */
    public E remove(int index){

        if(index < 0 || index >= size)
            throw new IllegalArgumentException("remove fail,index is illegal");

        Node prev = dummyHead;

        for(int i = 0; i < index; i ++)
            prev = prev.next;

        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        size = size - 1;
        return (E)cur.e;

    }

    /**
     * 时间复杂度O(1)
     * 删除头元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 时间复杂度O(n)
     * 删除尾元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1 ) ;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null){
            str.append(cur + "->");
            cur = cur.next;
        }


        str.append("NULL");
        return str.toString();
    }
}
