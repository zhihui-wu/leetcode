package linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 138. 复制带随机指针的链表
 * @Author: 吴智慧
 * @Date: 2021/5/24 17:14
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
    }

    /**
     * 解法一：使用哈希表缓存
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N ）
     */
    public Node copyRandomList(Node head) {
        Node newHead = new Node(0);

        Node newTemp = newHead;
        Node oldTemp = head;

        Map<Node, Integer> oldMap = new HashMap<>();
        Map<Integer, Node> newMap = new HashMap<>();
        // 构造链表、设置缓存
        int i = 0;
        while(oldTemp != null) {
            Node temp = new Node(oldTemp.val);
            temp.random = oldTemp.random;
            newTemp.next = temp;
            newTemp = newTemp.next;

            oldMap.put(oldTemp, i);
            newMap.put(i, temp);

            i++;
            oldTemp = oldTemp.next;
        }
        // 使用缓存填充随机指针
        Node point = newHead.next;
        while (point != null) {
            if (point.random != null) {
                point.random = newMap.get(oldMap.get(point.random));
            }
            point = point.next;
        }

        return newHead.next;
    }


    /**
     * 解法一：使用哈希表缓存(优化)
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N ）
     */
    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;
        }

        cur = head;
        while(cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 图的深度优先遍历
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ N ）
     */


}
