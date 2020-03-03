package leetcode;

/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-03-03 10:58
 **/
public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {

        //这里若i为int类型，则会超时？
        // for(long i = 0; i*i <= c; i++){

        //     double search = Math.sqrt(c - i*i);


        //     if(search == (int) search)
        //         return true;
        // }

        // return false;


        //利用双指针
        long left = 0;
        long right = (long)Math.sqrt(c);

        while(left <= right){
            if(left * left + right * right == c){
                return true;
            }else if(left * left + right * right < c){
                left ++;
            }else{
                right --;
            }
        }

        return false;



    }

    // public boolean judgeSquareSum(int c) {
    //     for (int a = 0; a * a <= c; a++) {
    //         double b = Math.sqrt(c - a * a);
    //         if (b == (int) b)
    //             return true;
    //     }
    //     return false;
    // }


}
