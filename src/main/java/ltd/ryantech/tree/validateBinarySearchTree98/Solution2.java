package ltd.ryantech.tree.validateBinarySearchTree98;

import ltd.ryantech.tree.TreeNode;

import java.util.Stack;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.validateBinarySearchTree98
 * @description 98. 验证二叉搜索树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @leetcode_US_url // https://leetcode.com/problems/validate-binary-search-tree/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/05 15:10
 **/

public class Solution2 {
    // 中序遍历 迭代法
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long inorderValue = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorderValue) {
                return false;
            }
            inorderValue = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new Solution2().isValidBST(root));
    }
}
