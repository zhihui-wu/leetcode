package array;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: 三数之和
 * @Author: 吴智慧
 * @Date: 2020/9/14 20:57
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        // 三数之和
        threeSum.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = 1; j < nums.length - 1; j++){

            }
        }
        return null;
    }
}
