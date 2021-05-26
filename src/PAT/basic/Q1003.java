package PAT.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description: 1003 我要通过！
 * @Author: 吴智慧
 * @Date: 2021/5/25 10:55
 * https://pintia.cn/problem-sets/994805260223102976/problems/994805323154440192
 */
public class Q1003 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
//         System.out.println(a);
        for (int i = 0; i < a + 1; i++) {
            String s = in.nextLine();
            if (s.length() > 0){
                System.out.print(doConfirm(s) ? "YES" : "NO");
                if (i < a) {
                    System.out.println("");
                }
            }
        }
    }

    /**
     * 要看懂题目的意思，有隐含的规则
     */
    private static boolean doConfirm(String s) {
//         System.out.println(s);
        int pIndex = Integer.MIN_VALUE;
        int pCount = 0;
        int tIndex = Integer.MAX_VALUE;
        int tCount = 0;
        Set<Character> set = new HashSet<>();
        set.add('P');
        set.add('A');
        set.add('T');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P') {
                pIndex = i;
                pCount++;
            }
            if (s.charAt(i) == 'T') {
                tIndex = i;
                tCount++;
            }
            if (!set.contains(s.charAt(i)) || pIndex >= tIndex) {
                return false;
            }
        }
        if (pCount == 1 && tCount == 1) {
//             System.out.println("a:"+ s.substring(0, pIndex) + ", b:" + s.substring(pIndex+1, tIndex) + ", c:" +s.substring(tIndex+1, s.length()));
            String  a = s.substring(0, pIndex);
            String  b = s.substring(pIndex+1, tIndex);
            String  c = s.substring(tIndex+1, s.length());
            if (b.length() < 1) {
                return false;
            }
            return c.length() == a.length() * b.length();
        }
        return false;
    }

}
