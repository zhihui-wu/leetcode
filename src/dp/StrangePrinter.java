package dp;

/**
 * @Description: 664. 奇怪的打印机
 * @Author: 吴智慧
 * @Date: 2021/5/24 09:45
 * https://leetcode-cn.com/problems/strange-printer/
 */
public class StrangePrinter {

    public static void main(String[] args) {

        StrangePrinter strangePrinter = new StrangePrinter();
        strangePrinter.strangePrinter("ababc");

    }

    /**
     * 解法一：动态规划
     * 时间复杂度：O（ N ^ 3 ）
     * 空间复杂度：O（ N ^ 2 ）
     * 如果首尾一致，剥离首部字符后的字符串与原字符串的最少打印次数相同
     * 如果首尾不一致，可将字符串拆成两段分别求最小打印次数并相加，一共有n-1种拆法，求最小值
     * 临界值为：字符串长度为一时，最少打印次数为
     * 由于动态规划无有效性，长串的值依赖于短串值，需要调整遍历顺序，使得遍历从长度 1 开始
     */
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] arr = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    arr[i][j] = arr[i][j-1];
                }else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, arr[i][k] + arr[k+1][j]);
                    }
                    arr[i][j] = min;
                }
            }
        }
        return arr[0][n-1];
    }

}
