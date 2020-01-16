/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-16 14:37
 **/
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size){
        id = new int[size];
        for(int i = 0; i < size; i ++){
            id[i] = i;
        }
    }


    public int getSize(){
        return id.length;
    }

    public boolean isEmpty(){
        return id.length == 0;
    }

    /**
     *  查找元素p所对应的集合编号
     *  时间复杂度O(1)
     * @param p
     * @return
     */
    public int find(int p){
        if( p < 0 || p >=id.length)
            throw new IllegalArgumentException("index is illegal");

        return id[p];
    }

    /**
     * 合并元素X和元素Y所属的集合
     * 时间复杂度为O(N)
     * @param x
     * @param y
     */
    @Override
    public void union(int x, int y) {
        int idx = find(x);
        int idy = find(y);

        if(idx == idy)
            return;

        for(int i = 0; i < id.length; i ++){
          if(id[i] == idx)
              id[i] = idy;
        }
    }

    /**
     * 时间复杂度为O(1)
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
