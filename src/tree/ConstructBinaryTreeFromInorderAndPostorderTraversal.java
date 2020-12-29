package tree;

/**
 * @Description: 106. 从中序与后序遍历序列构造二叉树
 * @Author: 吴智慧
 * @Date: 2020/12/29 20:23
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {

        ConstructBinaryTreeFromInorderAndPostorderTraversal object = new ConstructBinaryTreeFromInorderAndPostorderTraversal();

        object.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

    }


    /**
     * 递归，自顶向下
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return doBuildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode doBuildTree(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
        if (iLeft > iRight) {
            return null;
        }
        TreeNode tempNode = new TreeNode();
        tempNode.val = postorder[pRight];
        int index = 0;
        int count = 0;
        for (int i = iLeft; i <= iRight; i++) {
            if (inorder[i] == postorder[pRight]) {
                index = i;
                break;
            }
            count++;
        }
        tempNode.right = doBuildTree(inorder, index + 1, iRight, postorder, pLeft + count, pRight - 1);
        tempNode.left = doBuildTree(inorder, iLeft, index - 1, postorder, pLeft, pLeft + count - 1);
        return tempNode;
    }


}
