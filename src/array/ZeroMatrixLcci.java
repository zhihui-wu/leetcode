package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 面试题 01.08. 零矩阵
 * @Author: 吴智慧
 * @Date: 2021/1/22 20:23
 * https://leetcode-cn.com/problems/zero-matrix-lcci/
 */
public class ZeroMatrixLcci {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O（ n ^ 2 ）
     * 空间复杂度：O（ n ）
     */
    public void setZeroes(int[][] matrix) {

        if (matrix.length < 1 || matrix[0].length < 1) {
            return;
        }

        Set<Integer> iSet = new HashSet<>();
        Set<Integer> jSet = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    iSet.add(i);
                    jSet.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (iSet.contains(i) || jSet.contains(j)) {
                    matrix[i][j]= 0;
                }
            }
        }

    }



}
