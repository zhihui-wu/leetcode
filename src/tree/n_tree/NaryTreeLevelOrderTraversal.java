package tree.n_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 429. N 叉树的层序遍历
 * @Author: 吴智慧
 * @Date: 2021/1/11 15:36
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

    /**
     * 使用队列
     * 时间复杂度：O（ n ）
     * 空间复杂度：最坏 O（ n ）
     */
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        int size = 0;

        if (root != null) {
            queue.add(root);
            size = 1;
        }
        while (queue.size() > 0){
            List<Integer> tempResult = new ArrayList<>();
            int tempSize = size;
            size = 0;
            for (int i = 0; i < tempSize; i++) {
                Node tempNode = queue.remove();
                tempResult.add(tempNode.val);
                if (tempNode.children != null) {
                    queue.addAll(tempNode.children);
                    size += tempNode.children.size();
                }
            }
            result.add(tempResult);
        }
        return result;
    }

}
