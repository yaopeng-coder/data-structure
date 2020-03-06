/**209. 长度最小的子数组
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-06 08:55
 **/
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;

        int left = 0, right = 0;
        int count = 0;
        int min = nums.length + 1;
        while(left < n){
            if(count < s){
                if(right < n){
                    count = count + nums[right];
                    right ++;
                }else {
                    break;
                }

            }else{
                count = count - nums[left];
                left ++;
            }

            if(count >= s)
                min = Math.min(min,right - left);


        }

        if(min == nums.length + 1){
            return 0;
        }else{
            return min;
        }


    }
}
