package string;

/**
 * @Description: 8. 字符串转换整数 (atoi)
 * @Author: 吴智慧
 * @Date: 2020/12/3 20:36
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class StringToIntegerAtoi {

    public static void main(String[] args) {

        StringToIntegerAtoi stringToIntegerAtoi = new StringToIntegerAtoi();

        String s = "-2147483649";

        int result = stringToIntegerAtoi.myAtoi(s);

        System.out.println(result);

    }

    public int myAtoi(String s) {

        boolean startFlag = false;
        boolean unplusFlag = false;
        int i = 0, total = 0;

        while (i < s.length()) {
            if (!startFlag) {
                if (s.charAt(i) == '-') {
                    i++;
                    startFlag = true;
                    unplusFlag = true;
                    continue;
                }
                if (s.charAt(i) == '+') {
                    i++;
                    startFlag = true;
                    continue;
                }
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    startFlag = true;
                    continue;
                }
                if (s.charAt(i) == ' ') {
                    i++;
                    continue;
                }
                return total;
            }else {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    break;
                }
                if (total == 0 && s.charAt(i) == '0') {
                    i++;
                    continue;
                }
                int temp = s.charAt(i) - '0';
                if (unplusFlag) {
                    temp *= -1;
                }
                if (total < Integer.MIN_VALUE / 10 || (total == Integer.MIN_VALUE / 10 && temp < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                total = total * 10 + temp;
                i++;
            }
        }
        return total;

    }

}
