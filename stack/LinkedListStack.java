/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-28 10:27
 **/
public class LinkedListStack<E> implements Stack<E>{

    private LinkedList<E> linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }

    public int getSize(){
        return linkedList.getSize();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    public void push(E e){
        linkedList.addFirst(e);
    }

    public E pop(){
        return linkedList.removeFirst();
    }

    public E peek(){
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append("LinkedListStack: Top  ");

        res.append(linkedList);
        return res.toString();
    }

    public static void main(String[] args){


        Stack<Integer> stack = new LinkedListStack<>();

        for(int i = 0; i < 5; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);



    }
}
