package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 多数元素
 * @Author: 吴智慧
 * @Date: 2020/9/15 22:07
 * https://leetcode-cn.com/problems/majority-element/
 *
 */
public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 0, 0};
        int[] nums = new int[]{3, 2, 3};

        // 哈希法
        majorityElement.majorityElement1(nums);
    }

    /**
     * 方法一：哈希法
     * O（N）
     */
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }else {
                map.replace(nums[i], map.get(nums[i]) + 1);
            }
            if (map.get(nums[i]) > nums.length / 2) {
                System.out.println(nums[i]);
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 方法二：排序法
     * O（N）
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
