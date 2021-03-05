package string;

/**
 * @Description: 557. 反转字符串中的单词 III
 * @Author: 吴智慧
 * @Date: 2021/3/5 20:11
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInAStringIii {

    public static void main(String[] args) {

        ReverseWordsInAStringIii obj = new ReverseWordsInAStringIii();

        System.out.println(obj.reverseWords("Let's take LeetCode contest"));

    }


    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public String reverseWords(String s) {
        char[] result = s.toCharArray();
        for (int i = 0, j = 0; i <= s.length(); i++) {
            if (i == s.length() || result[i] == ' ') {
                rever(result, j, i-1);
                j = i + 1;
            }
        }
        return String.valueOf(result);
    }

    private void rever(char[] array, int l, int r) {
        while (l < r) {
            char temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
    }

}
