import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-29 16:23
 **/
public class ReverseList {


    public static ListNode reverse(ListNode head){

        //size = 0 || size == 1
        if(head == null || head.next == null)
            return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;


    }

    public static void main(String[] args){

       System.out.println(LinkedListCreator.printList(reverse(LinkedListCreator.createLinkedList(Arrays.asList()))));
       System.out.println(LinkedListCreator.printList(reverse(LinkedListCreator.createLinkedList(Arrays.asList(1)))));
       System.out.println(LinkedListCreator.printList(reverse(LinkedListCreator.createLinkedList(Arrays.asList(1,2)))));
       System.out.println(LinkedListCreator.printList(reverse(LinkedListCreator.createLinkedList(Arrays.asList(1,2,3,4,5)))));

    }
}
