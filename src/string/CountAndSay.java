package string;

/**
 * @Description: 38. 外观数列
 * @Author: 吴智慧
 * @Date: 2020/12/4 12:24
 * https://leetcode-cn.com/problems/count-and-say/
 */
public class CountAndSay {

    public static void main(String[] args) {

        CountAndSay countAndSay = new CountAndSay();

        int n = 4;

        String result = countAndSay.countAndSay(n);

        /**
         * 请尝试：递归法
         */

        System.out.println(result);
    }


    /**
     * 迭代法
     * 时间复杂度：O（ n * ？ ）
     * 空间复杂度：O（ 1 ）
     */
    public String countAndSay(int n) {

        String result = "1";
        if (n == 1) {
            return  result;
        }

        for (int i = 2; i <= n; i++) {
            int count = 0;
            char temp = ' ';
            int j = 0;
            String tempResult = "";
            while (j < result.length()) {
                if (temp == result.charAt(j) || temp == ' ') {
                    temp = result.charAt(j);
                    count++;
                    j++;
                    if (j == result.length()) {
                        tempResult = tempResult + count + temp;
                    }
                }else{
                    tempResult = tempResult + count + temp;
                    temp = ' ';
                    count = 0;
                }
            }
            result = tempResult;
        }

        return result;
    }

}
