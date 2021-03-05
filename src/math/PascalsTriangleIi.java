package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 119. 杨辉三角 II
 * @Author: 吴智慧
 * @Date: 2021/3/5 18:10
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangleIi {

    public static void main(String[] args) {

        PascalsTriangleIi pascalsTriangle = new PascalsTriangleIi();

        List<Integer> result = pascalsTriangle.getRow(1);

    }

    /**
     * 递推（从后往前加）
     * 时间复杂度：O（ n ^ 2 ）
     * 空间复杂度：O（ 1 ）不考虑结果的空间占用
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j-1));
            }
        }
        return result;
    }
}
