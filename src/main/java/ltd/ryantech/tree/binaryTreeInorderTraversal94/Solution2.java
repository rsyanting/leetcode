package ltd.ryantech.tree.binaryTreeInorderTraversal94;

import ltd.ryantech.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.binaryTreeInorderTraversal94
 * @description
 * @create 2020/05/13 16:27
 **/

public class Solution2 {
    // 非递归 中序遍历二叉树
    // 迭代法，使用栈作为辅助
    private List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            // 如果 root 为空，则返回 res, res 中没有任何元素
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 先走到左子树的叶子节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 弹出最后一个元素，即最左端的叶子节点
            root = stack.pop();
            // 访问 “中序” 根节点
            res.add(root.val);
            // 处理右子树
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = new Solution2().inorderTraversal(root);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
