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

    /**
     * 双指针
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
