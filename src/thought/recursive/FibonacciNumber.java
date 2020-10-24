package thought.recursive;

/**
 * @Description: 509. 斐波那契数
 * @Author: 吴智慧
 * @Date: 2020/10/24 15:45
 * https://leetcode-cn.com/problems/fibonacci-number/
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();

        int n = 2;

        /**
         * wzh：递归
         */
//        int result = fibonacciNumber.fib(n);

        /**
         * wzh：迭代遍历
         */
//        int result = fibonacciNumber.fib1(n);

        /**
         * 解法三：递归，去除重复计算
         */
        int result = fibonacciNumber.fib2(n);

        System.out.println(result);
    }

    /**
     * wzh：递归
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * wzh：迭代遍历
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N ）
     */
    public int fib1(int n) {
        int tempSmall = 0;
        int tempLarge = 1;
        int result = tempLarge + tempSmall;
        for (int i = 2; i < n; i++) {
            tempSmall = tempLarge;
            tempLarge = result;
            result = tempSmall + tempLarge;
        }
        return result;
    }

    /**
     * 解法三：递归，去除重复计算
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N ）
     */
    public int fib2(int n) {
        Integer[] cache = new Integer[31];
        cache[0] = 0;
        cache[1] = 1;
        return doFib2(n, cache);
    }

    private int doFib2(int n, Integer[] cache) {
        if (cache[n] != null) {
            return cache[n];
        }
        cache[n] = doFib2(n -1, cache) + doFib2(n - 2, cache);
        return cache[n];
    }

}
