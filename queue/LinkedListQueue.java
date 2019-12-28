/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-28 11:08
 **/
public class LinkedListQueue<E> implements Queue<E>{

    private class Node{
        public E e;
        public Node next;

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

    private Node dummyHead,tail;
    private int size;


    public LinkedListQueue(){
        dummyHead = new Node();
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            dummyHead.next = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }

        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("dequeue fail, queue is empty");

        Node retNod = dummyHead.next;
        dummyHead.next = retNod.next;
        retNod.next = null;
        if(dummyHead.next == null)
            tail = null;

        size --;

        return retNod.e;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("getFront fail, queue is empty");

        Node node = dummyHead.next;
        return node.e;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Queue:front  ");
        Node cur = dummyHead.next;
        while(cur != null){
            str.append(cur + "->");
            cur = cur.next;
        }


        str.append("NULL    tail");
        return str.toString();
    }

    public static void main(String[] args){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0; i < 19; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if( i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
