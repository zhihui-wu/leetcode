package linklist;

/**
 * @Description: 链表工具类
 * @Author: 吴智慧
 * @Date: 2020/9/18 12:22
 */
public class LinkedListUtils {

    /**
     * 遍历打印链表元素
     */
    public static void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println("");
    }
}

/**
 * 节点
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
