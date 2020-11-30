package array;

/**
 * @Description: 189. 旋转数组
 * @Author: 吴智慧
 * @Date: 2020/11/30 20:20
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();

        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;

        rotateArray.rotate(nums, k);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        k = k % nums.length;
        rotate(nums, 0, nums.length - k - 1);
        rotate(nums, nums.length - k, nums.length - 1);
        rotate(nums, 0, nums.length - 1);
    }

    public void rotate(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

}
