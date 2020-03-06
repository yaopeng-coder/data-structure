import java.util.PriorityQueue;

/**
 * 451 题
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-06 10:28
 **/
public class FrequencySort {

    public String frequencySort(String s){
        //用map 来统计频率，用优先队列构造一个最小堆来排序

        //也可以用数组来代替map,速度快
        //记住：对于单个字符，用Map存储都可以用数组来代替，速度更快


        //包括不可打印字符的Ascii
        int[] array = new int[256];

        for(char c : s.toCharArray()){
            array[c] ++;
        }


        //  Map<Character,Integer> map = new HashMap();

        //  for(int i = 0; i <s.length(); i ++){

        //      char c = s.charAt(i);
        //      if(map.containsKey(c)){
        //          map.put(c,map.get(c) + 1);
        //      }else{
        //          map.put(c,1);
        //      }
        //  }

        PriorityQueue<Character> queue = new PriorityQueue(
                // (a,b) -> (map.get(b) - map.get(a))
                (a,b) -> ((array[(char)b] - array[(char)a]))
        );

        //  for(char key : map.keySet()){
        //      queue.add(key);
        //  }

        for(int i = 0; i < array.length; i ++){
            if(array[i] != 0)
                queue.add((char)i);
        }

        StringBuilder result = new StringBuilder();

        while(!queue.isEmpty()){
            char c = (char)queue.poll();
            //  for(int i = 0; i < map.get(c); i ++){
            //      result.append(c);
            //  }

            for(int i = 0; i < array[c]; i ++){
                result.append(c);
            }
        }

        return result.toString();
    }
}
