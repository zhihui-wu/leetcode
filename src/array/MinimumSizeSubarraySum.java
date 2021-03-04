package array;

/**
 * @Description: 209. 长度最小的子数组
 * @Author: 吴智慧
 * @Date: 2021/3/3 19:41
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {

        MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();

        int result = obj.minSubArrayLen1(7, new int[]{2,3,1,2,4,3});

        System.out.println(result);

    }

    /**
     * 双指针 / 滑动窗口（1）
     * 时间复杂度：O（ 2n ）
     * 空间复杂度：O（ 1 ）
     */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int n = nums.length;
        while(j < n || (j == n && sum >= target)) {
            if (sum < target) {
                sum += nums[j];
                j++;
            }else {
                min = Math.min(min, j - i);
                sum -= nums[i];
                i++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 双指针 / 滑动窗口（2）
     * 时间复杂度：O（ 2n ）
     * 空间复杂度：O（ 1 ）
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int n = nums.length;
        while(j < n) {
            sum += nums[j];
            while (sum >= target) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
