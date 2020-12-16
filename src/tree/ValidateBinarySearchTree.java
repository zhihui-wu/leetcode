package tree;

/**
 * @Description: 98. 验证二叉搜索树
 * @Author: 吴智慧
 * @Date: 2020/12/16 21:00
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();

        // 采用对象包装，由下往上，传递最大/小值和判断值
        boolean result = validateBinarySearchTree.isValidBST(new TreeNode());

        // 不采用对象包装，由上往下，传递上/下限；由下往上吗，传递判断值
        boolean result1 = validateBinarySearchTree.isValidBST1(new TreeNode());

    }


    public boolean isValidBST1(TreeNode root) {
        return doValidBST1(root, null, null);
    }

    public boolean doValidBST1(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if (lower != null && lower >= root.val) {
            return false;
        }
        if (upper != null && upper <= root.val) {
            return false;
        }
        if (!doValidBST1(root.left, lower, root.val)) {
            return false;
        }
        if (!doValidBST1(root.right, root.val, upper)) {
            return false;
        }
        return true;
    }



    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ height ）
     */
    public boolean isValidBST(TreeNode root) {
        Result result = doValidBST(root);
        return result.isValidBst();
    }

    public Result doValidBST(TreeNode root) {
        //终结条件
        if (root == null) {
            return new Result(true, null, null);
        }
        if (root.left == null && root.right == null) {
            return new Result(true, root.val, root.val);
        }

        //递归调用
        Result left = doValidBST(root.left);
        Result right = doValidBST(root.right);

        //该子树非搜索树的情况
        if (!left.isValidBst() || !right.isValidBst()) {
            return new Result(false, null, null);
        }
        if (left.getMax() != null && left.getMax() >= root.val) {
            return new Result(false, null, null);
        }
        if (right.getMin() != null && right.getMin() <= root.val) {
            return new Result(false, null, null);
        }

        //该子树为搜索树的情况
        return new Result(true,
                right.getMax() != null ? right.getMax() : root.val,
                left.getMin() != null ? left.getMin() : root.val);
    }


}

class Result {

    private boolean isValidBst;

    private Integer max;

    private Integer min;

    Result(boolean isValidBst, Integer value, Integer min) {
        this.isValidBst = isValidBst;
        this.max = value;
        this.min = min;
    }

    public boolean isValidBst() {
        return isValidBst;
    }

    public void setValidBst(boolean validBst) {
        isValidBst = validBst;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

}
