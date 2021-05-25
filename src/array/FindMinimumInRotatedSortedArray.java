package array;

/**
 * @Description: 153. 寻找旋转排序数组中的最小值
 * @Author: 吴智慧
 * @Date: 2021/3/5 20:36
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {

    }

    /**
     * 遍历
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     */
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    /**
     * 二分查找
     * 时间复杂度：O（ log N ）
     * 空间复杂度：O（ 1 ）
     */
    public int findMin1(int[] nums) {
        int x = 0;
        int y = nums.length - 1;
        while (x < y) {
            int mid = x + (y - x) / 2;
            if (nums[mid] < nums[y]) {
                y = mid;
            }else {
                x = mid + 1;
            }
        }
        return nums[x];
    }

}
