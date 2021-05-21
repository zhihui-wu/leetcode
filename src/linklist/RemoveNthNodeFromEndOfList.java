package linklist;

/**
 * @Description: 19. 删除链表的倒数第N个节点
 * @Author: 吴智慧
 * @Date: 2020/9/17 21:18
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();

        ListNode list1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        list1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        int n = 2;

//        ListNode list10 = new ListNode(1);
//        list10.next = null;
//        int n = 1;

        // 解法一：一次遍历算法
        ListNode result = removeNthNodeFromEndOfList.removeNthFromEnd(list1, n);

        System.out.println(result);
    }

    /**
     * 解法一：一次遍历算法
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     * 使用：哨兵节点、双指针遍历
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哨兵节点
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        ListNode fast = tempHead;
        ListNode slow = tempHead;
        // 双指针拉开n个节点的距离
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        // 双指针共同前进
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tempHead.next;
    }


    public ListNode removeNthFromEndTest(ListNode head, int n) {
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        ListNode fast = tempHead;
        ListNode slow = tempHead;
        int count = 0;
        while(fast != null) {
            fast = fast.next;
            if (count > n){
                slow = slow.next;
            }
            count++;
        }
        slow.next = slow.next.next;
        return tempHead.next;
    }
}
