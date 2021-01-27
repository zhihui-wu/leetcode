package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 151. 翻转字符串里的单词
 * @Author: 吴智慧
 * @Date: 2021/1/27 16:00
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {

    public static void main(String[] args) {

        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();

        String result = reverseWordsInAString.reverseWords("the sky is blue");

        // 可以尝试使用反转的形式来处理

        // 可以尝试使用双端队列来处理

        System.out.println(result);
    }

    /**
     * 截断为多个字串，再以字串为单位，倒序拼成字符串
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public String reverseWords(String s) {
        List<String> sList = new ArrayList<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            if (s.charAt(j) == ' ') {
                if (i == j) {
                    i++;
                }else {
                    sList.add(s.substring(i, j));
                    i=j;
                    i++;
                }
            }else {
                if (j == s.length() - 1) {
                    sList.add(s.substring(i, j+1));
                }
            }
            j++;
        }
        StringBuilder resultTemp = new StringBuilder("");
        for (int x = sList.size() - 1; x >= 0; x--) {
            resultTemp.append(sList.get(x)).append(" ");
        }
        String result = resultTemp.toString();
        return result.length() > 0 ? result.substring(0, result.length() - 1) : result;
    }

}
