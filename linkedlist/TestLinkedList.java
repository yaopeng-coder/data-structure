/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-27 20:46
 **/
public class TestLinkedList {

    public static void main(String[] args){

        LinkedList<Integer> linkedList  = new LinkedList<>();

        for(int i = 0; i < 5; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.set(244,2);
        System.out.println(linkedList);

        System.out.println("contains 244" + linkedList.contain(244));

        System.out.println(linkedList.get(2));

        linkedList.remove(2);
        System.out.println(linkedList);

        System.out.println("contains 244" + linkedList.contain(244));

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);



    }
}
