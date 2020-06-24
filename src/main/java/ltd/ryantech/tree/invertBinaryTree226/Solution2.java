package ltd.ryantech.tree.invertBinaryTree226;

import ltd.ryantech.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.invertBinaryTree226
 * @description 翻转二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/invert-binary-tree/
 * @leetcode_US_url // https://leetcode.com/problems/invert-binary-tree/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/17 18:10
 **/

public class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.pollFirst(); // 队列
//            TreeNode cur = deque.pollLast(); // 栈
            if (cur.left != null) {
                deque.offerLast(cur.left);
            }
            if (cur.right != null) {
                deque.offerLast(cur.right);
            }
            // 交换
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
