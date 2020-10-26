package thought.recursive;

import java.util.Arrays;

/**
 * @Description: 344. 反转字符串
 * @Author: 吴智慧
 * @Date: 2020/10/24 15:48
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();

        char[] s = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};

        reverseString.reverseString(s);

        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (i >= n - 1 - i) {
                break;
            }
            char temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
    }
}
