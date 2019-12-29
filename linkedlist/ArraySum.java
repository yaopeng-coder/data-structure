import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-29 14:42
 **/
public class ArraySum {


    public static int sum(int[] arr){

        return sum(arr,0);
    }

    private static int sum(int[] arr , int len){
        if(len == arr.length)
            return 0;

        return arr[len] + sum(arr,len + 1);
    }

    public static int sum1(int[] arr){
        if(arr.length == 0)
            return 0;
        return arr[0] + sum1(Arrays.copyOfRange(arr,1,arr.length));
    }

    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6};
        System.out.println(sum1(arr));

    }
}
