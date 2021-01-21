package sort;

/**
 * @Description: 1288. 删除被覆盖区间
 * @Author: 吴智慧
 * @Date: 2021/1/15 11:10
 * https://leetcode-cn.com/problems/remove-covered-intervals/
 */
public class RemoveCoveredIntervals {

    public static void main(String[] args) {

    }


    /**
     * 复杂度取决于排序
     */
    public int removeCoveredIntervals(int[][] intervals) {

        if (intervals.length < 2) {
            return intervals.length;
        }

        // 排序
        sort(intervals);

        int j = 0;
        int[] temp = null;
        for (int i = 0; i < intervals.length; i++) {
            if (temp == null) {
                temp = intervals[i];
            }
            if (temp[1] < intervals[i][1]) {
                temp = intervals[i];
                j++;
            }
        }
        return j + 1;
    }

    public void sort(int[][] intervals) {
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
