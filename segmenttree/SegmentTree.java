/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-09 16:01
 **/
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger){
        data = (E[]) new Object[arr.length];
        tree = (E[]) new Object[ 4 * arr.length];
        this.merger = merger;

        for(int i = 0; i < arr.length; i ++)
            data[i] = arr[i];

        buildSegmentTree(0,0,data.length - 1);

    }


    /**
     * 在treeIndex的位置创建表示区间[left...right]的线段树
     * 时间复杂度为 O(n)
     * @param treeIndex
     * @param left
     * @param right
     */
    private void buildSegmentTree(int treeIndex,int left , int right){

        if(left == right){
            tree[treeIndex] = data[left];
            return ;
        }

        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        int mid = left + (right - left) / 2;

        buildSegmentTree(leftIndex,left,mid);
        buildSegmentTree(rightIndex,mid + 1,right);
        tree[treeIndex] = merger.merge(tree[leftIndex],tree[rightIndex]);
    }


    /**
     * 返回区间[queryL, queryR]的值
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL,int queryR){

        return query(0,0,data.length - 1,queryL,queryR);

    }

    /**
     *  在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
     * @param treeIndex
     * @param leftIndex
     * @param rightIndex
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex, int leftIndex,int rightIndex, int queryL, int queryR){
        if(queryL < leftIndex || queryR > rightIndex || queryL > queryR)
            throw new IllegalArgumentException("error index is illeger");

        if(leftIndex == queryL && rightIndex == queryR)
            return tree[treeIndex];


        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        int mid = leftIndex + (rightIndex - leftIndex) / 2;

        if(queryL > mid ){
           return query(rightChild, mid + 1,rightIndex,queryL,queryR);
        }else if(queryR < mid + 1){
           return query(leftChild,leftIndex,mid,queryL,queryR);
        }else {

            E query1 = query(leftChild, leftIndex, mid, queryL, mid);
            E query2 = query(rightChild, mid + 1, rightIndex, mid + 1, queryR);
            return merger.merge(query1,query2);
        }

    }

    /**
     * 更新操作
     * @param index
     * @param e
     */
    public void update(int index , E e){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal");

        data[index] = e;
        update(0,0,data.length - 1,index,e);


    }

    /**
     * 更新线段树中index的节点为e
     * 时间复杂度为 O(log n)
     * @param treeIndex
     * @param left
     * @param right
     * @param index
     * @param e
     */
    public void update(int treeIndex, int left, int right, int index,E e){

        if(left == right){
            tree[treeIndex] = e;
            return;
        }




        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        int mid = left + (right - left) / 2;

        if(index <= mid){
            update(leftChild,left,mid,index,e);
        }else {
            update(rightChild,mid + 1, right,index,e);
        }

        tree[treeIndex] = merger.merge(tree[leftChild],tree[rightChild]);

    }


    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal");
        return data[index];
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    public int leftChild(int index){
        return 2 * index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    public int rightChild(int index){
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("segmentTree:[");
        for(int i = 0; i < tree.length; i ++){
            if(tree != null){
                res.append(tree[i]);
            }else {
                res.append("null");
            }

            if(i != tree.length - 1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }
}
