package ltd.ryantech.tree.binaryTreePreorderTraversal144;

import ltd.ryantech.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.binaryTreePreorderTraversal144
 * @description 二叉树的前序遍历
 * @leetcode_CN_url // https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @leetcode_US_url // https://leetcode.com/problems/binary-tree-preorder-traversal/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/13 15:33
 **/

public class Solution1 {
    // 递归 先序遍历二叉树
    private List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        // 如果 root 为空，则返回 res, res 中没有任何元素
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = new Solution1().preorderTraversal(root);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
