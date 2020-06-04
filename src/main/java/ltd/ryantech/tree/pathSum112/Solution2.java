package ltd.ryantech.tree.pathSum112;

import javafx.util.Pair;
import ltd.ryantech.tree.TreeNode;

import java.util.Stack;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.pathSum112
 * @description 112. 路径总和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/path-sum/
 * @leetcode_US_url // https://leetcode.com/problems/path-sum/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/04 11:41
 **/

public class Solution2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, root.val));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pop();
            // 头节点 到 叶节点
            if (cur.getKey().left == null && cur.getKey().right == null) {
                if (cur.getValue() == sum) {
                    return true;
                }
            }

            if (cur.getKey().right != null) {
                stack.push(new Pair<>(cur.getKey().right, cur.getValue() + cur.getKey().right.val));
            }

            if (cur.getKey().left != null) {
                stack.push(new Pair<>(cur.getKey().left, cur.getValue() + cur.getKey().left.val));
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

        System.out.println(new Solution2().hasPathSum(root, 22));
    }
}
