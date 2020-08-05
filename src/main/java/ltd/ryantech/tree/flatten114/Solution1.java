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
 * @create 2020/08/02 13:47
 **/

public class Solution1 {
    /**
     * 将左子树插入到右子树的地方
     * 将原来的右子树接到左子树的最右边节点
     * 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     */
    public void flatten(TreeNode root) {
        TreeNode dummy = root;
        while (root != null) {
            // 左子树为空，直接考虑下一个节点
            if (root.left != null) {
                // 找到左子树的最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
            }
            root = root.right; // 左子树为空的情况
        }
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
        Solution1 solution1 = new Solution1();
        solution1.flatten(root);
    }
}
