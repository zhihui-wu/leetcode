package array;

/**
 * @Description: 498. 对角线遍历
 * @Author: 吴智慧
 * @Date: 2021/1/22 20:55
 * https://leetcode-cn.com/problems/diagonal-traverse/
 */
public class DiagonalTraverse {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O（ n * m ）
     * 空间复杂度：O（ n * m ）
     */
    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int[] result = new int[matrix.length * matrix[0].length];
        int count = 0;

        for (int x = 0; x < matrix.length + matrix[0].length - 1; x++) {
            if (x % 2 == 0) {
                int i = x;
                int j = 0;
                if (x >= matrix.length) {
                    i = matrix.length - 1;
                    j = x - matrix.length + 1;
                }
                while(i >= 0 && j < matrix[0].length) {
                    result[count] = matrix[i][j];
                    i--;
                    j++;
                    count++;
                }
            }
            if (x % 2 != 0) {
                int i = 0;
                int j = x;
                if (x >= matrix[0].length) {
                    i = x - matrix[0].length + 1;
                    j = matrix[0].length - 1;
                }
                while(j >= 0 && i <matrix.length) {
                    result[count] = matrix[i][j];
                    i++;
                    j--;
                    count++;
                }
            }
        }
        return result;
    }



}
