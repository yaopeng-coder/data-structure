/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-06 20:31
 **/
public class LinkedListSet<E> implements Set<E> {

    private LinkedList linkedList;

    public LinkedListSet(){
        linkedList = new LinkedList();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void add(E e) {
        if(!linkedList.contain(e)){
            linkedList.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contain(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }
}
