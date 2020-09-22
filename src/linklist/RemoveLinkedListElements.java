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
//        ListNode node1 = new ListNode(4);
//        ListNode node2 = new ListNode(5);
//        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(9);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = null;
//        int val = 5;

        ListNode node1 = new ListNode(1);
        int val = 1;

        // 打印原链表
        LinkedListUtils.print(node1);

        // 删除节点(不使用哨兵)
//        ListNode result = removeLinkedListElements.removeElements(node1, 5);

        // 删除节点(使用哨兵)
        ListNode result = removeLinkedListElements.removeElements1(node1, 5);

        // 打印链表
        LinkedListUtils.print(result);
    }

    public ListNode removeElements(ListNode head, int val) {
        // 记录前后节点，后节点用于比较元素值，前节点用于移除节点（修改其next）
        ListNode pre = head;
        ListNode aft = head;
        while(aft != null) {
            // 1.相等时，需移除节点
            if (aft.val == val) {
                // 如果是头节点，需移除头节点（特殊处理）
                if (aft == head) {
                    head = head.next;
                    pre = pre.next;
                    aft =aft.next;
                } else {
                    aft = aft.next;
                    pre.next = aft;
                }
                continue;
            }
            // 2.不相等时，需后移引用
            // 如果是头节点，则只移动后节点，不移动前节点（特殊处理）
            if (aft != head) {
                pre = pre.next;
            }
            aft = aft.next;
        }
        LinkedListUtils.print(head);
        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        // 哨兵节点
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        // 记录前后节点，后节点用于比较元素值，前节点用于移除节点
        ListNode pre = sentinel;
        ListNode aft = head;
        while(aft != null) {
            // 1.相等时，需移除节点
            if (aft.val == val) {
                aft = aft.next;
                pre.next = aft;
                continue;
            }
            // 2.不相等时，需后移引用
            pre = pre.next;
            aft = aft.next;
        }
        LinkedListUtils.print(head);
        return sentinel.next;
    }
}
