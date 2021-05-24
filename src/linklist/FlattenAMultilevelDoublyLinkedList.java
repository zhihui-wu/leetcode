package linklist;

/**
 * @Description: 430. 扁平化多级双向链表
 * @Author: 吴智慧
 * @Date: 2021/5/24 16:22
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {

    }

    Node point = null;

    /**
     * 递归
     * 时间复杂度：O（ 节点数 ）
     * 空间复杂度：O（ 最深级数 ）
     * 其实就是一棵二叉树的深度优先遍历
     */
    public Node flatten(Node head) {
        Node newHead = new Node();
        point = newHead;
        doFlattem(head);
//        Node temp = newHead;
//        while(temp != null) {
//            System.out.println(temp.val + " - " + temp.prev + " - " + temp.next + " - " + temp.child);
//            temp = temp.next;
//        }
        Node result = newHead.next;
        if (result != null) {
            result.prev = null;
        }
        return result;
    }

    public void doFlattem(Node head){
        Node tempPoint = head;
        while(tempPoint != null) {
            Node temp = tempPoint;
            tempPoint = tempPoint.next;
            temp.prev = point;
            point.next = temp;
            point = point.next;
            point.child = null;
            if (temp.child != null) {
                doFlattem(temp.child);
            }
        }
    }

}


class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
