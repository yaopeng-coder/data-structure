/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-20 19:45
 **/
public class TestStack {


    public static void main(String[] args){


        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i = 0; i < 5; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);



    }
}
