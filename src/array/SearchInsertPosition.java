package array;

/**
 * @Description: 35. 搜索插入位置
 * @Author: 吴智慧
 * @Date: 2021/1/13 19:41
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public static void main(String[] args) {

    }

    /**
     * 顺序查找：遍历
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分查找
     * 时间复杂度：O（ log n ）
     * 空间复杂度：O（ 1 ）
     */
    public int searchInsert1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(right >= left) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }else {
                    right = mid - 1;
                }
            }else {
                left = mid + 1;
            }
        }
        return nums.length;
    }


}
