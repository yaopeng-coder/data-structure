package leetcode;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-07 10:09
 **/
public class Trap {


    public int trap(int[] height) {

        //按列求，判断当前位置能装多少水，其实就是判断当前列max_left  和max-right，取最小值和当前列比较
        int count = 0;
        int left = 1;
        int right = height.length - 2;

        int max_left = 0;  //最左边和最右边不用考虑
        int max_right = 0;

        int min = 0; //用来保存两者中的最小值


        //双指针法 ，对于每一列，如果 max_left < max_right,那么我们就从左边开始遍历
        //这样能保证遍历的这段区间左右最小值就是left，用一个常量保存即可

        while(left <= right){

            if(height[left - 1] < height[right + 1]){
                max_left = Math.max(max_left,height[left - 1]);
                min = max_left;
                if(min > height[left]){
                    count = count + (min - height[left]);
                }

                left ++;
            }else{
                max_right = Math.max(max_right,height[right + 1]);
                min = max_right;
                if(min > height[right]){
                    count = count  + (min - height[right]);
                }

                right --;

            }

        }



        return count;

    }
}
