package search.binarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 167.两数之和 II - 输入有序数组
 * @Author: 吴智慧
 * @Date: 2021/1/28 17:05
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIiInputArrayIsSorted {

    public static void main(String[] args) {
        TwoSumIiInputArrayIsSorted object = new TwoSumIiInputArrayIsSorted();

        object.twoSum(new int[]{5,25,75}, 100);

//        object.twoSum(new int[]{3,24,50,79,88,150,345}, 200);

        // 请尝试，二分查找进行解题，时间复杂度为（ n log n ）

    }

    /**
     * hash表
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(target - numbers[i], i);
            }else {
                return new int[]{map.get(i)+1, i+1};
            }
        }
        return new int[2];
    }

    /**
     * 双指针法，指针分别在首尾
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public int[] twoSum1(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                break;
            }else if (numbers[l] + numbers[r] < target) {
                l++;
            }else if (numbers[l] + numbers[r] > target) {
                r--;
            }
        }
        return new int[]{l+1, r+1};
    }





}
