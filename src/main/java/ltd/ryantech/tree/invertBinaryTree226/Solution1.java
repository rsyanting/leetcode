package ltd.ryantech.tree.invertBinaryTree226;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.invertBinaryTree226
 * @description 翻转二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/invert-binary-tree/
 * @leetcode_US_url // https://leetcode.com/problems/invert-binary-tree/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/02 14:40
 **/

public class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode res = new Solution1().invertTree(root);
    }
}
