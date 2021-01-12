package tree.n_tree;

/**
 * @Description: 559. N 叉树的最大深度
 * @Author: 吴智慧
 * @Date: 2021/1/12 19:13
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaximumDepthOfNaryTree {

    public static void main(String[] args) {


    }

    private int count = 0;

    /**
     * 递归，请尝试下不要用成员变量来处理
     * 时间复杂度：O（ n ）
     * 空间复杂度：最坏 O（ n ）
     */
    public int maxDepth(Node root) {
        return doMaxDepth(root, 0);
    }

    public int doMaxDepth(Node root, int n) {
        if (root == null) {
            return count;
        }
        n++;
        if ( n > count) {
            count = n;
        }
        if (root.children != null) {
            for (Node node : root.children) {
                doMaxDepth(node, n);
            }
        }
        return count;
    }


}
