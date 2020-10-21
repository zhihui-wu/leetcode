package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 150. 逆波兰表达式求值
 * @Author: 吴智慧
 * @Date: 2020/10/18 14:59
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();

        String[] s = new String[]{"2", "1", "+", "3", "*"};
//        String[] s = new String[]{"4", "13", "5", "/", "+"};
//        String[] s = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        /**
         * 解法一：栈（wzh）
         */
        int result = evaluateReversePolishNotation.evalRPN(s);

        System.out.println(result);
    }

    /**
     * 栈
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N ）
     */
    public int evalRPN(String[] tokens) {
        List<String> op = new ArrayList<>();
        op.add("+");
        op.add("-");
        op.add("*");
        op.add("/");

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (op.contains(tokens[i])) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                System.out.println(tokens[i]);
                if ("+".equals(tokens[i])) {
                    result = num2 + num1;
                }
                else if ("-".equals(tokens[i])){
                    result = num2 - num1;
                }else if ("*".equals(tokens[i])){
                    result = num2 * num1;
                }else if ("/".equals(tokens[i])){
                    result = num2 / num1;
                }
                System.out.println(num2);
                System.out.println(num1);
                System.out.println(result);
                stack.push(result);
                continue;
            }
            stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.pop().intValue();
    }
}
