/** 237
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-22 09:04
 **/
public class DeleteNode {

    public void deleteNode(ListNode node) {
        if(node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
