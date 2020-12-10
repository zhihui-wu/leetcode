package string;

/**
 * @Description: 28. 实现 strStr()
 * @Author: 吴智慧
 * @Date: 2020/12/4 12:05
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class ImplementStrstr {

    public static void main(String[] args) {

        ImplementStrstr implementStrstr = new ImplementStrstr();

        String haystack = "hdello", needle = "ll";

//        int result = implementStrstr.strStr(haystack, needle);

        // 请尝试：KMP字符串匹配模式
        int result = implementStrstr.strStr1(haystack, needle);

        System.out.println(result);
    }


    /**
     * 朴素匹配模式：超出时间限制
     * 时间复杂度：O（ (n - m) * m ）
     * 空间复杂度：O（ 1 ）
     */
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; i + j < haystack.length() && j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt((j))) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }


    /**
     * KMP匹配模式：超出时间限制
     * 时间复杂度：O（ n * m ）
     * 空间复杂度：O（ 1 ）
     */
    public int strStr1(String haystack, String needle) {
        if (needle.length() < 1) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (haystack.charAt(i) != needle.charAt(j) && j > 0) {
                //next[j-1]+1 防止数组超出下界
                j = next[j-1]+1;
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < needle.length(); i++) {
            while (k != -1 && needle.charAt(k+1) != needle.charAt(i)) {
                k = next[k];
            }
            if (needle.charAt(k+1) == needle.charAt(i)) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }

}
