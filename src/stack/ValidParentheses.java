package stack;

import java.util.HashMap;
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
