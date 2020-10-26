package stack;

import java.util.Stack;

/**
 * @Description: 232. 用栈实现队列
 * @Author: 吴智慧
 * @Date: 2020/10/18 15:50
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class ImplementQueueUsingStacks {

    public static void main(String[] args) {

        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.peek();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);

    }
}

class MyQueue {

    private Stack<Integer> stackIn;

    private Stack<Integer> stackOut;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                Integer temp = stackIn.pop();
                stackOut.push(temp);
            }
        }
        return stackOut.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                Integer temp = stackIn.pop();
                stackOut.push(temp);
            }
        }
        return stackOut.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackOut.empty() && stackIn.empty();
    }
}
