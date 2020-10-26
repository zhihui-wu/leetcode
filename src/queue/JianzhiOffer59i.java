package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description: 剑指 Offer 59 - I. 滑动窗口的最大值
 * @Author: 吴智慧
 * @Date: 2020/10/24 15:34
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class JianzhiOffer59i {

    Deque<Integer> deq = new ArrayDeque<>();

    int[] nums;

    public static void main(String[] args) {
        JianzhiOffer59i jianzhiOffer59i = new JianzhiOffer59i();

//        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
//        int k = 3;

        int[] nums = new int[]{7,2,4};
        int k = 2;

        int[] result = jianzhiOffer59i.maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
    }

    private void clean_deq(int i, int k) {
        // 队列不空，则清除下标超出窗口范围的元素
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }
        // 队列不空，则入队当前下标，并清除比当前下标对应元素小的元素
        while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length * k == 0) {
            return new int[0];
        }
        this.nums = nums;
        // 初始化双向队列
        for (int i = 0; i < k; i++) {
            clean_deq(i, k);
            deq.addLast(i);
        }

        // 构造输出数组
        int[] output = new int[nums.length - k + 1];
        output[0] = nums[deq.getFirst()];

        for (int i = k; i < nums.length; i++) {
            clean_deq(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

}
