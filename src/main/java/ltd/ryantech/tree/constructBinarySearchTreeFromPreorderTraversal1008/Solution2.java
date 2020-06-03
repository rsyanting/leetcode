package ltd.ryantech.tree.constructBinarySearchTreeFromPreorderTraversal1008;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.constructBinarySearchTreeFromPreorderTraversal1008
 * @description 先序遍历二叉搜索树构造二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * @leetcode_US_url // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/03 15:24
 **/

public class Solution2 {
    // 分治思想 + 两分优化
    public TreeNode bstFromPreorder(int[] preorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        return buildBST(preorder, 0, length - 1);
    }

    public TreeNode buildBST(int[] preorder, int left, int right) {
        // 递归结束条件
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[left]);
        int leftPoint = left;
        int rightPoint = right;
        // 找到“谷底”
        // 重点逻辑：在区间 [left, right] 里找最后一个小于等于 preorder[left] 的下标
        // 注意这里设置区间的左边界为 left ，不能是 left + 1
        while (leftPoint < rightPoint) {
            int midPoint = leftPoint + (rightPoint - leftPoint + 1) / 2;
            if (preorder[midPoint] < preorder[left]) {
                leftPoint = midPoint;
            } else {
                rightPoint = midPoint - 1;
            }
        }
        root.left = buildBST(preorder, left + 1, leftPoint);
        root.right = buildBST(preorder, leftPoint + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = new Solution2().bstFromPreorder(preorder);
    }
}
