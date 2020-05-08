package ltd.ryantech.tree.validateBinarySearchTree98;

import ltd.ryantech.tree.validateBinarySearchTree98.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.validateBinarySearchTree98
 * @description
 * @create 2020/05/05 14:25
 **/

public class Solution1 {
    // 递归解法
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true; // 注意此处条件
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点，如果当前节点的值小于等于中序遍历的前一个节点值，不满足二叉搜索树特性（BST），返 false
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new Solution1().isValidBST(root));
    }
}
