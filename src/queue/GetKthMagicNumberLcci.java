package queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Description: 面试题 17.09. 第 k 个数
 * @Author: 吴智慧
 * @Date: 2020/10/24 15:40
 * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 */
public class GetKthMagicNumberLcci {

    public static void main(String[] args) {

        GetKthMagicNumberLcci getKthMagicNumberLcci = new GetKthMagicNumberLcci();
        int r1 = getKthMagicNumberLcci.getKthMagicNumber(643);
        System.out.println(r1);
    }

    /**
     * 优先队列
     */
    public int getKthMagicNumber(int k) {
        // 优先队列，值小的先出
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(3);
        queue.offer(5);
        queue.offer(7);
        // 因子列表
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(7);
        // 用于去重
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(7);

        int i = 0;
        int target = 1;
        while (i < k) {
            // 取队列中最小数
            target = queue.poll();
            System.out.println(i + ":" + target);
            // 最小数分别乘以3、5、7后，去重并入队
            for (Integer num : list) {
                int temp = target * num;
                // 不处理超出取值范围的数
                if (temp < 1 || temp < target) {
                    break;
                }
                if (!set.contains(temp)) {
                    set.add(temp);
                    queue.offer(temp);
                }
            }
            i++;
        }
        return target;
    }
}
