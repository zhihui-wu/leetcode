package string;

/**
 * @Description: 7. 整数反转
 * @Author: 吴智慧
 * @Date: 2020/12/2 12:25
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public static void main(String[] args) {

        ReverseInteger reverseInteger = new ReverseInteger();

        int x = -12030;

        int result = reverseInteger.reverse(x);

        System.out.println(result);

    }


    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public int reverse(int x) {
        int total = 0;

        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            if (total != 0 || temp != 0) {
                if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)) {
                    return 0;
                }
                if (total < Integer.MIN_VALUE / 10 || (total == Integer.MIN_VALUE / 10 && temp < Integer.MIN_VALUE % 10)) {
                    return 0;
                }
                total = total * 10 + temp;
            }
        }
        return total;
    }

}
