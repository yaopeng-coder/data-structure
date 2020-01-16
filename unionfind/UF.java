/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-16 14:35
 **/
public interface UF {


    int getSize();

    void union(int x ,int y);

    boolean isConnected(int x , int y);
}
