/**
 * 栈的应用  undo操作---编辑器    系统调用栈---操作系统   括号匹配---编译器
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-20 19:36
 **/
public class ArrayStack<E> implements Stack<E> {


    Array<E> array;


   public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

   public ArrayStack(){
        array = new Array<>();
    }


    /**
     * 向栈中压入一个元素
     * 时间复杂度O(1),均摊
     * @param e
     */
    @Override
    public void push(E e) {

        array.addLast(e);
    }


    /**
     * 弹出一个栈顶元素
     * 时间复杂度O(1)，均摊
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     * 时间复杂度O(1)
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 得到栈元素的个数
     * 时间复杂度O(1)
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 栈是否为空
     * 时间复杂度O(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 得到栈的容量，因为这是基于动态数组实现的栈，所以有容量的概念
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Stack: [");

        for(int i = 0; i < array.getSize(); i ++){
            res.append(array.get(i));

            if( i != array.getSize() - 1)
                res.append(",");
        }

        res.append("]");
        return res.toString();
    }
}
