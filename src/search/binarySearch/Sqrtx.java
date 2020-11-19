package search.binarySearch;

/**
 * @Description: 69. x 的平方根
 * @Author: 吴智慧
 * @Date: 2020/10/25 11:33
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class Sqrtx {

    public static void main(String[] args) {

        Sqrtx sqrtx = new Sqrtx();

        // 二分法 - 递归 - wzh
        int result = sqrtx.mySqrt(2147483647);

        // 二分法 - 迭代
//        int result = sqrtx.mySqrt1(2147395599);


        System.out.println(result);
    }

    /**
     * 二分法 - 递归 - wzh
     * 时间复杂度：O（ log(n) ）
     * 空间复杂度：O（ 1 ）
     */
    public int mySqrt(int x) {
        return doSqrt(0, x, x);
    }

    private int doSqrt(int l, int r, int x) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        long temp = (long)mid * mid;
        int index = -1;
        if (temp > x) {
            index = doSqrt(l, mid - 1, x);
        }else{
            if ((long)(mid + 1) * (mid + 1) > x) {
                return mid;
            }
            index =  doSqrt(mid + 1, r, x);
        }
        return index;
    }


    /**
     * 二分法 - 迭代
     * 时间复杂度：O（ log(n) ）
     * 空间复杂度：O（ 1 ）
     */
    public int mySqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
