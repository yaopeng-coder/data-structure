/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-02 20:54
 **/
public class TestBST {


    public static void main(String[] args){

        int[] arr = {6,3,5,7,2,0,9};
        BST<Integer> bst = new BST<>();
        for(int num : arr)
            bst.add(num);

        bst.preNode();
        bst.preOrder();

        System.out.println(bst.contains(6));
        System.out.println(bst.contains(4));


    }
}
