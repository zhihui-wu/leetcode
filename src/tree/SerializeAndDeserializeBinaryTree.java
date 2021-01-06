package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @Description: 297. 二叉树的序列化与反序列化
 * @Author: 吴智慧
 * @Date: 2021/1/6 20:41
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {

        SerializeAndDeserializeBinaryTree object = new SerializeAndDeserializeBinaryTree();

//        TreeNode result1 = object.deserialize("[1,2,3,null,null,4,5]");

        TreeNode result1 = object.deserialize("[]");

        String result2 = object.serialize(result1);

        System.out.println(result2);


    }

    // Encodes a tree to a single string.
    /**
     * 层序遍历（广度优先）收集元素,进行拼接
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public String serialize(TreeNode root) {
        // 层序遍历（广度优先）收集元素
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (queue.size() > 0) {
            TreeNode temp = queue.remove();
            if (temp == null) {
                list.add(null);
                continue;
            }
            list.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }else {
                queue.add(null);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }else {
                queue.add(null);
            }
        }
        // 计算优先元素个数（去除尾部的null）
        int i = list.size() - 1;
        while (i >= 0) {
            if (list.get(i) != null) {
                break;
            }
            i--;
        }
        // 进行字符串拼接
        StringBuilder result = new StringBuilder("[");
        for (int j = 0; j <= i; j++) {
            if (list.get(j) != null){
                result.append(list.get(j));
            }else {
                result.append("null");
            }
            if (j != i){
                result.append(",");
            }else if(j == i) {
                result.append("]");
            }
        }
        return result.toString();

    }

    // Decodes your encoded data to tree.
    /**
     * 使用Hash表进行记录和查找，通过快慢指针关联父子节点
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public TreeNode deserialize(String data) {
        if (data.length() <= 2) {
            return null;
        }
        // 处理数据为元素数组
        data = data.substring(1, data.length()-1);
        String[] elements = data.split(",");
        if (elements.length <= 0) {
            return null;
        }
        if (elements[0] == "null") {
            return null;
        }
        // 用于记录和查找创建好的节点
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode head = new TreeNode(Integer.parseInt(elements[0]));
        map.put(0, head);
        // 快慢指针遍历数组，生成节点
        int slow = 0;
        int quick = 1;
        while (quick < elements.length && slow < elements.length) {
            if (!"null".equals(elements[slow])) {
                TreeNode temp = map.get(slow);
                if (!"null".equals(elements[quick])) {
                    TreeNode create = new TreeNode(Integer.parseInt(elements[quick]));
                    map.put(quick, create);
                    temp.left = create;
                }
                quick++;
                if (quick < elements.length) {
                    if (!"null".equals(elements[quick])) {
                        TreeNode create = new TreeNode(Integer.parseInt(elements[quick]));
                        map.put(quick, create);
                        temp.right = create;
                    }
                    quick++;
                }
            }
            slow++;
        }
        return head;

    }
}
