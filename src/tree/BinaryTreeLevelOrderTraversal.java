package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 102. 二叉树的层序遍历
 * @Author: 吴智慧
 * @Date: 2020/12/17 19:50
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();

        List<List<Integer>> result = binaryTreeLevelOrderTraversal.levelOrder(new TreeNode());

        System.out.println(result);

    }

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        // 使用Queue队列,poll队头取出,offer队尾压入
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 可以通过设置null为每层标记，表示一层遍历结束；
        // 也可以记录层元素个数的变量，用于遍历该层，为0时遍历结束（嵌套循环）
        queue.offer(null);
        while (queue.size() > 0) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                if (queue.size() > 0) {
                    queue.offer(null);
                }
                result.add(new ArrayList<>(item));
                item.clear();
                continue;
            }
            item.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return result;
    }

}
