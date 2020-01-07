/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-07 20:45
 **/
public class BSTMap<K extends Comparable,V> implements Map<K,V> {


    class Node{
        private  K key;
        private  V value;
        private Node left;
        private Node right;

        public Node(K key, V value, Node left, Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key,V value){
            this(key,value,null,null);
        }

        private Node(){
            this(null,null,null,null);
        }

    }

    private Node root;
    private int size;

    public BSTMap(){
        root = new Node();
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
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    private Node add(Node node,K key, V value){

        if(node == null)
            return new Node(key,value);


        if(node.key.compareTo(key) > 0){
            node.left = add(node.left,key,value);
        }else if(node.key.compareTo(key) < 0){
            node.right = add(node.right,key,value);
        }else {
            node.value = value;
        }
        return node;

    }

    private Node getNode(Node node,K key){

        if(node == null)
            return null;

        if(node.key.compareTo(key) > 0){
           return getNode(node.left,key);
        }else if(node.key.compareTo(key) < 0){
            return getNode(node.right,key);
        }else {
            return node;
        }


    }


    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);

        return node == null ? null : node.value;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public void set(K key, V newValue) {

        Node node = getNode(root,key);
        if(node == null){
            throw new IllegalArgumentException("set error key is not exist");
        }

        node.value = newValue;
    }
}
