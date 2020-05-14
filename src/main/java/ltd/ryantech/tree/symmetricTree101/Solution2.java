package ltd.ryantech.tree.symmetricTree101;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.symmetricTree101
 * @description 对称二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/symmetric-tree/
 * @leetcode_US_url // https://leetcode.com/problems/symmetric-tree/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/14 21:49
 **/

public class Solution2 {
    // 递归解法
    // 思想类似于 DFS 深度优先搜索
    // 沿着左子树的左子树走到底部，同时沿着右子树的右子树走到底部，每次比较其底部的值，再递归向上。
    // 然后沿着左子树的右子树，沿着右子树的左子树走到底部，进行比较，逐层向上递归，每次比较其值。
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        // 根节点的情况，其值相同
        if (t1 == null && t2 == null) {
            return true;
        }
        // 出现了不对称残缺，非镜像
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(new Solution2().isSymmetric(root));
    }
}
