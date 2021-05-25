package linklist;

/**
 * @Description: 61. 旋转链表
 * @Author: 吴智慧
 * @Date: 2021/5/25 14:41
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class RotateList {

    public static void main(String[] args) {

    }


    /**
     * 解法一：遍历计算节点数 + 链表尾插法
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     * head = [1], k = 0; head = [1], k = 1; 两种特殊情况需要考虑，可以绕过
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        ListNode rear = tempHead;
        int count = 0;
        while (rear.next != null) {
            count++;
            rear = rear.next;
        }

        k = k % count;
        for (int i = 0; i < count - k; i++) {
            ListNode temp = tempHead.next;
            tempHead.next = tempHead.next.next;
            rear.next = temp;
            rear = rear.next;
            rear.next = null;
        }
        return tempHead.next;
    }



    /**
     * 解法二：遍历计算节点数 + 变环 + 移动指针 + 断开环
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     */

}
