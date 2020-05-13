package ltd.ryantech.tree.maximumDepthOfBinaryTree104;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.maximumDepthOfBinaryTree104
 * @description 二叉树的最大深度
 * @leetcode_CN_url // https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @leetcode_US_url // https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/13 20:42
 **/

public class Solution2 {
    // DFS 递归算法
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("The depth of tree is : " + new Solution2().maxDepth(root));
    }
}
