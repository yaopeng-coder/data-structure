import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-11 09:24
 **/
public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {

        int res = 0;

        Map<Integer,Integer> map = new HashMap();



        for(int i = 0; i < points.length; i ++){
            int[] point1 = points[i];
            map.clear();
            //遍历和当前点的距离，保存在map中


            for(int j = 0; j < points.length; j ++){
                if(j != i){
                    int[] point2 = points[j];
                    int key = dis(point1,point2);
                    res  += map.getOrDefault(key,0)*2;
                    map.put(key,map.getOrDefault(key,0) + 1);
                }

            }




        }
        return res;
    }




    public int dis(int[] point1,int[] point2){
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) +
                (point1[1] - point2[1]) * (point1[1] - point2[1]);



    }

 public static void main(String[] args){


     int[][] arr1 = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
     System.out.println(new NumberOfBoomerangs().numberOfBoomerangs(arr1));

 }
}
