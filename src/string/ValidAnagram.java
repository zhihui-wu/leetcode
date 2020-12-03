package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 242. 有效的字母异位词
 * @Author: 吴智慧
 * @Date: 2020/12/3 19:50
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class ValidAnagram {

    public static void main(String[] args) {

        ValidAnagram validAnagram = new ValidAnagram();

        String s = "anagram", t = "nagaram";

        boolean result = validAnagram.isAnagram(s, t);

        System.out.println(result);

    }


    /**
     * 时间复杂度：O（ n + m ）
     * 空间复杂度：O（ < 26 ）
     */
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            }
            map.replace(t.charAt(i), map.get(t.charAt(i)) - 1);
        }

        for (Map.Entry entry : map.entrySet()) {
            if ((Integer) entry.getValue() != 0) {
                return false;
            }
        }

        return true;

    }


}
