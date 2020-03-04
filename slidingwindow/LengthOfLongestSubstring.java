import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-03 11:22
 **/
public class LengthOfLongestSubstring {

    // public int lengthOfLongestSubstring(String s) {

    //     char[] str = s.toCharArray();

    //     char[] nums = new char[256];

    //     //滑动窗口 [left,right]
    //     int left = 0 , right = -1;
    //     int res = 0; int count = 0;

    //     while(left < s.length()){
    //         if(right + 1 < s.length() && nums[str[right + 1]] == 0){
    //             nums[str[++right]] ++;
    //             count ++;
    //         }else{
    //             nums[str[left++]]--;
    //             count --;
    //         }

    //         res = res >= count ? res :count;
    //     }

    //     return res;
    // }


    //此种遍历方式可能需要遍历两个 n
    // public int lengthOfLongestSubstring(String s){

    //     Set<Character> set = new HashSet();

    //     //滑动窗口 [left ,right)
    //     int left = 0 , right = 0;
    //     int n = s.length();
    //     int res = 0;

    //     while(left < n && right < n){
    //         if(!set.contains(s.charAt(right))){
    //             set.add(s.charAt(right));
    //             right ++;
    //             res = Math.max(res,right - left);
    //         }else{
    //             set.remove(s.charAt(left));
    //             left ++;
    //         }

    //     }

    //     return res;


    // }

    //优化 ，map中存入当前字符的位置 + 1 ，碰到重复字符更新left 为 前一个字符的位置 + 1
    public int lengthOfLongestSubstring(String s){

        int res =  0;
        int n = s.length();

        Map<Character,Integer> map = new HashMap();

        //right索引每次都会增加
        for(int right = 0,left = 0; right < n; right ++){

            // 逻辑有问题
            //    if(map.containsKey(s.charAt(right))){
            //        //value 为当前字符索引 + 1
            //        map.put(s.charAt(right),right + 1);
            //        res = Math.max(res,right - left + 1);
            //    }else{
            //        left = Math.max(left,map.get(s.charAt(right)));
            //    }


            if(map.containsKey(s.charAt(right))){
                left = Math.max(left,map.get(s.charAt(right)));
            }



            //包含这个Key也需要重新更新这个字符的位置 为索引 + 1
            map.put(s.charAt(right),right + 1);
            res = Math.max(res,right - left + 1);
        }

        return res;


    }

    //最优 数组运算最快
    public int lengthOfLongestSubstring1(String s)  {

        int[] nums = new int[255];

        int n = s.length();
        int res = 0;

        for(int right = 0,left = 0; right < n;right ++){

            //注意  nums[s.charAt(right)] != 0 不代表该字符一定在此时的滑动窗口里，也有可能不在但是因为跳着更新l
            //  eft索引导致数据未删除的问题，所以要选最大值
            if(nums[s.charAt(right)] != 0){
                left = Math.max(left,nums[s.charAt(right)]);
            }

            nums[s.charAt(right)] = right + 1;
            res = Math.max(res,right - left + 1);


        }



        return res;

    }


}
