package linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 142. 环形链表 II
 * @Author: 吴智慧
 * @Date: 2020/9/17 21:25
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class linkedListCycleIi {

    public static void main(String[] args) {
        linkedListCycleIi linkedListCycleIi = new linkedListCycleIi();

        ListNode list1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        list1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode list10 = new ListNode(1);
        ListNode node20 = new ListNode(2);
        list10.next = node20;
        node20.next = null;

        // 解法一：哈希表
//        ListNode result = linkedListCycle.detectCycle1(list1);

        // 解法二：快慢指针
        ListNode result = linkedListCycleIi.detectCycle2(list10);

        System.out.println(result);
    }

    /**
     * 解法一：哈希表
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N ）
     */
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
             System.out.println(temp.val);
            if (set.contains(temp)) {
                return temp;
            }else {
                set.add(temp);
                temp = temp.next;
            }
        }
        return null;
    }

    /**
     * 解法二：快慢指针
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 如果有环，快慢指针最终会在环内追逐，并且快指针会追上慢指针
        // a + b + nq = 2 * ( a + b )
        // a = nq - b
        // a:temp指针从头指针走到入环点
        // nq - b：slow指针从第一个相遇点，绕环，直到与temp指针在入环点相遇
        // 思考一下为什么temp指针一定会与slow指针在入环点相遇
        // 因为 nq = a + b ，所以 nq - b = a
        while (fast != null && fast.next != null) {
            System.out.println(slow.val);
            System.out.println(fast.val);
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = head;
                while (temp != slow) {
                    System.out.println(temp.val);
                    System.out.println(slow.val);
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }


    public ListNode detectCycleTest(ListNode head) {
        ListNode fast = head, slow = head, temp = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while(temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }
}
