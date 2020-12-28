package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 94. 二叉树的中序遍历
 * @Author: 吴智慧
 * @Date: 2020/12/28 20:17
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {

        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();

        binaryTreeInorderTraversal.inorderTraversal(new TreeNode());

    }

    List<Integer> result = new ArrayList<>();

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：最好 O（ log n ）, 最坏 O（ n ）
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }


}
