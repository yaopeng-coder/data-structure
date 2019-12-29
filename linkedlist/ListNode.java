/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-28 14:08
 **/
public class ListNode {

      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      ListNode(int[] arr){
          if(arr == null || arr.length == 0)
              throw new IllegalArgumentException("数组不合法");

          this.val = arr[0];
          ListNode cur = this;

          for(int i = 1; i < arr.length; i ++){
              cur.next = new ListNode(arr[i]);
              cur = cur.next;
          }
      }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while(cur != null){
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}
