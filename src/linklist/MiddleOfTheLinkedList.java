package linklist;

/**
 * @Description: 876. 链表的中间结点
 * @Author: 吴智慧
 * @Date: 2020/9/17 21:13
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        MiddleOfTheLinkedList middleOfTheLinkedList = new MiddleOfTheLinkedList();

        ListNode list1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(8);
        list1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        // 打印链表
        LinkedListUtils.print(list1);

        // 解法一：快慢指针法
        ListNode result = middleOfTheLinkedList.middleNode(list1);

        // 打印链表
        LinkedListUtils.print(result);
    }

    /**
     * 快慢指针法
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     */
    public ListNode middleNode(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next;
            quick = quick.next;
            slow = slow.next;
        }
        return slow;

    }
}
