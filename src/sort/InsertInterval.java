package sort;

import java.util.Arrays;

/**
 * @Description: 57. 插入区间
 * @Author: 吴智慧
 * @Date: 2021/1/15 10:40
 * https://leetcode-cn.com/problems/insert-interval/
 */
public class InsertInterval {

    public static void main(String[] args) {

        InsertInterval insertInterval = new InsertInterval();
        insertInterval.insert(
                new int[][]{{2,6},{8,10},{15,18},{1,3}},
                new int[]{2,6});

    }

    /**
     * 插入排序
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int[][] tempResult = new int[intervals.length + 1][2];
        int i = 0;
        int j = 0;

        // 小于目标区间
        while ( i < intervals.length) {
            if (intervals[i][1] < newInterval[0]) {
                tempResult[j][0] = intervals[i][0];
                tempResult[j][1] = intervals[i][1];
                i++;
                j++;
            }else {
                break;
            }
        }

        // 与目标区间重合
        while (true) {
            if (i == intervals.length || intervals[i][0] > newInterval[1]) {
                tempResult[j][0] = newInterval[0];
                tempResult[j][1] = newInterval[1];
                j++;
                break;
            }
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // 大于目标区间
        while (i < intervals.length) {
            tempResult[j][0] = intervals[i][0];
            tempResult[j][1] = intervals[i][1];
            i++;
            j++;
        }

        return Arrays.copyOf(tempResult, j);
    }




}
