package string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 387. 字符串中的第一个唯一字符
 * @Author: 吴智慧
 * @Date: 2020/12/3 12:05
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {

        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();

        String s = "loveleetcode";

        int result = firstUniqueCharacterInAString.firstUniqChar(s);

        System.out.println(result);

    }

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public int firstUniqChar(String s) {

        // 先进先出的map结构
        Map<Character, Element> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i)).setCount(map.get(s.charAt(i)).getCount() + 1);
            }else {
                map.put(s.charAt(i), new Element(i, 1));
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            if (((Element)entry.getValue()).getCount() <= 1) {
                return ((Element)entry.getValue()).getIndex();
            }
        }

        return -1;

    }

}

class Element{
    private int index;
    private int count;

    public Element(int index, int count) {
        this.index = index;
        this.count = count;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
