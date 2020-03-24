
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/** 103
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-24 10:00
 **/
public class ZigzagLevelOrder {
    class TreeNode {
       int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        int level = 0;

        if(root == null)
            return result;

        queue.add(root);

        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList();
            level ++;

            for(int i = 0; i < count; i ++){
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }

            if(level % 2 == 0)
                Collections.reverse(list);

            result.add(list);

        }



        return result;
    }
}
