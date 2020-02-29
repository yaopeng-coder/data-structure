package leetcode;

import java.util.PriorityQueue;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-02-29 13:33
 **/
public class FinkKthLargest {

    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length - k];

        return sort(nums,0,nums.length - 1,k);



    }

    public int sort(int[] nums, int left , int right,int k){



        if(left == right)
            return nums[left];


        //利用快排思想在O(N)内完成搜索
        int p = partition(nums,left,right);
        if( k == p + 1){
            return nums[p];
        }else if(k > p + 1){
            return sort(nums,p + 1, nums.length - 1,k);
        }else{
            return sort(nums,0,p - 1,k);
        }




    }


    public int partition(int[] nums, int left , int right){


        //简单一路快排
        //[left + 1,i)>v     (j , right] <=v

        int v = nums[left];
        int j = right;
        for(int i = left + 1; i <= j;){
            if(nums[i] <= v){
                //swap nums[j --] nums[i]
                swap(nums,j--,i);
            }else{
                i ++;
            }
        }

        swap(nums,left,j);
        return j;




    }

    public int findKthLargest2(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length - k];


        //通过最小堆 算法复杂度为 O(N *log k)
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (e1 ,e2) -> (e1 - e2)
        );

        for(int num : nums){
            heap.add(num);
            if( heap.size() > k)
                heap.poll();
        }

        return heap.poll();





    }

    public void swap(int[] nums, int index1 ,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;






    }




}
