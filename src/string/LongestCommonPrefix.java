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

//        String[] strs = new String[]{"flower","flow","flight"};

        String[] strs = new String[]{"dog","racecar","car"};

        String result = longestCommonPrefix.longestCommonPrefix1(strs);

        /**
         * 尝试：排序后，比较首尾字符串
         */

        System.out.println(result);

    }


    /**
     * 逐个字符，逐个字符串比对
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


    /**
     * 排序后比对第一个和最后一个
     * 时间复杂度：O（ n * m ）
     * 空间复杂度：O（ 1 ）
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int n = strs.length - 1;
        doSort(strs, 0, n);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) == strs[n].charAt(i)) {
                result.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return result.toString();
    }

    public void doSort(String[] strs, int q, int r) {
        if (q > r) {
            return;
        }
        int p = partition(strs, q, r);
        doSort(strs, q, p-1);
        doSort(strs, p+1, r);
    }

    public int partition(String[] strs, int q, int r) {
        String tempTarget = strs[r];
        int i = q, j = q;
        while (j < r) {
            if (strs[j].compareTo(tempTarget) <= 0) {
                String temp = strs[j];
                strs[j] = strs[i];
                strs[i] = temp;
                i++;
            }
            j++;
        }
        String temp = strs[i];
        strs[i] = strs[r];
        strs[r] = temp;
        return i;
    }

}
