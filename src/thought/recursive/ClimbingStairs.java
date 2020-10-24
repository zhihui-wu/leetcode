package thought.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 70. 爬楼梯
 * @Author: 吴智慧
 * @Date: 2020/10/18 15:12
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();

//        int n = 3;
        int n = 45;


        /**
         * wzh:递归
         */
        int result = climbingStairs.climbStairs(n);

        /**
         * todo 解法一：动态规划
         */

        /**
         * todo 解法二：遍历迭代
         */

        System.out.println(result);
    }

    /**
     * wzh:递归
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N ）
     * 注意：通过map去除重复计算
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int onePart = 0;
        int twoPart = 0;
        if (map.containsKey(n-1)) {
            onePart = map.get(n-1);
        }else {
            onePart = climbStairs(n-1);
        }
        if (map.containsKey((n-2))) {
            twoPart = map.get(n-2);
        }else {
            twoPart = climbStairs(n-2);

        }
        map.put(n, onePart + twoPart);
        return onePart + twoPart;
    }
}
