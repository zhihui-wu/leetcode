package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 236. 二叉树的最近公共祖先
 * @Author: 吴智慧
 * @Date: 2021/1/5 21:50
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {

    }

    Deque<TreeNode> pPath = new LinkedList<>();

    Deque<TreeNode> qPath = new LinkedList<>();


    /**
     * 自顶向下，使用上一层已建立的next指针建立该层的next，顶层root视作已建立next指针
     * 时间复杂度：O（ n ）最坏情况 遍历所有节点才找到p和q
     * 空间复杂度：O（ n ）最坏情况 二叉树退化为链表，路径长度为n
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 深度优先，得出p的路径
        doSearch(root, p, pPath);

        // 深度优先，得出q的路径
        doSearch(root, q, qPath);

        // 比对两条路径，找出最后的相同点
        TreeNode result = null;
        int psize = pPath.size();
        int qsize = qPath.size();
        for (int i = 0; i < psize && i < qsize; i++) {
            TreeNode presult = pPath.removeFirst();
            TreeNode qresult = qPath.removeFirst();
            if (presult == qresult) {
                result = presult;
            } else {
                break;
            }
        }
        return result;
    }

    private boolean doSearch(TreeNode root, TreeNode target, Deque<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.addLast(root);
        if (root == target) {
            return true;
        }
        if (doSearch(root.left, target, path)) {
            return true;
        }
        if (doSearch(root.right, target, path)) {
            return true;
        }
        path.removeLast();
        return false;
    }

}
