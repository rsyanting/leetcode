package ltd.ryantech.tree.binaryTreeLevelOrderTraversal102;

import ltd.ryantech.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.binaryTreeLevelOrderTraversal102
 * @description 二叉树的层序遍历
 * @leetcode_CN_url // https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @leetcode_US_url // https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/13 19:52
 **/

public class Solution1 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每一层的节点数
            int level_size = queue.size();
            TreeNode cur = queue.peek();
            // 每一层的 val 值
            List<Integer> level_res = new LinkedList<>();
            for (int i = 0; i < level_size; i++) {
                cur = queue.poll();
                level_res.add(cur.val);
                // 将当前节点的左右子树入队
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(level_res);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = new Solution1().levelOrder(root);
        for (List list : res) {
            for (Object integer : list) {
                System.out.println(integer);
            }
        }
    }
}
