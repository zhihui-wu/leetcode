package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 116. 填充每个节点的下一个右侧节点指针
 * @Author: 吴智慧
 * @Date: 2021/1/5 20:10
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {

        PopulatingNextRightPointersInEachNode object = new PopulatingNextRightPointersInEachNode();

    }


    /**
     * 广度遍历
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public Node connect(Node root) {

        Deque<Node> stack = new LinkedList<>();

        if (root != null) {
            stack.addLast(root);
            stack.addLast(null);
        }

        while (stack.size() > 0) {
            Node temp = stack.removeFirst();
            if (temp == null) {
                if (stack.size() > 0) {
                    stack.addLast(null);
                }
            }else {
                if (temp.left != null) {
                    stack.addLast(temp.left);
                }
                if (temp.right != null) {
                    stack.addLast(temp.right);
                }
                temp.next = stack.peek();
            }
        }

        return root;
    }


    /**
     * 自顶向下，使用上一层已建立的next指针建立该层的next，顶层root视作已建立next指针
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public Node connect1(Node root) {

        if (root == null) {
            return root;
        }

        Node leftMost = root;

        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }

        return root;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
