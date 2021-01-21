package sort;

import java.util.Arrays;

/**
 * @Description: 56. 合并区间
 * @Author: 吴智慧
 * @Date: 2021/1/14 19:43
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public static void main(String[] args) {

        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(new int[][]{{2,6},{8,10},{15,18},{1,3}});

    }


    /**
     * 复杂度取决于排序
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return intervals;
        }

        sort1(intervals);

        int[][] tempResult = new int[intervals.length][2];
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (j == 0 || intervals[i][0] > tempResult[j-1][1]) {
                tempResult[j][0] = intervals[i][0];
                tempResult[j][1] = intervals[i][1];
                j++;
            }else {
                tempResult[j-1][1] = Math.max(tempResult[j-1][1], intervals[i][1]);
            }
        }

        return Arrays.copyOf(tempResult, j);
    }

    /**
     * 插入排序
     * 时间复杂度：O（ n ^ 2 ）
     * 空间复杂度：O（ 1 ）
     */
    public void sort(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            int[] temp = intervals[i];
            int j = i;
            while ( j > 0) {
                if (temp[0] < intervals[j-1][0]) {
                    intervals[j] = intervals[j-1];
                    j--;
                }else {
                    break;
                }
            }
            intervals[j] = temp;
        }
    }

    /**
     * 请尝试快排
     * 时间复杂度：O（ n ^ 2 ）
     * 空间复杂度：O（ 1 ）
     */

    /**
     * 快排
     */
    public void sort1(int[][] intervals) {
        doSort(intervals, 0, intervals.length-1);
    }

    public void doSort(int[][] intervals, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(intervals, p, r);
        doSort(intervals, p, q-1);
        doSort(intervals, q+1, r);
    }

    public int partition(int[][] intervals, int p, int r) {
        int[] tag = intervals[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (intervals[j][0] < tag[0]) {
                int[] temp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = temp;
                i++;
            }
        }
        int[] temp = intervals[i];
        intervals[i] = intervals[r];
        intervals[r] = temp;
        return i;
    }


}
