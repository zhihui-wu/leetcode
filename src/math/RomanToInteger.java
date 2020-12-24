package math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 13. 罗马数字转整数
 * @Author: 吴智慧
 * @Date: 2020/12/24 20:18
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    public static void main(String[] args) {

        RomanToInteger romanToInteger = new RomanToInteger();

        int result = romanToInteger.romanToInt("III");

        System.out.println(result);

    }


    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ map.size ）
     */
    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (i + 1 < s.length()) {
                char temp1 = s.charAt(i + 1);
                // 是否存在特殊情况，特殊处理
                if (map.get(temp1) > map.get(temp)) {
                    result = result + map.get(temp1) - map.get(temp);
                    i++;
                    continue;
                }
            }
            // 正常处理
            result = result + map.get(temp);
        }

        return result;

    }

}
