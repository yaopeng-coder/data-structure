/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-07 20:03
 **/
public interface Map<K,V> {


    int getSize();
    boolean isEmpty();
    void add(K key, V value);
    boolean contains(K key);
    V get(K key);
    V remove(K key);
    void set(K key, V newValue);

}
