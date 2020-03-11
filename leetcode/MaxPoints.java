import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-11 10:22
 **/
public class MaxPoints {
    public int maxPoints(int[][] points) {

        if(points == null || points.length == 0)
            return 0;

        Map<Double,Integer> map = new HashMap();

        int count = 0;

        for(int i = 0; i < points.length; i ++){
            map.clear();
            int[] point1 = points[i];
            int same = 0;
            for(int j = 0; j < points.length; j ++){
                int[] point2 = points[j];

                if( i != j){
                    if(point1[0] == point2[0] && point1[1] == point2[1]){
                        same ++;
                    }else{
                        double key = calcute(point1,point2);
                        map.put(key,map.getOrDefault(key,0) + 1);
                    }
                }

            }

            count = Math.max(count,same);

            if(!map.isEmpty()){
                count = Math.max(count, Collections.max(map.values()) + same);
            }

        }

        return count + 1;

    }

    public double calcute(int[] point1, int[] point2){
        if(point1[1] == point2[1]){
            return Double.POSITIVE_INFINITY;
        }
        return (double)(point1[0] - point2[0]) / (point1[1]- point2[1]);
    }


    public static void main(String[] args){
        int[][] arr1 = {{0,0},{94911150,94911151},{94911151,94911152}};

        new MaxPoints().maxPoints(arr1);
    }
}
