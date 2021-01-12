package array;

/**
 * @Description: 724. 寻找数组的中心索引
 * @Author: 吴智慧
 * @Date: 2021/1/12 19:34
 * https://leetcode-cn.com/problems/find-pivot-index/
 */
public class FindPivotIndex {

    public static void main(String[] args) {

    }

    /**
     * 先求和，遍历数组进行左累加，右递减，对比
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum+=nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (i > 0) {
                leftSum += nums[i-1];
            }
            if (rightSum == leftSum) {
                return i;
            }
        }
        return -1;
    }


}
