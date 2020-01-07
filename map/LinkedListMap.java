/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-07 20:05
 **/
public class LinkedListMap<K,V> implements Map<K,V> {

    class Node{
        private K key;
        private V value;
        private Node next;

        public Node(){
           this(null,null,null);
        }

        public Node(K key, V value){
           this(key,value,null);
        }

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "key:"+ key + ",value:"+ value;
        }
    }

    private Node dummyHead;
    private int size;


    public LinkedListMap(){
        dummyHead = new Node();
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

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;

    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size ++;
        }else {
            node.value = value;
        }

    }

    @Override
    public boolean contains(K key) {
       Node node = getNode(key);
        return node != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(key)){
                Node cur = prev.next;
                prev.next = cur.next;
                cur.next = null;
                size --;
                return cur.value;
            }
            prev = prev.next;
        }

        return null;
    }

    @Override
    public void set(K key, V newValue) {
       Node node = getNode(key);
       if(node == null)
           throw new IllegalArgumentException(" key is not exist");

       node.value = newValue;

    }
}
