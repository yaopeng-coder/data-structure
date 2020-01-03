/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-03 09:51
 **/
public class BinarySearch {


    /**
     * 非递归实现 时间复杂度 O(log n)
     * 注意在实现的时候：
     * 1、循环终止条件： low <= high
     * 2、mid的取值，假如low和high比较大的话，取 (low + high) / 2，
     * 容易发生溢出，改进的写法 low + (high - low) / 2，
     * 进行性能优化的话，可以写成：low + ((high - low) >> 1)
     * 3、low和high的更新
     * low = mid - 1; high = mid + 1，假如low == high，并且在mid位置不等于 value，
     * 那么容易造成死循环。

     * @param value
     * @return
     */
    public int binarySearch(int[] arr , int value){
        if(arr.length <= 0 || arr == null)
            throw  new IllegalArgumentException("数组不合法");

        int low = 0;
        int high = arr.length - 1;



        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(arr[mid] == value){
                return mid;
            }else if(arr[mid] > value){
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 递归实现二分查找
     * @param arr
     * @param value
     * @param low
     * @param high
     * @return
     */
    public int binarySearch(int[] arr, int value, int low, int high){

        if (high < low)
            return -1;

        int mid = low + ((high - low) >> 1);
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return binarySearch(arr, value, low, high - 1);
        } else {
            return binarySearch(arr, value, low + 1, high);
        }
    }


    /**
     * 二分法求一个数的平方根，精度为保留6位有效数字
     * @param n
     * @param precision
     * @return
     */
    public double sqrtSearch(double n ,double precision){
        if(n < 0){
            throw  new IllegalArgumentException("n不能为负值");
        }

        double low ,high ;

        if(n >= 0 && n <=1){
            low = n ;
            high = 1;
        }else {
            low = 1;
            high = n;
        }

        double mid = low + (high - low) / 2;

        while(Math.abs(mid * mid - n) > precision){

            if(mid * mid > n){
                high = mid;
            }else {
                low = mid;
            }
            mid = low + (high - low) / 2;
        }

        return mid;
    }

    /**
     * 查找第一个值等于给定值的元素
     * @param arr
     * @param value
     * @return
     */
    public int binarySearch1(int[] arr, int value){
           int low = 0;
           int high = arr.length - 1;

           while(low <= high){
               int mid = low + ((high - low) >> 1);
               if(arr[mid] > value){
                   high = mid - 1;
               }else if(arr[mid] < value){
                   low = mid + 1;
               }else {
                   if(mid == 0 || arr[mid -1] != value)
                       return mid;
                   else
                        high = mid - 1;
               }
           }

            return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * @param arr
     */
    public int binarySearch2(int[] arr, int value){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(arr[mid] > value){
                high = mid - 1;
            }else if(arr[mid] < value){
                low = mid + 1;
            }else {
                if(mid == arr.length - 1 || arr[mid + 1] != value)
                    return mid;
                else
                     low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param arr
     * @param value
     * @return
     */
    public int binarySearch3(int[] arr, int value){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(arr[mid] >= value){
                if( mid == 0 || arr[mid - 1] < value)
                    return mid;
                else
                    high = mid - 1;
            }else {
                low = mid + 1;
            }

        }

        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param arr
     * @param value
     * @return
     */
    public int binarySearch4(int[] arr, int value){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(arr[mid] <= value){
                if( mid == arr.length - 1 || arr[mid + 1] > value)
                    return mid;
                else
                    low = mid + 1;
            }else {
                high = mid -1;
            }

        }

        return -1;
    }



    public static void main(String[] args){

        int[] arr = {1,2,3,5,6,7,7,7,8,8,9};
        System.out.println(new BinarySearch().binarySearch(arr,7));
        System.out.println(new BinarySearch().binarySearch(arr,7,0,arr.length - 1));
        System.out.println(new BinarySearch().sqrtSearch(0.25,1e-6));

        System.out.println(new BinarySearch().binarySearch1(arr,7));
        System.out.println(new BinarySearch().binarySearch2(arr,7));
        System.out.println(new BinarySearch().binarySearch3(arr,7));
        System.out.println(new BinarySearch().binarySearch4(arr,10));

    }
}
