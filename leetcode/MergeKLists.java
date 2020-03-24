import java.util.PriorityQueue;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-20 10:05
 **/
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;

       

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> (a.val - b.val));

        for( int i = 0; i < lists.length; i ++){
            if(lists[i] != null){
                queue.add(lists[i]);
            }
        }

        while(!queue.isEmpty()){
            ListNode cur = queue.poll();
            prev.next  = cur;
            prev = prev.next;

            if(cur.next != null){
                queue.add(cur.next);
            }
        }

        return dummyHead.next;
    }

    class ListNode {
         int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
