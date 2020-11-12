package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1. 两数之和
 * @Author: 吴智慧
 * @Date: 2020/9/14 21:14
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

//        twoSum.twoSum(nums, target);
//        twoSum.twoSum1(nums, target);
        twoSum.twoSum2(nums, target);
    }

    /**
     * 解法一：暴力法
     * 时间复杂度：O (N ^ 2)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(Arrays.toString(new int[]{i, j}));
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 解法二：两遍哈希表
     * 时间复杂度：O (N)
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                System.out.println(Arrays.toString(new int[]{i, map.get(temp)}));
                return new int[]{i, map.get(temp)};
            }
        }
        return null;
    }

    /**
     * 解法三：一遍哈希表
     * 时间复杂度：O (N)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                System.out.println(Arrays.toString(new int[]{map.get(temp), i}));
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
