import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-09 10:16
 **/
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        //维护一个string -> list 的映射

        if(strs == null || strs.length ==0)
            return new ArrayList();

        Map<String,List<String>> map = new HashMap();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if(!map.containsKey(key))
                map.put(key , new ArrayList());

            map.get(key).add(str);

        }

        return new ArrayList(map.values());

    }
}
