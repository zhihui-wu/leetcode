package linklist;

/**
 * @Description: 237. 删除链表中的节点
 * @Author: 吴智慧
 * @Date: 2020/9/17 21:14
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeInALinkedList {

    public static void main(String[] args) {
        DeleteNodeInALinkedList deleteNodeInALinkedList = new DeleteNodeInALinkedList();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        // 打印原链表
        LinkedListUtils.print(node1);

        // 删除当前节点
        deleteNodeInALinkedList.deleteNode(node2);

        // 打印链表
        LinkedListUtils.print(node1);

    }

    /**
     * 删除当前节点
     */
    public void deleteNode(ListNode node) {
        // 将后一个节点的值复制给当前节点，并跳过后一个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
