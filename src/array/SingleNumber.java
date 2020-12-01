package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 136. 只出现一次的数字
 * @Author: 吴智慧
 * @Date: 2020/11/30 20:54
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();

        int[] nums = new int[]{4,1,2,1,2};

        int result = singleNumber.singleNumber(nums);

        /**
         * 请尝试，异或运算法
         */

        System.out.println(result);
    }

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public int singleNumber(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.replace(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }

        for(Map.Entry entry : map.entrySet()) {
            if ((Integer)entry.getValue() == 1) {
                return (Integer) entry.getKey();
            }
        }
        return -1;
    }

}
