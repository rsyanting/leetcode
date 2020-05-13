package ltd.ryantech.tree.symmetricTree101;

import ltd.ryantech.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.symmetricTree101
 * @description
 * @create 2020/05/13 21:29
 **/

public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> levelList = new LinkedList<>();
            int levelNodeSums = queue.size();
            for (int i = 0; i < levelNodeSums; i++) {
                TreeNode cur = queue.poll();
                levelList.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(levelList);
        }
        for (List<Integer> list : res) {
            for (int i = 0; i < list.size() / 2; i++) {
                if (!Objects.equals(list.get(i), list.get(list.size() - i - 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(new Solution1().isSymmetric(root));
    }
}
