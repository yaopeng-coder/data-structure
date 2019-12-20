
import java.util.Stack;

/**
 * 有效的括号匹配问题
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-20 21:23
 **/
public class ValidParentheses {


        public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < s.length(); i ++){
                char c = s.charAt(i);

                if(c == '(' || c == '{' || c == '['){
                    stack.push(c);
                }else{
                    if(stack.isEmpty())
                        return false;
                    char charTop = stack.pop();
                    if(c == ')' && charTop != '(')
                        return false;
                    if(c == '}' && charTop != '{')
                        return false;
                    if(c == ']' && charTop != '[')
                        return false;
                }

            }
            return stack.isEmpty();
        }
    }

