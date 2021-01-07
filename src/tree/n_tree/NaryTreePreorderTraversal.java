package tree.n_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 589. N叉树的前序遍历
 * @Author: 吴智慧
 * @Date: 2021/1/7 21:00
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class NaryTreePreorderTraversal {

    public static void main(String[] args) {

    }

    List<Integer> list = new ArrayList<>();

    /**
     * 递归
     * 时间复杂度：O（ n ）
     * 空间复杂度：最好 O（ log n ）, 最坏 O（ n ）
     */
    public List<Integer> preorder(Node root) {
        if (root != null){
            list.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                preorder(root.children.get(i));
            }
        }
        return list;
    }

    /**
     * 迭代，需要使用栈来处理
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            result.add(temp.val);
            // 已先右后左的顺序放入栈，出栈时先取出的是左边的
            for (int i = temp.children.size() - 1; i >= 0; i--) {
                stack.push(temp.children.get(i));
            }
        }
        return result;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
