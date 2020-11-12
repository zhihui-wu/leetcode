package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 15. 三数之和
 * @Author: 吴智慧
 * @Date: 2020/9/14 20:57
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 0, 0};
        int[] nums = new int[]{-2, 0, 0, 2, 2};
        // 三数之和
        threeSum.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++){
            while (i > 0 && i < nums.length - 2 && nums[i] == nums[(i-1)]) {
                i++;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if (left > i + 1 && nums[left] == nums[(left-1)]) {
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[(right+1)]) {
                    right--;
                    continue;
                }
                int value = nums[i] + nums[left] + nums[right];
                if (value == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    result.add(item);
                    System.out.println(result.toString());
                    left++;
                    right--;
                }else if(value > 0) {
                    right--;
                }else if(value < 0) {
                    left++;
                }
            }
        }
        return result;
    }
}
