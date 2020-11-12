package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 169. 多数元素
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
//        majorityElement.majorityElement1(nums);

        // 排序法
//        majorityElement.majorityElement2(nums);

        // 投票法
//        majorityElement.majorityElement3(nums);

        // 分治法
        majorityElement.majorityElement4(nums);
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
     * O（N log N）
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 方法三：投票法
     * O（N）
     */
    public int majorityElement3(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            if (nums[i] == candidate) {
                count++;
            }else {
                count--;
            }
        }
        System.out.println(candidate);
        return candidate;
    }

    /**
     * 方法四：分治法（递归）
     * O（N log N）
     */
    public int majorityElement4(int[] nums) {
        int result = majorityElementRec(nums, 0, nums.length-1);
        System.out.println(result);
        return result;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // 递归到只有一个元素时直接返回
        if (lo == hi) {
            return nums[lo];
        }
        // 分别返回两段的众数
        int mid = (lo + hi) / 2;
        int leftValue = majorityElementRec(nums, lo, mid);
        int rightValue = majorityElementRec(nums, mid + 1, hi);
        // 两个众数相同，该数即为整段的众数
        if (leftValue == rightValue){
            return leftValue;
        }
        // 统计整段中两个准众数的数量，确定真正的众数
        int countLeftValue = countTotal(nums, leftValue, lo, mid);
        int countRightValue = countTotal(nums, rightValue, mid + 1, hi);
        return countLeftValue > countRightValue ? leftValue : rightValue;
    }

    private int countTotal(int[] nums, int target, int lo, int hi) {
        int count = 0;
        for(int i = lo; i <= hi; i++) {
            if (nums[i] == target){
                count++;
            }
        }
        return count;
    }


}
