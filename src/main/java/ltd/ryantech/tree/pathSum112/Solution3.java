package ltd.ryantech.tree.pathSum112;

import javafx.util.Pair;
import ltd.ryantech.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.pathSum112
 * @description
 * @create 2020/06/04 12:53
 **/

public class Solution3 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, root.val));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> cur = queue.poll();
            // 头节点 到 叶节点
            if (cur.getKey().left == null && cur.getKey().right == null) {
                if (cur.getValue() == sum) {
                    return true;
                }
            }

            if (cur.getKey().right != null) {
                queue.offer(new Pair<>(cur.getKey().right, cur.getValue() + cur.getKey().right.val));
            }

            if (cur.getKey().left != null) {
                queue.offer(new Pair<>(cur.getKey().left, cur.getValue() + cur.getKey().left.val));
            }
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        System.out.println(new Solution3().hasPathSum(root, 22));
    }
}
