/**
 * 203 .移除链表元素
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-28 14:09
 **/
public class LeetCodeRemove {

    /**
     * 不用虚拟头节点解决
     * @param head
     * @param val
     * @return
     */
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

    /**
     * 用虚拟头节点解决
     * @param head
     * @param val
     * @return
     */
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

    /**
     * 用递归解决
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {

        if(head == null)
            return head;

        ListNode secondeNode = removeElements2(head.next,val);
        if(head.val == val){
            head = secondeNode;
        }else {
            head.next = secondeNode;
        }
        return head;


    }

    public static void main(String[] args){

        int[] arr = {1,2,1,3,4,1};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode retNode = new LeetCodeRemove().removeElements2(head,1);
        System.out.println(retNode);
    }

}
