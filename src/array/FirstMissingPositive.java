package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 41. 缺失的第一个正数
 * @Author: 吴智慧
 * @Date: 2020/9/16 20:57
 * https://leetcode-cn.com/problems/first-missing-positive/
 * https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 0, 0};
//        int[] nums = new int[]{3, 4, -1, 1};
//        int[] nums = new int[]{1};

        // 解法一：常规做法-哈希表
//        firstMissingPositive.firstMissingPositive(nums);

        // 解法二：哈希表
//        firstMissingPositive.firstMissingPositive1(nums);

        // 解法三：置换
        firstMissingPositive.firstMissingPositive2(nums);
    }

    /**
     * 常规做法-哈希表
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     */
    public int firstMissingPositive(int[] nums) {
        Set set = new HashSet();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int result = 1;
        while(true){
            if(!set.contains(result)) {
                System.out.println(result);
                return result;
            }
            result++;
        }
    }

    /**
     * 哈希表
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     */
    public int firstMissingPositive1(int[] nums) {
        // 将负数元素值换成元素个数加一
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        // 将所有在（1 ~ N-1）范围内的元素，其元素值-1作为下标，定位元素并取负
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 第一个非负的元素记为缺失的正数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                System.out.println(i + 1);
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     * 置换
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     */
    public int firstMissingPositive2(int[] nums) {
        // 修正数组的顺序，将值为X的元素交换到下标为（x-1）的位置
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            while (nums[i] > 0 && nums[i] < size && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        // 判断第一个出现元素值不等于下标加一的位置，即可
        for (int i = 0; i < size; i++) {
            if (nums[i] - 1 != i) {
                System.out.println(i + 1);
                return i + 1;
            }
        }
        System.out.println(size + 1);
        return size + 1;
    }
}
