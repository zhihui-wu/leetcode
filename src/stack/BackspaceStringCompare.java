package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 844. 比较含退格的字符串
 * @Author: 吴智慧
 * @Date: 2020/10/18 15:49
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {

        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
//        String S = "ab#c";
//        String T = "ad#c";
        String S = "abcd";
        String T = "bbcd";

        // 计算退格后的最终字符串，进行比对
        boolean result = backspaceStringCompare.backspaceCompare(S, T);
        System.out.println(result);

    }

    public boolean backspaceCompare(String S, String T) {

        Deque<Character> sStack = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                sStack.push(c);
            }
            if (c == '#') {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            }
        }

        Deque<Character> tStack = new LinkedList<>();
        for (char c : T.toCharArray()) {
            if (c != '#') {
                tStack.push(c);
            }
            if (c == '#') {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            }
        }

        if (sStack.size() != tStack.size()) {
            return false;
        }

        if (sStack.isEmpty() && tStack.isEmpty()) {
            return true;
        }

        int size = sStack.size();
        boolean result = true;

        for (int i = 0; i < size; i++) {
            if (!sStack.pop().equals(tStack.pop())) {
                result = false;
                break;
            }
        }
        return result;
    }
}
