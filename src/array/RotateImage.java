package array;

/**
 * @Description: 48. 旋转图像
 * @Author: 吴智慧
 * @Date: 2020/12/2 12:22
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class RotateImage {

    public static void main(String[] args) {

        RotateImage rotateImage = new RotateImage();

        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

        rotateImage.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

    }

    /**
     * 时间复杂度：O（ n ^ 2 ）
     * 空间复杂度：O（ 1 ）
     */
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int x = n / 2;
        int y = n / 2;
        if (n % 2 != 0) {
            y++;
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

}
