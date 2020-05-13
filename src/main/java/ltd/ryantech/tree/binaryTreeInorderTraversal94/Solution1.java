package ltd.ryantech.tree.binaryTreeInorderTraversal94;

import ltd.ryantech.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.binaryTreeInorderTraversal94
 * @description 二叉树的中序遍历
 * @leetcode_CN_url // https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @leetcode_US_url // https://leetcode.com/problems/binary-tree-inorder-traversal/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/13 16:00
 **/

public class Solution1 {
    // 递归 中序遍历二叉树
    private List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = new Solution1().inorderTraversal(root);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
