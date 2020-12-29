package tree;

/**
 * @Description: 112. 路径总和
 * @Author: 吴智慧
 * @Date: 2020/12/29 20:13
 * https://leetcode-cn.com/problems/path-sum/
 */
public class PathSum {

    public static void main(String[] args) {

    }

    /**
     * 自顶向下，将目标值减去经过的结点值，知道叶节点计算是否为0，设置result为true
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    private boolean result = false;

    public boolean hasPathSum(TreeNode root, int sum) {

        // 一旦找到路径和，后续计算直接返回
        if(result == true) {
            return true;
        }

        // 终止条件
        if(root == null) {
            return result;
        }

        // 计算叶子阶段，该路径和是否等于目标值
        if(root.left == null && root.right == null && sum - root.val == 0) {
            result = true;
        }
        hasPathSum(root.left, sum - root.val);
        hasPathSum(root.right, sum - root.val);
        return result;
    }



}
