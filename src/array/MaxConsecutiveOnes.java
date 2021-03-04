package array;

/**
 * @Description: 485. 最大连续 1 的个数
 * @Author: 吴智慧
 * @Date: 2021/3/3 19:26
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {

    }

    /**
     * 一次遍历
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int temp = 0, max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]==1) {
                temp++;
            }else {
                temp=0;
            }
            if(max < temp) {
                max = temp;
            }
        }
        return max;
    }

}
