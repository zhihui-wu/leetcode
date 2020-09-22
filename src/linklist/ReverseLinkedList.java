package linklist;

/**
 * @Description: 206. 反转链表
 *               剑指 Offer 24. 反转链表
 * @Author: 吴智慧
 * @Date: 2020/9/17 21:07
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        int val = 5;


        // 打印链表
        LinkedListUtils.print(node1);

        // 遍历
//        ListNode result = reverseLinkedList.reverseList(node1);

        // 递归
        ListNode result = reverseLinkedList.reverseList1(node1);

        // 打印链表
        LinkedListUtils.print(result);

    }


    /**
     * 迭代（即遍历）
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     */
    public ListNode reverseList(ListNode head) {
        // 作为新链表的头节点
        ListNode newList = new ListNode(0);
        newList.next = null;
        // 指向节点，用于头插入
        ListNode node;
        // 用于遍历链表
        ListNode temp = head;
        while (temp != null) {
            // 标记当前节点
            node = temp;
            // 指向下一个节点
            temp = temp.next;
            // 头插入当前节点
            node.next = newList.next;
            newList.next = node;
        }
        return newList.next;
    }


    /**
     * 递归
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N ）
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // aft是原链表最后一个节点，会一直返回，作为最后结果
        ListNode aft = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return aft;
    }
}
