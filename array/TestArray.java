/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-19 12:44
 **/
public class TestArray {



    public static void main(String[] args){

        Array array = new Array(18);
        for(int i = 0; i < 10; i++){
            array.addLast(i);
        }

        System.out.println(array);

        array.addFirst(111);
        System.out.println(array);

        array.add(5,222);
        System.out.println(array);

        System.out.println(array.get(5));

        array.set(1,333);
        System.out.println(array);

        System.out.println(array.contains(333));

        System.out.println(array.find(333));

        array.removeLast();
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

        array.remove(3);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        array.removeElement(33333);
        System.out.println(array);

    }
}
