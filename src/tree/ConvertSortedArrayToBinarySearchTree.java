package tree;

/**
 * @Description: 108. 将有序数组转换为二叉搜索树
 * @Author: 吴智慧
 * @Date: 2020/12/17 20:47
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {

        ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();

        TreeNode result = convertSortedArrayToBinarySearchTree.sortedArrayToBST(new int[]{});

        System.out.println(result);

    }

    /**
     * 二叉搜索树的中序遍历是升序序列，题目给定的数组是按照升序排序的有序数组，因此可以确保数组是二叉搜索树的中序遍历序列
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return doToBst(nums, 0, nums.length - 1);
    }

    public TreeNode doToBst(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = left + (right - left) / 2;
        TreeNode result = new TreeNode(nums[mid]);
        result.left = doToBst(nums, left, mid - 1);
        result.right = doToBst(nums, mid + 1, right);
        return result;
    }



}
