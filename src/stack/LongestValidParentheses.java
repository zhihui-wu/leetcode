package stack;

import java.util.Stack;

/**
 * @Description: 32. 最长有效括号
 * @Author: 吴智慧
 * @Date: 2020/10/18 14:58
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();

        String s = "()";

        /**
         * 解法一：栈（wzh）
         */
        int result = longestValidParentheses.longestValidParentheses(s);

        System.out.println(result);
    }


    /**
     * 栈
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N ）
     */
    public int longestValidParentheses(String s) {
        // 依次入栈，匹配的括号出栈，栈中剩余不匹配的符号
        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(-1, ' '));
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty()) {
                if (stack.peek().getMark() == '(' && s.charAt(i) == ')') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(new StackNode(i, s.charAt(i)));
        }
        // 剩余符号，计算相邻符号最大下标跨度
        int before = s.length();
        int after = stack.pop().getIndex();
        int max = before - after;
        while (!stack.empty()) {
            before = after;
            after = stack.pop().getIndex();
            if (max < before - after) {
                max = before - after;
            }
        }
        return max - 1;
    }
}

/**
 * 栈帧
 */
class StackNode {
    /**
     * 下标
     */
    private int index;
    /**
     * 符号
     */
    private char mark;

    public StackNode(int index, char mark) {
        this.index = index;
        this.mark = mark;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }
}
