package linklist;

/**
 * @Description: 83. 删除排序链表中的重复元素
 * @Author: 吴智慧
 * @Date: 2020/9/17 21:10
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();

        ListNode list1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        list1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode result = removeDuplicatesFromSortedList.deleteDuplicates(list1);

        LinkedListUtils.print(result);
    }

    /**
     * 直接遍历处理
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                slow.next = fast;
            }else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return head;
    }
}
