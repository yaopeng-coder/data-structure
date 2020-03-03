package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-03 10:59
 **/
public class FourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer,Integer> map1 = new HashMap();


        int count = 0;


        //用map保存两数之和
        for(int i = 0; i < A.length; i ++){
            for(int j = 0; j < B.length; j ++){

                int sum = A[i] + B[j];

                if(map1.containsKey(sum)){
                    map1.put(sum,map1.get(sum) + 1);
                }else{
                    map1.put(sum,1);
                }
            }

        }

        for(int i = 0; i < C.length; i ++){
            for(int j = 0; j < D.length; j ++){

                int search = - C[i] - D[j];
                if(map1.containsKey(search))
                    count += map1.get(search);
            }
        }


        return count;
    }
}
