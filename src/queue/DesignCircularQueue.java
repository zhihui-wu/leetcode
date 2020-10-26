package queue;

/**
 * @Description: 622. 设计循环队列
 * @Author: 吴智慧
 * @Date: 2020/10/24 15:38
 * https://leetcode-cn.com/problems/design-circular-queue/
 */
public class DesignCircularQueue {

    public static void main(String[] args) {

        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        boolean b1 = circularQueue.enQueue(1); // 返回 true
        boolean b2 = circularQueue.enQueue(2); // 返回 true
        boolean b3 = circularQueue.enQueue(3); // 返回 true
        boolean b4 = circularQueue.enQueue(4); // 返回 false，队列已满
        int i1 = circularQueue.Rear(); // 返回 3
        boolean b5 = circularQueue.isFull(); // 返回 true
        boolean b6 = circularQueue.deQueue(); // 返回 true
        boolean b7 = circularQueue.enQueue(4); // 返回 true
        int i2 = circularQueue.Rear(); // 返回 4
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(i1);
        System.out.println(b5);
        System.out.println(b6);
        System.out.println(b7);
        System.out.println(i2);
    }
}

class MyCircularQueue {

    int[] nums;

    int n;

    int head;

    int rear;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        nums = new int[k + 1];
        n = k + 1;
        head = 0;
        rear = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        nums[rear] = value;
        rear = (rear + 1) % n;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % n;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return nums[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return nums[(rear + n - 1) % n];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == rear;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear + 1) % n == head;
    }
}