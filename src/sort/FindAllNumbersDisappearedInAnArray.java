package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 448. 找到所有数组中消失的数字
 * @Author: 吴智慧
 * @Date: 2020/10/24 15:27
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray findAllNumbersDisappearedInAnArray = new FindAllNumbersDisappearedInAnArray();
        int[] nums = new int[]{4,3,2,7,8,2,3,1}; // [5,6]
        List<Integer> result = findAllNumbersDisappearedInAnArray.findDisappearedNumbers(nums);
        System.out.println(result.toString());
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 遍历预处理
        // 将出现过的元素，作为指定下标将元素取负值
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i])-1] = -1 * Math.abs(nums[Math.abs(nums[i])-1]);
        }
        // 遍历判断
        List<Integer> numsResult = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                numsResult.add(i + 1);
            }
        }
        return numsResult;
    }

}
