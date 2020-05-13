package ltd.ryantech.tree.maximumDepthOfBinaryTree104;

import ltd.ryantech.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.maximumDepthOfBinaryTree104
 * @description 二叉树的最大深度
 * @leetcode_CN_url // https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @leetcode_US_url // https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/13 20:17
 **/

public class Solution1 {
    // 层序遍历 BFS 算法
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNodeSums = queue.size();
            for (int i = 0; i < levelNodeSums; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("The depth of tree is : " + new Solution1().maxDepth(root));
    }
}
