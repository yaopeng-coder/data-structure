/**
 * 404
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-29 14:29
 **/

public class SumOfLeftLeaves {


      public class TreeNode {
          int val;
          TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
      }



    public int sumOfLeftLeaves(TreeNode root) {

        return sumOfLeftLeavesHelper(root,false);
    }


    public int sumOfLeftLeavesHelper(TreeNode root , boolean flag) {

        if(root == null)
            return 0;

        if(flag && root.left == null && root.right == null)
            return root.val;


        int left = sumOfLeftLeavesHelper(root.left,true);
        int right = sumOfLeftLeavesHelper(root.right,false);

        return left + right;

    }
}
