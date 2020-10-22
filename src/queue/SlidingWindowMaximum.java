package queue;

/**
 * @Description: 239. 滑动窗口最大值
 * @Author: 吴智慧
 * @Date: 2020/10/18 15:09
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;

        /**
         * 解法一：暴力法（优化）（wzh）
         *
         */
        int[] result = slidingWindowMaximum.maxSlidingWindow(nums, k);

        for (int a : result) {
            System.out.println(a);
        }
    }

    /**
     * 暴力法
     * 时间复杂度：O（ k * N ）
     * 空间复杂度：O（ k * N ）
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < 1 || k < 1) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = maxNum(nums,0, k);
        for (int i = 1; i < nums.length - k + 1; i++) {
            // 优化：不需每个窗口都计算最大值
            if (nums[i + k - 1] > result[i - 1]) {
                result[i] = nums[i + k -1];
            }else if (nums[i - 1] < result[i - 1]) {
                result[i] = result[i - 1];
            }else {
                result[i] = maxNum(nums, i, k);
            }
        }
        return result;
    }

    /**
     * 取窗口中最大值
     */
    public int maxNum(int[] nums, int first, int k) {
        int max = nums[first];
        for (int i = first + 1; i < first + k; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
