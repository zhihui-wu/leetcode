package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 144. 二叉树的前序遍历
 * @Author: 吴智慧
 * @Date: 2020/12/28 20:07
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();
        binaryTreePreorderTraversal.preorderTraversal(new TreeNode());
    }

    List<Integer> result = new ArrayList<>();

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：最好 O（ log n ）, 最坏 O（ n ）
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }


}
