import java.util.HashMap;
import java.util.Map;

/**
 *
 * 205. 同构字符串
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-06 09:55
 **/
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;

        Map<Character,Character> map = new HashMap();


        for(int i = 0; i < s.length() ; i ++){

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map.containsKey(c1)){
                if(map.get(c1) != c2)
                    return false;
            } else {

                if(map.containsValue(c2))
                    return false;

                map.put(c1,c2);


            }


        }

        return true;

    }
}
