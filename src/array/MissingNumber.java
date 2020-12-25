package array;

/**
 * @Description: 268. 丢失的数字
 * @Author: 吴智慧
 * @Date: 2020/12/25 20:33
 * https://leetcode-cn.com/problems/missing-number/
 */
public class MissingNumber {

    public static void main(String[] args) {

        MissingNumber missingNumber = new MissingNumber();

        int result = missingNumber.missingNumber(new int[]{9,6,4,2,3,5,7,0,1});

        System.out.println(result);

    }


    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public int missingNumber(int[] nums) {

        //预处理进行标记
        for (int i = 0; i < nums.length; i++) {
            //Integer.MIN_VALUE 应该是 0被特殊处理后的值，所以需要作为 0 处理
            if (nums[i] == Integer.MIN_VALUE) {
                nums[0] *= -1;
                continue;
            }
            //存在元素，则将元素作为下标指定的数字设置为负数，0置为Integer.MIN_VALUE
            int temp = Math.abs(nums[i]);
            if (temp < nums.length && nums[temp] != 0) {
                nums[temp] *= -1;
            }else if (temp < nums.length && nums[temp] == 0) {
                nums[temp] = Integer.MIN_VALUE;
            }
        }

        //遍历，元素为正数，则该下标为缺失的数字
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i;
            }
        }
        //没有正数，则缺失的数为 n
        return nums.length;

    }


    /**
     * 数学解法，(0+...+n) - 数组和 = 缺失的数字
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public int missingNumber1(int[] nums) {

        int expect = (nums.length + 1) * nums.length / 2;

        int actual = 0;
        for (int i = 0; i < nums.length; i++) {
            actual += nums[i];
        }

        return expect - actual;

    }


    /**
     * 异或解法，
     * 相同的数异或等于 0 ，任意数异或 0 等于本身，异或满足结合率
     * 所以（0^1^...^n）^(数组所有元素异或) = 0 ^ 缺失的数字 = 缺失的数字
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }



}
