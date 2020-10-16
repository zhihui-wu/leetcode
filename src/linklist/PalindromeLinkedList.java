package linklist;

/**
 * @Description: 234. 回文链表
 *               面试题 02.06. 回文链表
 * @Author: 吴智慧
 * @Date: 2020/9/17 21:21
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

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


        // 解法一：快慢指针，反转一半链表
        boolean result = palindromeLinkedList.isPalindrome(list1);

        System.out.println(result);
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null ){
            return head.val == head.next.val;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        ListNode temp = null;
        // 通过快慢指针，slow遍历到列表中间节点
        // 反转前半个列表
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            temp = pre;
            pre = slow;
            slow = slow.next;
            pre.next = temp;
        }

        // 确定需要对比的两部分链表头
        ListNode list1 = null;
        ListNode list2 = null;
        if (fast == null) {
            list1 = pre;
            list2 = slow;
        }else if (fast.next == null){
            list1 = pre;
            list2 = slow.next;
        }

        // 对比两个链表
        while (list2 != null) {
            if (list1.val != list2.val) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return true;
    }
}
