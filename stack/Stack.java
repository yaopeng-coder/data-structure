/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-20 19:34
 **/
public interface Stack<E> {


    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
