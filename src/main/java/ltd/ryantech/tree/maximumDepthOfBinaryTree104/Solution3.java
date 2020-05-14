package ltd.ryantech.tree.maximumDepthOfBinaryTree104;

import javafx.util.Pair;
import ltd.ryantech.tree.TreeNode;

import java.util.Stack;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.maximumDepthOfBinaryTree104
 * @description 二叉树的最大深度
 * @leetcode_CN_url // https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @leetcode_US_url // https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/13 20:48
 **/

public class Solution3 {
    // DFS 非递归算法
    // 二叉树的先序遍历
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<TreeNode, Integer>(root, 1));
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek().getKey();
            int cur_depth = stack.peek().getValue();
            stack.pop();
            if (cur.right != null) {
                stack.push(new Pair<TreeNode, Integer>(cur.right, cur_depth + 1));
            }
            if (cur.left != null) {
                stack.push(new Pair<TreeNode, Integer>(cur.left, cur_depth + 1));
            }
            depth = Math.max(depth, cur_depth);
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("The depth of tree is : " + new Solution3().maxDepth(root));
    }
}
