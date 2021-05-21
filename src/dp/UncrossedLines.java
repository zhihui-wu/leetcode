package dp;

/**
 * @Description: 1035. 不相交的线
 * @Author: 吴智慧
 * @Date: 2021/5/21 17:53
 * https://leetcode-cn.com/problems/uncrossed-lines/
 */
public class UncrossedLines {

    public static void main(String[] args) {

    }

    /**
     * 动态规划
     * 时间复杂度：O（ N * M ）
     * 空间复杂度：O（ N * M ）
     * 等同于 “查找最大子序列问题”
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] arr = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            int num1 = nums1[i-1];
            for (int j = 1; j <= n; j++) {
                int num2 = nums2[j-1];
                if (num1 == num2) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                }else {
                    arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
                }
            }
        }
        return arr[m][n];
    }

}
