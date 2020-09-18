package linklist;

/**
 * @Description: 203. 移除链表元素
 * @Author: 吴智慧
 * @Date: 2020/9/17 21:19
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        int val = 5;

        // 打印原链表
        LinkedListUtils.print(node1);

        // 删除当前节点
        removeLinkedListElements.removeElements(node2, 5);

        // 打印链表
        LinkedListUtils.print(node1);
    }

    public ListNode removeElements(ListNode head, int val) {
        return head;
    }
}
