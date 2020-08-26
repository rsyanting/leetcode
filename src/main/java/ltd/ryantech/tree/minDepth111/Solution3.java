package ltd.ryantech.tree.minDepth111;

import ltd.ryantech.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.minDepth111
 * @description
 * @create 2020/08/25 08:54
 **/

public class Solution3 {
    // BFS 解法
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int depth = 1;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = deque.pollFirst();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    deque.addLast(cur.left);
                }
                if (cur.right != null) {
                    deque.addLast(cur.right);
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
        System.out.println(new Solution3().minDepth(root));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println(new Solution3().minDepth(root2));
    }
}
