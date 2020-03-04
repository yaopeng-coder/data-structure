/**
 *
 * 159 至多包含两个不同字符的最长子串
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-04 11:03
 **/
public class LengthOfLongestSubstringTwoDistinct {


    //数组 + 滑动窗口  会导致left索引无法跳着更新，可以用HashMap来解决
    public int lengthOfLongestSubstringTwoDistinct(String s){
        int[] nums = new int[255];


        int left = 0,right = 0,res = 0, count = 0;
        int n = s.length();

        while(left < n && right < n){
            if(nums[s.charAt(right)] > 0 ){
                nums[s.charAt(right)] = right + 1;
                right ++;

            }else if(nums[s.charAt(right)] == 0 && count < 2){
                nums[s.charAt(right)] = right + 1;
                right ++;
                count ++;
            }else{
                if( -- nums[s.charAt(left)] == 0) {
                    count--;
                }

                left ++;
            }

            res = Math.max(res,right - left);

        }

        return res;


    }


    public static void main(String[] args){



        System.out.println(new LengthOfLongestSubstringTwoDistinct().lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(new LengthOfLongestSubstringTwoDistinct().lengthOfLongestSubstringTwoDistinct("bacc"));
    }

}
