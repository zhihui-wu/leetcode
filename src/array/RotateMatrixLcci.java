package array;

/**
 * @Description: 面试题 01.07. 旋转矩阵
 * @Author: 吴智慧
 * @Date: 2021/1/21 20:30
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/
 */
public class RotateMatrixLcci {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n < 2) {
            return;
        }
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}
