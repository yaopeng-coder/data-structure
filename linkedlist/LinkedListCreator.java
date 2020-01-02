import java.util.Arrays;
import java.util.List;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-29 15:53
 **/
public class LinkedListCreator {

    /**
     * create a linkedlist
     * @param arr
     * @return
     */
    public static ListNode createLinkedList(int[] arr){

        if( arr == null || arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        head.next  = createLinkedList(Arrays.copyOfRange(arr,1,arr.length));
        return head;

    }

    public static ListNode createLinkedList(List<Integer> data){

        if( data.isEmpty())
            return null;

        ListNode head = new ListNode(data.get(0));
        head.next  = createLinkedList(data.subList(1,data.size()));
        return head;

    }

   public static String printList(ListNode head){

        StringBuilder res = new StringBuilder("List: ");
        while(head != null){
            res.append(head.val + "->" );
            head = head.next;
        }
        res.append("null");
        return res.toString();
   }

   public static void main(String[] args){

       int[] arr = null;
       System.out.println(printList(createLinkedList(arr)));

       int[] arr1 = {1};
       System.out.println(printList(createLinkedList(arr1)));

       int[] arr2 = {1,2,3,4};
       System.out.println(printList(createLinkedList(arr2)));


       System.out.println(printList(createLinkedList(Arrays.asList())));
       System.out.println(printList(createLinkedList(Arrays.asList(1))));
       System.out.println(printList(createLinkedList(Arrays.asList(1,2,3,4))));


   }

}
