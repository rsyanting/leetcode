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
 * @create 2020/08/21 10:00
 **/

public class Solution2 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回 leftDepth + rightDepth + 1
        //2.如果都不为空，返回较小深度 +1
        return leftDepth == 0 || rightDepth == 0 ? leftDepth + rightDepth + 1 : Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution2().minDepth(root));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println(new Solution2().minDepth(root2));
    }
}
