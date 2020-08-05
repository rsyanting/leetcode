package ltd.ryantech.tree.flatten114;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.flatten114
 * @description 114. 二叉树展开为链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @leetcode_US_url // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/08/02 14:11
 **/

public class Solution2 {
    private TreeNode pre = null;
    private TreeNode dummy = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        // 参考后序遍历
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public void print() {
        while (dummy != null) {
            System.out.println(dummy.val);
            dummy = dummy.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Solution2 solution2 = new Solution2();
        solution2.dummy = root;
        solution2.flatten(root);
        solution2.print();
    }
}
