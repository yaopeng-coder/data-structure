import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *  340 最长最多K个无重复字符的字符串长度
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-04 12:13
 **/
public class LengthOfLongestSubstringKDistinct {

    //滑动窗口+ hashMap解决
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        Map<Character,Integer> map = new HashMap();

        int n = s.length();
        int res = 0;

        for(int right = 0, left = 0;right < n; right++){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),right);
            }else if(!map.containsKey(s.charAt(right)) && map.size() < k){
                map.put(s.charAt(right),right);
            }else{
                //说明此时已满，需要踢去一个元素
                int minIndex = Collections.min(map.values());
                map.remove(s.charAt(minIndex));
                left = minIndex + 1;
            }

            res = Math.max(res,right - left + 1);

        }


        return res;

    }

    public static void main(String[] args){
    System.out.println(new LengthOfLongestSubstringKDistinct().lengthOfLongestSubstringKDistinct("ececbac",2));
    }
}
