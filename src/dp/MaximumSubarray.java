package dp;

/**
 * @Description: 53. 最大子序和
 * @Author: 吴智慧
 * @Date: 2020/12/21 21:23
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public static void main(String[] args) {

        MaximumSubarray maximumSubarray = new MaximumSubarray();

        int result = maximumSubarray.maxSubArray(new int[]{});

        System.out.println(result);

    }

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public int maxSubArray(int[] nums) {

        int pre = nums[0], max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }

        return max;
    }


}
