import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-06 09:21
 **/
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] strArray =  str.split(" ");
        if(pattern.length() != strArray.length)
            return false;

        Map<Character,String> map = new HashMap();


        for(int i = 0; i < pattern.length(); i ++){

            char c = pattern.charAt(i);

            if(map.containsKey(c)){

                if(!map.get(c).equals(strArray[i]))
                    return false;

            }else{

                //注意不包含这个Key时，需要判断两个不同的Key对应的value也不能相同
                if(map.containsValue(strArray[i]))
                    return false;

                map.put(c,strArray[i]);

            }

        }

        return true;

    }

    public static void main(String[] args){
        new WordPattern().wordPattern("abba","dog dog dog dog");
    }
}
