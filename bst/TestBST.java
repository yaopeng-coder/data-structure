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

        bst.remove(5);
        bst.inOrder();


//        ArrayList list = new ArrayList();
//        for(int i = 0; i <arr.length; i ++){
//            list.add(bst.removeMax());
//        }
//        System.out.println(list);

       // bst.preOrderNR();
     //   bst.preOrder();

       // bst.inOrder();
      //  bst.inOrderNR();
       // bst.postOrder();
      //  bst.postOrderNR();
        //bst.levelOrder();



      //  System.out.println(bst.contains(6));
      //  System.out.println(bst.contains(4));


    }
}
