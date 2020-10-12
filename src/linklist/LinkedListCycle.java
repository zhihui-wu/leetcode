package linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 141. 环形链表 (判断链表中是否有环)
 * @Author: 吴智慧
 * @Date: 2020/9/17 21:23
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();

        // 节点的val是不重复的
        ListNode list1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        list1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        // 解法一：哈希表
//        Boolean result = linkedListCycle.hasCycle1(list1);

        // 解法二：快慢指针
        Boolean result = linkedListCycle.hasCycle2(list1);

        System.out.println(result);
    }

    /**
     * 解法一：哈希表
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N ）
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            System.out.println(head.val);
            if (set.contains(head)) {
                return true;
            }else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /**
     * 解法二：快慢指针
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     */
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
            System.out.println(slow.val);
            System.out.println(fast.val);
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
