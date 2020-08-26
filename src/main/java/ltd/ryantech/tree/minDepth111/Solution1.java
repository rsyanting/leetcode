package ltd.ryantech.tree.minDepth111;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.minDepth111
 * @description 111. 二叉树的最小深度
 * @leetcode_CN_url // https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @leetcode_US_url // https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/08/21 08:52
 **/

public class Solution1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左右孩子都为空的情况下，说明到达了叶子节点，返回 1 即可
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // 有一个节点为空的情况，那么必然有一个深度为 0
        if (leftDepth == 0 || rightDepth == 0) {
            return leftDepth + rightDepth + 1;
        }
        // 以上情况均不是返回其中的一个较小值即可
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public int minDepthRaw(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d1 = minDepthRaw(root.left);
        int d2 = minDepthRaw(root.right);
        return Math.min(d1, d2) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution1().minDepth(root));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println(new Solution1().minDepth(root2));

        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);
        root3.left.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);
        System.out.println(new Solution1().minDepthRaw(root3));
    }
}
