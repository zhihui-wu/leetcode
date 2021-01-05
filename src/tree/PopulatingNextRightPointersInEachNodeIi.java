package tree;

/**
 * @Description: 117. 填充每个节点的下一个右侧节点指针 II
 * @Author: 吴智慧
 * @Date: 2021/1/5 21:08
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeIi {

    public static void main(String[] args) {

    }


    /**
     * 自顶向下，使用上一层已建立的next指针建立该层的next，顶层root视作已建立next指针
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        Node leftMost = root;

        while (getNextLeftMost(leftMost) != null) {
            Node head = leftMost;
            Node temp = null;
            while (head != null) {
                if (head.left != null) {
                    if (temp != null) {
                        temp.next = head.left;
                    }
                    temp = head.left;
                }
                if (head.right != null) {
                    if (temp != null) {
                        temp.next = head.right;
                    }
                    temp = head.right;
                }
                head = head.next;
            }
            leftMost = getNextLeftMost(leftMost);
        }
        return root;
    }

    /**
     * 获取下一层最左元素
     */
    private Node getNextLeftMost(Node head) {
        while (head != null) {
            if (head.left != null) {
                return head.left;
            }
            if (head.right != null) {
                return head.right;
            }
            head = head.next;
        }
        return null;
    }

}
