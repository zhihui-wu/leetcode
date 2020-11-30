package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 217. 存在重复元素
 * @Author: 吴智慧
 * @Date: 2020/11/30 20:38
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

    public static void main(String[] args) {

        ContainsDuplicate containsDuplicate = new ContainsDuplicate();

        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};

        boolean result = containsDuplicate.containsDuplicate(nums);

        System.out.println(result);
    }

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n）
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }

}
