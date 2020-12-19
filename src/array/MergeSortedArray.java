package array;

/**
 * @Description: 88. 合并两个有序数组
 * @Author: 吴智慧
 * @Date: 2020/12/19 22:04
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public static void main(String[] args) {

        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        mergeSortedArray.merge(new int[]{1}, 1, new int[]{1}, 1);

    }

    /**
     * 时间复杂度：O（ m + n ）
     * 空间复杂度：O（ m）
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }
        int i = 0, j = 0, x = 0;
        while (i < m && j < n) {
            if (temp[i] <= nums2[j]) {
                nums1[x] = temp[i];
                i++;
            }else {
                nums1[x] = nums2[j];
                j++;
            }
            x++;
        }
        if (i == m) {
            while(j < n) {
                nums1[x] = nums2[j];
                j++;
                x++;
            }
        }
        if (j == n) {
            while (i < m) {
                nums1[x] = temp[i];
                i++;
                x++;
            }
        }
    }
}
