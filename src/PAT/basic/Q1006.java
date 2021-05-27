package PAT.basic;

import java.util.Scanner;

/**
 * @Description: 1006 换个格式输出整数
 * @Author: 吴智慧
 * @Date: 2021/5/27 12:20
 * https://pintia.cn/problem-sets/994805260223102976/problems/994805318855278592
 */
public class Q1006 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer a = in.nextInt();
        StringBuilder str = new StringBuilder();
        int third = a / 100;
        while (third > 0) {
            str.append("B");
            third--;
        }
        a = a % 100;
        int second = a / 10;
        while (second > 0) {
            str.append("S");
            second--;
        }
        int first = a % 10;
        for (int i = 1; i <= first; i++) {
            str.append(i + "");
        }
        System.out.println(str.toString());

    }
}
