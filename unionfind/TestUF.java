import java.util.Random;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-16 15:55
 **/
public class TestUF {


    public static double test(UF uf , int m){
        Random random = new Random();
        long startTime = System.nanoTime();

        int size = uf.getSize();
        for(int i = 0; i < m; i ++){
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            uf.union(p,q);
        }

        for(int i = 0; i < m; i ++){
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            uf.isConnected(p,q);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }


    public static void main(String[] args){

        int size = 10000000;

        int m = 10000000;

//        UF uf1 = new UnionFind1(size);
//        System.out.println(test(uf1,m));
//
//        UF uf2 = new UnionFind2(size);
//        System.out.println(test(uf2,m));

        UF uf3 = new UnionFind3(size);
        System.out.println(test(uf3,m));

        UF uf4 = new UnionFind4(size);
        System.out.println(test(uf4,m));

        UF uf5 = new UnionFind5(size);
        System.out.println(test(uf5,m));

        UF uf6 = new UnionFind6(size);
        System.out.println(test(uf6,m));
    }
}
