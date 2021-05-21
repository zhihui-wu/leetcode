package linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 160. 相交链表
 * @Author: 吴智慧
 * @Date: 2021/5/21 13:57
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

    }

    /**
     * 解法一：哈希表
     * 时间复杂度：O（ N + M ）
     * 空间复杂度：O（ N ）
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        Set<ListNode> set = new HashSet<>();
        while(a != null) {
            if (set.contains(a)) {
                return a;
            }else {
                set.add(a);
                a = a.next;
            }
        }
        while(b != null) {
            if (set.contains(b)) {
                return b;
            }else {
                b = b.next;
            }
        }
        return null;
    }

    /**
     * 解法二：双指针法
     * 时间复杂度：O（ N + M ）
     * 空间复杂度：O（ 1 ）
     * 双指针分别遍历两条链表，如果走到各自链尾，再从另一条链表的链头开始遍历
     * 循环终止条件：两个遍历指针同时为null
     * 结果：A链全链 + B链相交前部分 = B链全链 + A链相交前部分
     * 推导：A链全链 + B链全链 - 相交后部分 = A链全链 + B链相交前部分 = B链全链 + A链相交前部分
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        while(a != null || b != null) {
            if (a == null) {
                a = headB;
            }
            if (b == null) {
                b = headA;
            }
            if (a == b) {
                return a;
            }else {
                a = a.next;
                b = b.next;
            }
        }
        return null;
    }
}
