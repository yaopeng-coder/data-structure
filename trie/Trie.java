import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-10 14:02
 **/
public class Trie {



    class Node{
        boolean isWord;
        Map<Character,Node> next;

        public Node(){
            isWord = false;
            next = new TreeMap<>();
        }
    }


    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向trie树中添加节点
     * @param word
     */
    public void addNR(String word){
        Node cur  = root;

        for(int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size ++;
        }
    }

    /**
     * 插入一个字符串
     * @param word
     */
    public void add(String word){
        add(root,word);
    }

    /**
     * 递归插入一个字符串
     * @param node
     * @param word
     */
    public void add(Node node,String word){

        if(word.length() == 0){
            if(!node.isWord){
                node.isWord = true;
                size ++;
            }
            return ;
        }


        char c = word.charAt(0);
        String s1 = word.substring(1,word.length());
        if(node.next.get(c) == null)
            node.next.put(c,new Node());
        add(node.next.get(c),s1);

    }

    /**
     * 查询trie树中是否有给定的字符串
     * @param s
     */
    public boolean contains(String s){

        return contains(root,s);
    }

    /**
     * 递归查询是否包含此节点
     * @param node
     * @param word
     * @return
     */
    private boolean contains(Node node,String word){
        if(word.length() == 0){
            return node.isWord;
        }

        char c = word.charAt(0);
        if(node.next.get(c) == null) {
            return false;
        }else {
                String s1 = word.substring(1,word.length());
                return contains(node.next.get(c),s1);
        }
    }

    /**
     * 非递归查询trie树是否包含某个节点
     * @param word
     * @return
     */
    public boolean containsNR(String word){
        Node cur = root;

        for(int i = 0; i <word.length(); i ++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    public boolean isPrefix(String prefix){
        Node cur = root;

        for(int i = 0; i < prefix.length();i ++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;

            cur = cur.next.get(c);
        }

        return true;
    }

    public boolean search(String word) {
        return search(root,word,0);
    }

    private boolean search(Node node,String word,int index){

        if(index == word.length()){
            return node.isWord;
        }


        char c = word.charAt(index);
        if(c != '.'){
            if(node.next.get(c) == null)
                return false;
            return search(node.next.get(c),word,index + 1);
        }else {
            Iterator<Character> iterator = node.next.keySet().iterator();
            while(iterator.hasNext()){
                Character character = iterator.next();
                if(search(node.next.get(character),word,index + 1))
                      return true;
            }
            return false;
        }

    }





    public static void main(String[] args){

        Trie trie = new Trie();
        trie.add("ssss");
        trie.add("aaaa");
        System.out.println(trie.contains("sss"));
        System.out.println(trie.contains("aaaa"));
        System.out.println(trie.isPrefix("aa"));
        System.out.println(trie.search(".s.s"));



    }
}
