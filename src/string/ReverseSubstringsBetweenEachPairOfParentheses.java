package string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description: 1190. 反转每对括号间的子串
 * @Author: 吴智慧
 * @Date: 2021/5/26 10:39
 * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {

    public static void main(String[] args) {
        ReverseSubstringsBetweenEachPairOfParentheses object = new ReverseSubstringsBetweenEachPairOfParentheses();
        object.reverseParentheses2("(abcd)");
//        object.reverseParentheses("(u(love)i)");
//        object.reverseParentheses("a(bcdefghijkl(mno)p)q");
//        object.reverseParentheses("ta()usw((((a))))");

    }

    /**
     * 栈(寻找匹配的括号) + 递归(深度优先查找并反转字符串)
     * 时间复杂度：O（ N * N ）
     * 空间复杂度：O（ N ）
     */
    public String reverseParentheses(String s) {
        int leftP = 0;
        int rightP = s.length();
        Stack<Parenthese> stack = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            if (s.charAt(i) == '('){
                stack.push(new Parenthese('(', i));
            }else if (s.charAt(i) == ')') {
                Parenthese parenthese = stack.pop();
                if (stack.empty()) {
                    leftP = parenthese.index;
                    rightP = i;
                    String midStr = reverseParentheses(s.substring(leftP + 1, rightP));
                    s = s.substring(0, leftP) + rever(midStr) + s.substring(rightP + 1, s.length());
                    i = leftP;
                    continue;
                }
            }
            i++;
        }
        return s;
    }

    private String rever(String preStr) {
        char[] preChar = preStr.toCharArray();
        for (int i = 0, j = preStr.length()-1; i < j; i++, j--) {
            char temp = preChar[i];
            preChar[i] = preChar[j];
            preChar[j] = temp;
        }
        return String.valueOf(preChar);
    }




    /**
     * 栈
     * 时间复杂度：O（ N * N ）
     * 空间复杂度：O（ N ）
     * 右括号时才进行字符串处理，可以保证我们是按照从括号内到外的顺序处理字符串。
     */
    public String reverseParentheses1(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(str.toString());
                str.setLength(0);
            }else if (s.charAt(i) == ')') {
                str.reverse();
                str.insert(0, stack.pop());
            }else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }


    /**
     * 预处理括号 + 多次反转方向遍历
     * 时间复杂度：O（ N * N ）
     * 空间复杂度：O（ N ）
     */
    public String reverseParentheses2(String s){
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder str = new StringBuilder();
        int i = 0;
        boolean toRight = true;
        while(i < s.length()) {
            if (s.charAt(i) == '('){
                i = pair[i];
                toRight = !toRight;
            }else if (s.charAt(i) == ')'){
                i = pair[i];
                toRight = !toRight;
            }else {
                str.append(s.charAt(i));
            }
            i = toRight ? i+1 : i-1;
        }
        return str.toString();
    }

}

class Parenthese{
    char c;
    int index;

    public Parenthese(char c, int index) {
        this.c = c;
        this.index = index;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
