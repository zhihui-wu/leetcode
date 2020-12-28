package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 145. 二叉树的后序遍历
 * @Author: 吴智慧
 * @Date: 2020/12/28 20:24
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {

        BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();

        binaryTreePostorderTraversal.postorderTraversal(new TreeNode());

    }

    List<Integer> result = new ArrayList<>();

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：最好 O（ log n ）, 最坏 O（ n ）
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result.add(root.val);
        }
        return result;
    }


}
