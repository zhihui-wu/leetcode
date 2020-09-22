package linklist;

/**
 * @Description: 21. 合并两个有序链表
 *               剑指 Offer 25. 合并两个排序的链表
 * @Author: 吴智慧
 * @Date: 2020/9/17 21:11
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode list1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        list1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode list2 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(9);
        list2.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;


        // 打印链表
        LinkedListUtils.print(list2);

        // 迭代（即遍历）
        ListNode result = mergeTwoSortedLists.mergeTwoLists(list2, list2);

        // 递归

        // 打印链表
        LinkedListUtils.print(result);

    }

    /**
     * 迭代（即遍历）
     * 时间复杂度：O（ N　＋　Ｍ）
     * 空间复杂度：O（ 1 ）
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null);
        ListNode rear = head;
        // 遍历两链表，将小的节点去除，插入新链表中
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                rear.next = l1;
                l1 = l1.next;
            }else {
                rear.next = l2;
                l2 = l2.next;
            }
            rear = rear.next;
        }
        // 两链表剩余部分，直接接上
        ListNode rest = l1;
        if (l2 != null){
            rest = l2;
        }
        rear.next = rest;
        return head.next;
    }
}
