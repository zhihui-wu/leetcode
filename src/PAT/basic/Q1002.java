package PAT.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description: 1002 写出这个数
 * @Author: 吴智慧
 * @Date: 2021/5/25 09:44
 * https://pintia.cn/problem-sets/994805260223102976/problems/994805324509200384
 */
public class Q1002 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String a = in.nextLine();
            doTransfer(a);
        }
    }


    public static void doTransfer(String a) {
        Map<Character, String> map = new HashMap<>();
        map.put('0', "ling");
        map.put('1', "yi");
        map.put('2', "er");
        map.put('3', "san");
        map.put('4', "si");
        map.put('5', "wu");
        map.put('6', "liu");
        map.put('7', "qi");
        map.put('8', "ba");
        map.put('9', "jiu");

        int sum = 0;
        for (int i = 0; i < a.length(); i++) {
            sum += (a.charAt(i) - '0');
        }
        String s = sum + "";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(map.get(s.charAt(i)));
            if (i < s.length() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }
}
