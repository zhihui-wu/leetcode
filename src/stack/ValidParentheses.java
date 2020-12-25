package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @Description: 20. 有效的括号
 * @Author: 吴智慧
 * @Date: 2020/10/18 14:56
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();

        String s = "{{()[]()}}";

        Boolean result = validParentheses.isValid(s);

        System.out.println(result);
    }


    /**
     * 和下面的方式一样，就是出入栈判断多了一点
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N + ? ），?表示哈希表字符集空间
     */
    public boolean isValid1(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Deque<Character> stack = new LinkedList<Character>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (stack.size() <= 0) {
                if (!map.containsKey(temp)) {
                    return false;
                }
                stack.addFirst(temp);
                continue;
            }
            if (map.get(stack.peekFirst()) != temp) {
                if (!map.containsKey(temp)) {
                    return false;
                }
                stack.addFirst(temp);
            }else {
                stack.removeFirst();
            }
        }
        return stack.size() <= 0;
    }


    /**
     * 左括号放入栈中，被右括号匹配后取出
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N + ? ），?表示哈希表字符集空间
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> pair =  new HashMap<>();
        pair.put('(', ')');
        pair.put('[', ']');
        pair.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            if (pair.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }else {
                if (stack.empty()) {
                    return false;
                }
                if (pair.get(stack.peek()).equals(s.charAt(i))) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
