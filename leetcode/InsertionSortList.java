/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-21 10:29
 **/
public class InsertionSortList {

    public static  ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        ListNode tail = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (tail.val < cur.val) {
                tail.next = cur;
                tail = cur;
                cur = cur.next;
            } else {

                ListNode tmp = cur.next;
                while (pre.next != null && pre.next.val < cur.val) pre = pre.next;
                cur.next = pre.next;
                pre.next = cur;
                pre = dummy;
                cur = tmp;
            }

            tail.next = null;
        }

        //2 4 1 3
        return dummy.next;



    }

    public static void main(String[] args){
        int[] arr = {-1,3,5,4,0};
        ListNode linkedList = LinkedListCreator.createLinkedList(arr);
        insertionSortList(linkedList);

    }
}
