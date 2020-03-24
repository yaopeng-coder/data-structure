import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 199
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-24 10:41
 **/
public class RightSideView {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<Integer> rightSideView(TreeNode root) {
        //bfs遍历
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();

                if( i == size - 1)
                    result.add(node.val);

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }

        }

        return result;
    }
}
