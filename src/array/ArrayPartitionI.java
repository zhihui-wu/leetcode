package array;

/**
 * @Description: 561. 数组拆分 I
 * @Author: 吴智慧
 * @Date: 2021/1/28 11:12
 * https://leetcode-cn.com/problems/array-partition-i/
 */
public class ArrayPartitionI {

    public static void main(String[] args) {
        ArrayPartitionI arrayPartitionI = new ArrayPartitionI();

        int result = arrayPartitionI.arrayPairSum(new int[]{6,2,6,5,1,2});

        // 尝试使用额外空间（计数排序/hash）使得复杂度达到 n


        System.out.println(result);
    }

    /**
     * 复杂度取决于排序算法
     */
    public int arrayPairSum(int[] nums) {
        //排序
        sort(nums, 0, nums.length - 1);
        //2步长相加
        int result = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            result += nums[i];
        }
        return result;
    }

    /**
     * 快排
     * 时间复杂度：O（ n * log n ）
     * 空间复杂度：O（ 1 ）+ 栈空间（log n）
     */
    public void sort(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }
        int p = partion(nums, l, r);
        sort(nums, l, p - 1);
        sort(nums, p + 1, r);
    }

    public int partion(int[] nums, int l, int r) {
        int tag = nums[r];
        int j = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= tag) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        int temp = nums[j];
        nums[j] = nums[r];
        nums[r] = temp;
        return j;
    }

}
