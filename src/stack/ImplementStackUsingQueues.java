package stack;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 225. 用队列实现栈
 * @Author: 吴智慧
 * @Date: 2020/10/24 16:00
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_2 = obj.pop();
        System.out.println(param_2);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }

}
class MyStack {

    private Queue<Integer> queueOne;

    private Queue<Integer> queueTwo;

    private int inputFlag;

    /** Initialize your data structure here. */
    public MyStack() {
        queueOne = new LinkedList<>();
        queueTwo = new LinkedList<>();
        inputFlag = 1;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (inputFlag == 1) {
            queueOne.offer(x);
        }else{
            queueTwo.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (inputFlag == 1) {
            int i = 1;
            int size = queueOne.size();
            while (i < size) {
                Integer temp = queueOne.poll();
                queueTwo.offer(temp);
                i++;
            }
            inputFlag = 2;
            return queueOne.poll();
        }else {
            int i = 1;
            int size = queueTwo.size();
            while (i < size) {
                Integer temp = queueTwo.poll();
                queueOne.offer(temp);
                i++;
            }
            inputFlag = 1;
            return queueTwo.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        int top = 0;
        if (inputFlag == 1) {
            int i = 0;
            int size = queueOne.size();
            while (i < size) {
                Integer temp = queueOne.poll();
                queueTwo.offer(temp);
                i++;
                if (i == size) {
                    top = temp;
                }
            }
            inputFlag = 2;
            return top;
        }else {
            int i = 0;
            int size = queueTwo.size();
            while (i < size) {
                Integer temp = queueTwo.poll();
                queueOne.offer(temp);
                i++;
                if (i == size) {
                    top = temp;
                }
            }
            inputFlag = 1;
            return top;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueOne.isEmpty() && queueTwo.isEmpty();
    }
}
