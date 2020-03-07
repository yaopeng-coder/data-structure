package leetcode;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-05 10:19
 **/
public class MaxArea {

    public int maxArea(int[] height) {

        //在每一个状态下，无论长板或短板收窄 1 格，都会导致水槽 底边宽度 -1   ：
        //若向内移动短板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 可能变大，因此水槽面积 S(i, j)S(i,j) 可能增大。
        //若向内移动长板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 不变或变小，下个水槽的面积一定小于当前水槽面积。
        //因此，向内收窄短板可以获取面积最大值。解：

        //因此所有消去的状态的面积都 < S(i, j)<S(i,j)。通俗的讲，我们每次向内移动短板，所有的消去状态都不会导致丢              失面积最大值


        if(height == null || height.length < 2)
            return 0;


        int left = 0, right = height.length - 1;
        int max = 0;

        while(left < right){
            if(height[left] < height[right]){
                max = Math.max(max,(right - left) * height[left]);
                left ++;
            }else{
                max = Math.max(max,(right - left) * height[right]);
                right --;
            }
        }

        return max;
    }
}
