package ltd.ryantech.tree.pathSum112;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.pathSum112
 * @description 路径总和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/path-sum/
 * @leetcode_US_url // https://leetcode.com/problems/path-sum/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/14 23:36
 **/

public class Solution1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumHelper(root, sum);
    }

    public boolean hasPathSumHelper(TreeNode root, int sum) {
        // 到达根节点
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        // 左孩子为 null 时候
        if (root.left == null) {
            return hasPathSumHelper(root.right, sum - root.val);
        }
        // 右孩子为 null 的时候
        if (root.right == null) {
            return hasPathSumHelper(root.left, sum - root.val);
        }
        return hasPathSumHelper(root.right, sum - root.val) || hasPathSumHelper(root.left, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        System.out.println(new Solution1().hasPathSum(root, 22));
    }
}
