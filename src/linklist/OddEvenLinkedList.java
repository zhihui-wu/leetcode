package linklist;

/**
 * @Description: 328. 奇偶链表
 * @Author: 吴智慧
 * @Date: 2021/5/21 16:05
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {

    }

    /**
     * 解法一：分离节点后合并
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode tempOdd = head;
        int count = 1;
        ListNode evenHead = new ListNode();
        ListNode tempEven = evenHead;
        while(tempOdd != null && tempOdd.next != null) {
            count++;
            if (count % 2 == 1) {
                tempOdd = tempOdd.next;
            }else {
                tempEven.next = tempOdd.next;
                tempEven = tempEven.next;
                tempOdd.next = tempOdd.next.next;
                tempEven.next = null;
            }
        }
        if (head != null) {
            tempOdd.next = evenHead.next;
        }else {
            head = evenHead.next;
        }
        return head;
    }

}
