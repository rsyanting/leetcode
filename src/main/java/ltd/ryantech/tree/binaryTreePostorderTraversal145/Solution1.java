package ltd.ryantech.tree.binaryTreePostorderTraversal145;

import ltd.ryantech.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.binaryTreePostorderTraversal145
 * @description 二叉树的后序遍历
 * @leetcode_CN_url // https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @leetcode_US_url // https://leetcode.com/problems/binary-tree-postorder-traversal/
 * @hard_level Hard
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/13 16:06
 **/

public class Solution1 {
    // 递归 后序遍历二叉树
    private List<Integer> res = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            res.add(root.val);
        }
        // 如果 root 为空，则返回 res, res 中没有任何元素
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = new Solution1().postorderTraversal(root);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
