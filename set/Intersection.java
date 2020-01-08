import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * leetcode 349
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-08 10:45
 **/
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1= new TreeSet<>();

        for(int num : nums1)
            set1.add(num);

        Set<Integer> set2 = new TreeSet<>();

        for(int num : nums2){
            if(set1.contains(num))
                set2.add(num);
        }

        Iterator<Integer> iterator = set2.iterator();
        int i = 0;
        int[] res = new int[set2.size()];
        while(iterator.hasNext()){
            Integer next = iterator.next();
            res[i++] = next;
        }

        return res;

    }

    public static void main(String[] args){

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        new Intersection().intersection(nums1,nums2);


    }



}
