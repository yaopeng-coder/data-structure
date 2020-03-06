/**
 *
 * 202. 快乐数
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-05 10:40
 **/
public class IsHappy {
    //用set占用空间太大
    // public boolean isHappy(int n) {

    //     Set<Integer> set = new TreeSet();

    //     while(n != 1){
    //         if(set.contains(n)){
    //             return false;
    //         }

    //         set.add(n);
    //         int keyNum = (n + "").length();
    //         int m = 1; //m用来辅助计算n每个位的数字

    //         int result = 0;
    //         for(int i = 0; i < keyNum; i ++){
    //             int s ;
    //             int k = (n / m) % 10;
    //             result = k * k + result;
    //             m = m * 10;
    //         }

    //         n = result;
    //     }

    //      return true;
    // }

    //用快慢指针的思想，快指针每次跑两步，慢指针每次跑一步，当两者相等时说明出现了循环或者找到了1，即可判定
    public boolean isHappy(int n) {

        int fast = n, slow = n;

        do{
            fast = search(fast);
            fast = search(fast);
            slow = search(slow);
        }while(fast != slow);

        //判断
        return slow == 1;


    }


    public int search(int n){

        int result = 0 ;
        while( n > 0){
            int digital  = n % 10;
            result = result + digital * digital;
            n = n / 10;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new IsHappy().isHappy(8));
    }
}
