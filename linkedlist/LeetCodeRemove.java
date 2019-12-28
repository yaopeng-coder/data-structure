/**
 * 203 .移除链表元素
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-28 14:09
 **/
public class LeetCodeRemove {

    public ListNode removeElements(ListNode head, int val) {

        //不用虚拟头节点时，必须考虑删除节点是头节点和不是头节点两种情况
        while(head != null && head.val == val)
            head = head.next;

        if(head == null)
            return null;

        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;



    }

    public ListNode removeElements1(ListNode head, int val) {
        //利用虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }

        return dummyHead.next;



    }

}
