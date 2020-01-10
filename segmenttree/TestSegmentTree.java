/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-09 16:21
 **/
public class TestSegmentTree {


    public static void main(String[] args){

        Integer[] arr = {1,2,3,4,5,6,7,8};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr,
                (a,b) -> ( a + b));
        System.out.println(segmentTree);
        segmentTree.update(0,22);
        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0,0));


    }
}
