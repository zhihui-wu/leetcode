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

        deleteNodeInALinkedList.print(node1);

        deleteNodeInALinkedList.deleteNode(node2);

        deleteNodeInALinkedList.print(node1);

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println("");
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
