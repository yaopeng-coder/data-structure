import java.util.*;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-09 11:58
 **/
public class TopKFrequent {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap<>();

        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }

//        PriorityQueue<Integer> queue = new PriorityQueue<>(
//                new Comparator<Integer>(){
//                    @Override
//                    public int compare(Integer a, Integer b){
//                        return map.get(a) - map.get(b);
//                    }
//                }
//        );

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a,b) ->(map.get(a) - map.get(b))
        );
        int n = 0;
        for(Integer key : map.keySet()){
            if( n < k){
                queue.add(key);
            }else if(map.get(key) > map.get(queue.peek())){
                queue.remove();
                queue.add(key);
            }
            n ++;

        }


        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            list.add(queue.remove());
        }
        return list;
    }

    public static void main(String[] args){
            int[] nums = {1,2,3,1,2,1,4,5,4,5,5};
        List<Integer> list = topKFrequent(nums, 3);
        System.out.println(list);
    }
}
