/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-02 19:08
 **/
public class BST<E extends Comparable<E>> {


    private class Node{
        private E e;
        private Node left;
        private Node right;

        public Node(E e){
            this.e = e;
            left = right = null;
        }
    }

    private Node root;
    private int size;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 添加叶子节点
     * @param e
     */
    public void add(E e){

      root = addElement(root,e);

    }

    /**
     * 递归实现，向以Node为根的二分搜索树中插入元素e，返回插入新节点后二分搜索树的根
     * 对比链表的插入元素的实现
     * @param node
     * @param e
     */
    private Node addElement(Node node, E e){

        if(node == null){
            size ++;
            return new Node(e);

        }

        if(e.compareTo(node.e) < 0)
            node.left = addElement(node.left,e);
        else if(e.compareTo(node.e) > 0)
           node.right = addElement(node.right,e);

        return node;
    }


    /**
     * 非递归添加节点
     * 同链表中的非递归添加节点，我们必须找到待添加元素之前的节点pre，让pre->next是新的节点，才能将新的节点挂接在链表上：
     * @param e
     */
    public void addNode(E e){
        if(root == null){
            root = new Node(e);
            size ++;
        }else {
            Node prev = root;
            while(true){
                if(e.compareTo(prev.e) == 0){
                    return ;
                }else if(e.compareTo(prev.e) < 0 && prev.left == null){
                    prev.left = new Node(e);
                    size ++;
                    return;
                }else if(e.compareTo(prev.e) > 0 && prev.right == null){
                    prev.right = new Node(e);
                    size ++;
                    return;
                }
                if(e.compareTo(prev.e) < 0){
                    prev = prev.left;
                }else if(e.compareTo(prev.e) > 0){
                    prev = prev.right;
                }
            }
        }



    }


    /**
     * 判断二叉搜索树是否包含某节点
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    /**
     * 递归实现 是否包含某个元素
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e){
        if(node == null)
            return false;

        if(e.compareTo(node.e) == 0){
            return true;
        } else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }

    }

    /**
     * 非递归实现判断二叉树是否包含某个元素
     * @param e
     * @return
     */
    public boolean containsNode(E e) {
        Node cur = root;
        if (cur == null)
            return false;

        while (cur != null) {
            if (e.compareTo(cur.e) == 0) {
                return true;
            } else if (e.compareTo(cur.e) < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;

    }

    //前序遍历
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 递归实现前序遍历
     * @param node
     */
    private void preOrder(Node node){

        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }

    /**
     * 非递归实现前序遍历
     */
    public void preNode() {
        Stack<Node> stack = new ArrayStack<>();

        if (root == null)
            return;

        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);

            if (cur.left != null)
                stack.push(cur.left);

        }


    }


}
