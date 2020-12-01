package array;

/**
 * @Description: 283. 移动零
 * @Author: 吴智慧
 * @Date: 2020/12/1 20:20
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public static void main(String[] args) {

        MoveZeroes moveZeroes = new MoveZeroes();

        int[] nums = new int[]{1,2,3,4,5,6,7};

        moveZeroes.moveZeroes(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int slow = 0, quick = 1;
        while (quick < nums.length && slow < nums.length - 1) {
            if (nums[slow] != 0){
                slow++;
                continue;
            }
            if (slow >= quick) {
                quick = slow + 1;
            }
            if (nums[quick] != 0) {
                nums[slow] = nums[quick];
                nums[quick] = 0;
            }
            quick++;
        }
    }


}
