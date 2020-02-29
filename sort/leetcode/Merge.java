package leetcode;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-02-29 10:15
 **/
public class Merge {

    //时间复杂度 O(M +N),空间复杂度 O(M + N)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] temp = new int [nums1.length];
        int i = 0 ; int j = 0;int index = 0;
        while(i < m && j < n)
            temp[index ++] = nums1[i] > nums2[j] ? nums2[j++] : nums1[i ++];

        while(i < m)
            temp[index ++] = nums1[i ++];

        while(j < n)
            temp[index ++] = nums2[j ++];


        System.arraycopy(temp,0,nums1,0,temp.length);
    }

    //时间复杂度 O(M +N),空间复杂度 O(1)
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //从数组后面开始复制
        int p = m + n -1;
        int p1 = m - 1;
        int p2 = n -1;

        //把最大的数放在nums1数组后面
        while(p1 >= 0 && p2 >= 0)
            nums1[p --] = nums1[p1] > nums2[p2] ? nums1[p1 --] : nums2[p2 --];

        //若nums2数组未交换完
        if( p2 >= 0)
            System.arraycopy(nums2,0,nums1,0,p2 + 1);
    }
}
