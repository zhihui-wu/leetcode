package array;

/**
 * @Description: 27. 移除元素
 * @Author: 吴智慧
 * @Date: 2021/1/28 20:18
 * https://leetcode-cn.com/problems/remove-evlement/
 */
public class RemoveElement {

    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


}
