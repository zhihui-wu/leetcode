package tree;

/**
 * @Description: 105. 从前序与中序遍历序列构造二叉树
 * @Author: 吴智慧
 * @Date: 2021/1/5 19:53
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {

        ConstructBinaryTreeFromPreorderAndInorderTraversal object = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

        object.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});

    }


    /**
     * 递归，自顶向下
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode doBuildTree(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright){
        if (ileft > iright) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pleft]);
        int mid = ileft;
        int count = 0;
        while (mid <= iright){
            if (inorder[mid] == preorder[pleft]) {
                break;
            }
            mid++;
            count++;
        }
        node.left = doBuildTree(preorder, pleft+1, pleft+count, inorder, ileft, ileft+count-1);
        node.right = doBuildTree(preorder, pleft+count+1, pright, inorder, ileft+count+1, iright);
        return node;
    }

}
