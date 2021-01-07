package tree.n_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 590. N叉树的后序遍历
 * @Author: 吴智慧
 * @Date: 2021/1/7 21:41
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class NaryTreePostorderTraversal {

    public static void main(String[] args) {

    }

    /**
     * 迭代，需要使用栈来处理（和前序遍历方法一样，不过入栈顺序细节不同，需要反转得到后序遍历）
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public List<Integer> postorder(Node root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            list.add(temp.val);
            // 先左后右的顺序放入栈，先出栈的是右边的，得出来的是前序遍历不太一样
            for (int i = 0; i < temp.children.size(); i++) {
                stack.push(temp.children.get(i));
            }
        }

        // 反转后得到后序遍历
        Collections.reverse(list);
        return list;
    }

}
