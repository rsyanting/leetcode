package ltd.ryantech.tree.binaryTreeTilt563;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.binaryTreeTilt563
 * @description 二叉树的坡度
 * @leetcode_CN_url // https://leetcode-cn.com/problems/binary-tree-tilt/
 * @leetcode_US_url // https://leetcode.com/problems/binary-tree-tilt/
 * @hard_level Medium
 * @tag 简单 // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/28 14:21
 **/

public class Solution1 {
    int tilt = 0;

    public int findTilt(TreeNode root) {
        tiltHelper(root);
        return tilt;
    }

    public int tiltHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = tiltHelper(root.left);
        int rightValue = tiltHelper(root.right);
        tilt += Math.abs(leftValue - rightValue);
        return leftValue + rightValue + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(new Solution1().findTilt(root));
    }
}
