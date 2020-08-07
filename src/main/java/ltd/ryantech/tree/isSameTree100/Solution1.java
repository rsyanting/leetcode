package ltd.ryantech.tree.isSameTree100;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.isSameTree100
 * @description 100. 相同的树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/same-tree/
 * @leetcode_US_url // https://leetcode.com/problems/same-tree/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/08/07 14:20
 **/

public class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 都为空的话，显然相同
        if (p == null && q == null) {
            return true;
        }
        // 一个为空，一个非空，显然不同
        if (p == null || q == null) {
            return false;
        }
        // 两个都非空，但 val 不一样也不行
        if (q.val != p.val) {
            return false;
        }
        // 子树，递归的调用进行判断
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println(new Solution1().isSameTree(root1, root2));
    }


}
