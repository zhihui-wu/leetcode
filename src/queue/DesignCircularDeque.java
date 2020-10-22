package queue;

/**
 * @Description: 641. 设计循环双端队列
 * @Author: 吴智慧
 * @Date: 2020/10/18 15:08
 * https://leetcode-cn.com/problems/design-circular-deque/
 */
public class DesignCircularDeque {

    public static void main(String[] args) {

        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        boolean r1 = circularDeque.insertLast(1);			        // 返回 true
        System.out.println(r1);
        boolean r2 = circularDeque.insertLast(2);			        // 返回 true
        System.out.println(r2);
        boolean r3 = circularDeque.insertFront(3);			        // 返回 true
        System.out.println(r3);
        boolean r4 = circularDeque.insertFront(4);			        // 已经满了，返回 false
        System.out.println(r4);
        int r5 = circularDeque.getRear();  				// 返回 2
        System.out.println(r5);
        boolean r6 = circularDeque.isFull();				        // 返回 true
        System.out.println(r6);
        boolean r7 = circularDeque.deleteLast();			        // 返回 true
        System.out.println(r7);
        boolean r8 = circularDeque.insertFront(4);			        // 返回 true
        System.out.println(r8);
        int r9 = circularDeque.getFront();				// 返回 4
        System.out.println(r9);
    }
}

/**
 * 注意点
 * 1、队列判空条件
 * 2、队列已满条件
 * 3、初始化时，数组要大一个存储空间，因为需要空出一个存储空间
 * 4、head、rear指针的操作
 */
class MyCircularDeque {

    private int[] queue;

    private int n;

    private int head;

    private int tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        n = k + 1;
        queue = new int[n];
        head = 0;
        tail = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head + n - 1) % n;
        queue[head] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        queue[tail] = value;
        tail = (tail + 1) % n;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % n;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail + n - 1) % n;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int temp = (tail + n -1) % n;
        return queue[temp];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (tail == head) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if ((tail + 1) % n == head) {
            return true;
        }
        return false;
    }

}
