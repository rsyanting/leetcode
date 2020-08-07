package ltd.ryantech.tree.validateBinarySearchTree98;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.validateBinarySearchTree98
 * @description 98. 验证二叉搜索树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @leetcode_US_url // https://leetcode.com/problems/validate-binary-search-tree/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/08/07 13:34
 **/

public class Solution3 {
    // 逐个子树判断上下界的方法，加入上下界，能够防止出现判断错误的情况
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        // 根据 BST 的定义：
        // 节点的左子树只包含小于当前节点的数。
        // 节点的右子树只包含大于当前节点的数。
        // 如果不符合，则返回 false
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        // 递归的进行判断
        if (!helper(node.left, lower, val)) return false; // 首先判断左子树
        return helper(node.right, val, upper); // 再判断右子树
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new Solution3().isValidBST(root));
    }
}
