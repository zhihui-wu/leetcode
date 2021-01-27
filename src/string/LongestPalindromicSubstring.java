package string;

/**
 * @Description: 5. 最长回文子串
 * @Author: 吴智慧
 * @Date: 2021/1/27 10:00
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        String result = longestPalindromicSubstring.longestPalindrome("babad");

        System.out.println(result);
    }

    /**
     * 中心扩展
     * 时间复杂度：O（ n ^ 2 ）
     * 空间复杂度：O（ 1 ）
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = explendStr(s, i, i);
            int len2 = explendStr(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + (len / 2);
            }
        }
        return s.substring(start, end+1);
    }

    /**
     * 字符串向两次扩展
     */
    private int explendStr(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    /**
     * 动态规划
     * 时间复杂度：O（ n ^ 2 ）
     * 空间复杂度：O（ n ^ 2 ）
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        boolean[][] tag = new boolean[n][n];

        String result = "";
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                int j = i + l;
                if (l == 0) {
                    tag[i][j] = true;
                }else if (l == 1){
                    tag[i][j] = (s.charAt(i) == s.charAt(j));
                }else {
                    tag[i][j] = (s.charAt(i) == s.charAt(j) && tag[i+1][j-1]);
                }
                if (tag[i][j] && l >= result.length()) {
                    result = s.substring(i, j+1);
                }
            }
        }
        return result;
    }

}
