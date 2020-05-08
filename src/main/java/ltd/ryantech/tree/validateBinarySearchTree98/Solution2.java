package ltd.ryantech.tree.validateBinarySearchTree98;

import java.util.Stack;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.validateBinarySearchTree98
 * @description
 * @create 2020/05/05 15:10
 **/

public class Solution2 {
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
