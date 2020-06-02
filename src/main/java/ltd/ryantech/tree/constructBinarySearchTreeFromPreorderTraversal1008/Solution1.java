package ltd.ryantech.tree.constructBinarySearchTreeFromPreorderTraversal1008;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.constructBinarySearchTreeFromPreorderTraversal1008
 * @description 先序遍历构造二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * @leetcode_US_url // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/05/24 16:06
 **/

public class Solution1 {
    //
    public TreeNode bstFromPreorder(int[] preorder) {
        int rootIdx = preorder[0];
        int leftBegin = 1;
        int rightBegin = 1;
        TreeNode root = new TreeNode(preorder[rootIdx]);
        if (preorder.length == 1) {
            return root;
        } else {
            // 有左子树的情况
            if (preorder[leftBegin] < preorder[rootIdx]) {
                int leftEnd = leftBegin;
                while (leftEnd < preorder.length && preorder[leftEnd] < preorder[rootIdx]) {
                    leftEnd++;
                }
                // 无左子树的情况
            } else if (preorder[leftBegin] > preorder[rootIdx]) {
                rightBegin = leftBegin;
                int rightEnd = preorder.length - 1;
            }
        }
        TreeNode left = helper();
        TreeNode right = helper();
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode helper() {
        return null;
    }

    public static void main(String[] args) {

    }
}
