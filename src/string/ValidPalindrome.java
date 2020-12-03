package string;

/**
 * @Description: 125. 验证回文串
 * @Author: 吴智慧
 * @Date: 2020/12/3 20:14
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public static void main(String[] args) {

        ValidPalindrome validPalindrome = new ValidPalindrome();

        String s = "0P";

        boolean result = validPalindrome.isPalindrome(s);

        System.out.println(result);

    }


    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (!isInner(s.charAt(l))) {
                l++;
                continue;
            }
            if (!isInner(s.charAt(r))) {
                r--;
                continue;
            }
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isInner(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
            return true;
        }
        return false;
    }


}
