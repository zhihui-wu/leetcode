package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 155. 最小栈
 * @Author: 吴智慧
 * @Date: 2020/10/18 15:46
 * https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {

    public static void main(String[] args) {

        // 辅助栈
        // 每push一个数时，在辅助栈中push一个当前最小数
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        int a1 = obj.getMin();
        System.out.println(a1);
        obj.pop();
        int a2 = obj.top();
        System.out.println(a2);
        int a3 = obj.getMin();
        System.out.println(a3);
    }

    Deque<Integer> stack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
        }else {
            minStack.push(x < minStack.peek() ? x : minStack.peek());
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
