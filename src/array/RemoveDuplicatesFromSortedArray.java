package array;

/**
 * @Description: 26. 删除排序数组中的重复项
 * @Author: 吴智慧
 * @Date: 2020/11/30 19:38
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        int result = removeDuplicatesFromSortedArray.removeDuplicates(nums);

        System.out.println(result);

    }


    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int slow = 0;
        int quick = 1;

        while (quick < nums.length) {
            if (nums[quick] != nums[quick - 1]) {
                slow++;
                nums[slow] = nums[quick];
            }
            quick++;
        }
        return slow + 1;
    }

}
