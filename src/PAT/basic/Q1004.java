package PAT.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description: 1004 成绩排名
 * @Author: 吴智慧
 * @Date: 2021/5/26 17:01
 * https://pintia.cn/problem-sets/994805260223102976/problems/994805321640296448
 */
public class Q1004 {

    /**
     * 使用哈希表
     * 注意输入，next() 与 nextLine() 的区别
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        Map<Integer, String> map = new HashMap<>();
        int max = 0;
        int min = 100;
        for (int i = 0; i < a; i++) {
            String student = in.next() + " " + in.next();
            int score = in.nextInt();
            if (score < min) {
                min = score;
            }
            if (score > max) {
                max = score;
            }
            map.put(score, student);
        }
        System.out.println(map.get(max));
        System.out.println(map.get(min));
    }

}

