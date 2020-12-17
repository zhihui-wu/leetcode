package tree;

/**
 * @Description: 101. 对称二叉树
 * @Author: 吴智慧
 * @Date: 2020/12/16 21:54
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public static void main(String[] args) {

        SymmetricTree symmetricTree = new SymmetricTree();

        boolean result = symmetricTree.isSymmetric(new TreeNode());

        System.out.println(result);

    }

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ height ）
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        return left.val == right.val && recur(left.left, right.right) && recur(left.right, right.left);

    }
}
