package queue;

import java.util.ArrayDeque;

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
//        int[] result = slidingWindowMaximum.maxSlidingWindow(nums, k);

        /**
         * 解法一：暴力法
         */
//        int[] result = slidingWindowMaximum.maxSlidingWindow1(nums, k);

        /**
         * 解法二：双向队列
         */
        int[] result = slidingWindowMaximum.maxSlidingWindow2(nums, k);

        /**
         * todo 解法三：动态规划
         */

        for (int a : result) {
            System.out.println(a);
        }
    }


    /**
     * 双向队列
     */
    private ArrayDeque<Integer> deq = new ArrayDeque<>();

    /**
     * 解法二：双向队列
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N ）
     * 注意：双向队列只存储数组元素下标
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        // 初始化双向队列
        int maxId = 0;
        for (int i = 0; i < k; i++) {
            clean_deq(i, k, nums);
            deq.addLast(i);
            if (nums[i] > nums[maxId]) {
                maxId = i;
            }
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[maxId];

        // 构建输出数组
        for (int i = k; i < n; i++) {
            clean_deq(i, k, nums);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    /**
     * 清除双向队列
     * @param i 当前需入队的元素下标
     * @param k 窗口大小，即队列大小
     * @param nums 数组
     */
    public void clean_deq(int i, int k, int[] nums) {
        // 将滑动窗口最左侧超出窗口范围的元素移出队列
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }
        // 以队列从尾到头的方向，移除其中小于当前需入队元素的元素
        while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
            deq.removeLast();
        }
    }


    /**
     * 解法一：暴力法
     * 时间复杂度：O（ k * N ）
     * 空间复杂度：O（ N - k + 1 ）
     * 注意，数据量大会超时
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        int[] output = new int[n-k+1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }


    /**
     * 暴力法（优化）（wzh）
     * 时间复杂度：O（ k * N ）
     * 空间复杂度：O（ N - k + 1 ）
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
