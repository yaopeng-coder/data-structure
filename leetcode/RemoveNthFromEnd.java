/**  19
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-22 09:28
 **/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode first = dummyHead;
        ListNode second = dummyHead;

        while(n >= 0){
            second = second.next;
            n --;
        }

        while(second != null){
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
        return dummyHead.next;
    }
}
