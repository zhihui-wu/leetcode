package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 118. 杨辉三角
 * @Author: 吴智慧
 * @Date: 2020/12/25 19:39
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
public class PascalsTriangle {

    public static void main(String[] args) {

        PascalsTriangle pascalsTriangle = new PascalsTriangle();

        List<List<Integer>> result = pascalsTriangle.generate(7);

        System.out.println(result);

    }


    /**
     * 时间复杂度：O（ n ^ 2 ）
     * 空间复杂度：O（ n ^ 2 ）
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    temp.add(1);
                }else {
                    temp.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(temp);
        }

        return result;

    }


    /**
     * 时间复杂度：O（ n ^ 2 ）
     * 空间复杂度：O（ n ^ 2 ）
     */
    public List<List<Integer>> generate1(int numRows) {

        List<List<Integer>> result = new ArrayList();
        for(int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    temp.add(1);
                }else {
                    temp.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(temp);
        }
        return result;

    }


}
