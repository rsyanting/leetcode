package ltd.ryantech.tree.flatten114;

import ltd.ryantech.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.flatten114
 * @description 114. 二叉树展开为链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @leetcode_US_url // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/08/02 14:19
 **/

public class Solution3 {
    // 对 后序遍历 的变形的 迭代写法
    private TreeNode dummy = null;

    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.offerLast(cur); // 添加根节点
                cur = cur.right; // 递归添加右节点
            }
            cur = stack.peekLast(); // 已经访问到最右的节点了
            // 在不存在左节点或者右节点已经访问过的情况下，访问根节点
            if (cur.left == null || cur.left == pre) {
                stack.pollLast();
                /**************修改的地方***************/
                cur.right = pre;
                cur.left = null;
                /*************************************/
                pre = cur;
                cur = null;
            } else {
                cur = cur.left; // 左节点还没有访问过就先访问左节点
            }
        }
    }


    public void print() {
        while (dummy != null) {
            System.out.println(dummy.val);
            dummy = dummy.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Solution3 solution3 = new Solution3();
        solution3.dummy = root;
        solution3.flatten(root);
        solution3.print();
    }
}
