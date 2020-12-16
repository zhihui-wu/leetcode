package tree;

import java.util.LinkedList;

/**
 * @Description: 104. 二叉树的最大深度
 * @Author: 吴智慧
 * @Date: 2020/12/16 20:30
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();

        /**
         * 广度优先
         */
        int result = maximumDepthOfBinaryTree.maxDepth(new TreeNode());

        /**
         * 递归，深度优先
         */
        int result1 = maximumDepthOfBinaryTree.maxDepth1(new TreeNode());

        System.out.println(result);

    }

    /**
     * n 个节点
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n / 2 ）
     */
    private int maxDepth(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int result = 0;
        if (root == null) {
            return result;
        }
        queue.add(root);
        queue.addLast(new TreeNode(Integer.MAX_VALUE));
        while (queue.size() > 0) {
            TreeNode temp = queue.removeFirst();
            if (temp.val == Integer.MAX_VALUE) {
                result++;
                if (queue.size() > 0) {
                    queue.addLast(new TreeNode(Integer.MAX_VALUE));
                }
            }
            if (temp.left != null) {
                queue.addLast(temp.left);
            }
            if (temp.right != null) {
                queue.addLast(temp.right);
            }
        }
        return result;
    }


    /**
     * n 个节点
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ height ）
     */
    private int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }else {
            int left = maxDepth1(root.left);
            int right = maxDepth1(root.right);
            return (Math.max(left, right) + 1);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
