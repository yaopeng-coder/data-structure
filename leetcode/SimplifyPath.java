
import java.util.Stack;

/** 71
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-23 09:33
 **/
public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] array = path.split("/");
        Stack<String> stack = new Stack();

        for(int i = 0; i < array.length; i ++){
            if(array[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!array[i].equals(".")  && array[i].length() != 0){
                stack.push(array[i]);
            }
        }

        String result = "";
        if(stack.isEmpty())
            return "/";

        while(!stack.isEmpty()){
            String str = stack.pop();
            result = "/" + str + result;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(new SimplifyPath().simplifyPath("/home/..//../..//"));
    }
}
