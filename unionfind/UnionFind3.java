/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-16 14:52
 **/
public class UnionFind3 implements UF {

    private int[] parent; //记录每个节点的父节点
    private int[] sz; // sz[i]表示以i为根的集合中元素个数

    public UnionFind3(int size){
        parent = new int[size];

        sz = new int[size];

        //刚开始，每一个节点的父节点都是指向自己
        for(int i = 0; i < size; i ++){
            parent[i] = i;
            sz[i] = 1;
        }

    }

    @Override
    public int getSize(){
        return parent.length;
    }

    /**
     * 查找一个元素所属的集合
     * 时间复杂度为O(h), h为树的高度
     * @param p
     * @return
     */
    public int find(int p){
        if( p < 0 || p >= parent.length)
            throw new IllegalArgumentException("index is illegal");

        while( p != parent[p])
            p = parent[p];

        return p;

    }


    /**
     * O(h)复杂度, h为树的高度
     * @param x
     * @param y
     */
    @Override
    public void union(int x, int y) {

        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot == yRoot)
            return ;

        if(sz[xRoot] < sz[yRoot]){
            parent[xRoot] = yRoot;
            sz[yRoot] += sz[xRoot];
        }else {
            parent[yRoot] = xRoot;
            sz[xRoot] += sz[yRoot];
        }


    }

    /**
     * 时间复杂度为O(h), h为树的高度
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
