import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-02 19:08
 **/
public class BST<E extends Comparable<E>> {


    private class Node {
        private E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
            left = right = null;
        }
    }

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加叶子节点
     *
     * @param e
     */
    public void add(E e) {

        //注意，要让root节点指向返回后的结果
        root = addElement(root, e);

    }

    /**
     * 递归实现，向以Node为根的二分搜索树中插入元素e，返回插入新节点后二分搜索树的根
     * 对比链表的插入元素的实现
     *
     * @param node
     * @param e
     */
    private Node addElement(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);

        }

        if (e.compareTo(node.e) < 0)
            node.left = addElement(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = addElement(node.right, e);

        return node;
    }


    /**
     * 非递归添加节点
     * 同链表中的非递归添加节点，我们必须找到待添加元素之前的节点pre，让pre->next是新的节点，才能将新的节点挂接在链表上：
     *
     * @param e
     */
    public void addNode(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            Node prev = root;
            while (true) {
                if (e.compareTo(prev.e) == 0) {
                    return;
                } else if (e.compareTo(prev.e) < 0 && prev.left == null) {
                    prev.left = new Node(e);
                    size++;
                    return;
                } else if (e.compareTo(prev.e) > 0 && prev.right == null) {
                    prev.right = new Node(e);
                    size++;
                    return;
                }
                if (e.compareTo(prev.e) < 0) {
                    prev = prev.left;
                } else if (e.compareTo(prev.e) > 0) {
                    prev = prev.right;
                }
            }
        }


    }


    /**
     * 判断二叉搜索树是否包含某节点
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 递归实现 是否包含某个元素
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }

    }

    /**
     * 非递归实现判断二叉树是否包含某个元素
     *
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
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 递归实现前序遍历
     *
     * @param node
     */
    private void preOrder(Node node) {

        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }

    /**
     * 非递归实现前序遍历
     */
    public void preOrderNR() {
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

    /**
     * 二叉搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 二叉搜索树的中序遍历递归实现
     *
     * @param node
     */
    private void inOrder(Node node) {

        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 二叉搜索树的中序遍历非递归实现
     */
    public void inOrderNR() {
        Stack<Node> stack = new ArrayStack<>();
        Node cur = root;

        while (!stack.isEmpty() || cur != null) {

            //1.不断往左子树深入并不断入栈直到左叶子的空左孩子
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            //2.弹出栈顶，打印值，并将指针指向它的右孩子
            if (!stack.isEmpty()) {
                cur = stack.pop();
                System.out.println(cur.e);
                cur = cur.right;
            }
        }

    }

    /**
     * 二叉搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 二叉搜索树的后序遍历递归实现
     *
     * @param node
     */
    private void postOrder(Node node) {

        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 二叉搜索树的后序遍历非递归实现
     */
    public void postOrderNR() {
        Stack<Node> stack = new ArrayStack<>();
        Node cur = root;
        Node last = null;

        while (!stack.isEmpty() || cur != null) {

            //不断往左子树深入并不断入栈直到左叶子的空左孩子
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty()) {
                cur = stack.pop();
                //如果右孩子为null或者last是右孩子，则打印当前值；如果不是，则将指针指向右孩子
                if (cur.right == null || cur.right == last) {
                    System.out.println(cur.e);
                    last = cur;
                    //注意，这里一定要置空
                    cur = null;
                } else {
                    //因为当前结点未打印，所以要重新放回去，等右孩子打印完之后回来打印
                    stack.push(cur);
                    cur = cur.right;
                }

            }

        }
    }

    /**
     * 二叉搜索树的层序遍历
     * 用到队列
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();

        if (root == null)
            return;

        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.add(cur.left);

            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    /**
     * 得到二叉树的最小元素
     * @return
     */
    public E getMin(){

        if(root == null)
            throw new IllegalArgumentException("BST is empty");

       return getMin(root).e;

    }

    /**
     * 得到二叉树的最小元素 递归
     * @param node
     * @return
     */
    private Node getMin(Node node){

        if(node.left == null)
            return node;

        return getMin(node.left);
    }

    /**
     * 得到二叉树的最小元素 非递归
     * @return
     */
    public E getMinNR(){
        if(root == null)
            throw new IllegalArgumentException("BST is empty");

        Node cur = root;
        while(cur.left != null){
            cur = cur.left;
        }

        return cur.e;

    }


    /**
     * 得到二叉树的最大元素
     * @return
     */
    public E getMax(){

        if(root == null)
            throw new IllegalArgumentException("BST is empty");

        return getMax(root).e;

    }

    /**
     * 得到二叉树的最大元素 递归
     * @param node
     * @return
     */
    private Node getMax(Node node){

        if(node.right == null)
            return node;

        return getMax(node.right);
    }

    /**
     * 得到二叉树的最大元素 非递归
     * @return
     */
    public E getMaxNR(){
        if(root == null)
            throw new IllegalArgumentException("BST is empty");

        Node cur = root;
        while(cur.right != null){
            cur = cur.right;
        }

        return cur.e;

    }


    /**
     * 删除最小元素
     * @return
     */
    public E removeMin(){
        //在getMin中已经判断了root是否为空
        E min = getMin();
        root = removeMin(root);
        return min;

    }

    /**
     * 返回删除最小元素后的头节点
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最小元素，非递归
     * @return
     */
    public E removeMinNR(){
        if(root == null)
            throw new IllegalArgumentException("BST is empty");

        if(root.left == null){
            E min = root.e;
            root = root.right;
            size --;
            return min;
        }

        Node prev = root;
        Node cur = root;

        while(cur.left != null){
            prev = cur;
            cur = cur.left;
        }

        E min = cur.e;
        prev.left = cur.right;
        cur.right = null;
        size --;
        return min;
    }

    /**
     * 删除最大元素
     * @return
     */
    public E removeMax(){
        //在getMin中已经判断了root是否为空
        E max = getMax();
        root = removeMax(root);
        return max;

    }

    /**
     * 返回删除最大元素后的头节点,递归
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除最大元素，非递归
     * @return
     */
    public E removeMaxNR(){
        if(root == null)
            throw new IllegalArgumentException("BST is empty");

        if(root.right == null){
            E max = root.e;
            root = root.left;
            size --;
            return max;
        }

        //用来保存删除结点的上一个节点
        Node prev = root;
        Node cur = root;

        while(cur.right != null){
            prev = cur;
            cur = cur.right;
        }

        E max = cur.e;
        prev.right = cur.left;
        cur.left = null;
        size --;
        return max;
    }


    public void remove(E e){
        root = remove(root,e);
    }

    /**
     *  删除掉以node为根的二分搜索树中值为e的节点, 递归算法
     *  返回删除节点后新的二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node,E e){

        if(node == null)
            return null;


        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else {
            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size -- ;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }


            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
                Node temp = getMin(node.right);
                //在remove过程中已经进行了size -- 的操作
                temp.right = removeMin(node.right);
                temp.left = node.left;
                node.left = node.right = null;
                return temp;


        }
    }



}
