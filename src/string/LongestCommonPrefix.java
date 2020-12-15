package string;

/**
 * @Description: 14. 最长公共前缀
 * @Author: 吴智慧
 * @Date: 2020/12/4 12:26
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String[] strs = new String[]{"flower","flow","flight"};

        String result = longestCommonPrefix.longestCommonPrefix(strs);

        /**
         * 尝试：排序后，比较首尾字符串
         */

        System.out.println(result);

    }


    /**
     * 时间复杂度：O（ n * m ）
     * 空间复杂度：O（ 1 ）
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        StringBuilder result = new StringBuilder("");
        char temp = ' ';
        int i = 0;
        while (true) {
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || (temp != ' ' && temp != strs[j].charAt(i))) {
                    return result.toString();
                }
                if (temp == ' '){
                    temp = strs[j].charAt(i);
                }
            }
            result = result.append(temp);
            temp = ' ';
            i++;
        }
    }

}
