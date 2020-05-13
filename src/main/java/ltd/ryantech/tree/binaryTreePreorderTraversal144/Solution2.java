package ltd.ryantech.tree.binaryTreePreorderTraversal144;

import ltd.ryantech.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.binaryTreePreorderTraversal144
 * @description 二叉树的前序遍历
 * @leetcode_CN_url // https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @leetcode_US_url // https://leetcode.com/problems/binary-tree-preorder-traversal/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/13 15:48
 **/

public class Solution2 {
    // 非递归 先序遍历二叉树
    // 迭代法，使用栈作为辅助
    private List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            // 如果 root 为空，则返回 res, res 中没有任何元素
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            // 压栈的顺序需要注意为 先压右子树，后压左子树
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = new Solution2().preorderTraversal(root);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
