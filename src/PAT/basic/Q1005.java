package PAT.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description: 1005 继续(3n+1)猜想
 * @Author: 吴智慧
 * @Date: 2021/5/27 10:12
 * https://pintia.cn/problem-sets/994805260223102976/problems/994805320306507776
 */
public class Q1005 {

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] nums = new int[a];
        for (int i = 0; i < a; i++) {
            nums[i] = in.nextInt();
        }
        // 区分 关键字 和 覆盖值
        Set<Integer> cover = new HashSet<>();
        Set<Integer> key = new HashSet<>();
        for (int i = 0; i < a; i++) {
            int temp = nums[i];
            if (!cover.contains(temp)) {
                key.add(temp);
            }
            while (!cover.contains(temp) && temp != 1) {
                cover.add(temp);
                if (temp % 2 == 0) {
                    temp = temp / 2;
                }else {
                    temp = (temp * 3 + 1) / 2;
                }
                key.remove(temp);
            }
        }
        // 排序
        List<Integer> list = new ArrayList<>(key);
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j) <= temp) {
                    list.set(j+1, temp);
                    break;
                }else {
                    list.set(j+1, list.get(j));
                    if (j == 0) {
                        list.set(j, temp);
                    }
                }
            }
        }
        // 输出
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i));
            if (i > 0) {
                System.out.print(" ");
            }else {
                System.out.println();
            }
        }
    }

}
