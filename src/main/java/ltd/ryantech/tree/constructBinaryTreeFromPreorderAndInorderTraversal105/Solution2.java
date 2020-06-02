package ltd.ryantech.tree.constructBinaryTreeFromPreorderAndInorderTraversal105;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.constructBinaryTreeFromPreorderAndInorderTraversal105
 * @description 105. 从前序与中序遍历序列构造二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @leetcode_US_url // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/02 20:47
 **/


// leetcode-cn liweiweil1419 的题解
public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("Incorrect input data.");
        }
        return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }


    /**
     * 使用数组 preorder 在索引区间 [preLeft, preRight] 中的所有元素
     * 和数组 inorder 在索引区间 [inLeft, inRight] 中的所有元素构造二叉树
     *
     * @param preorder 二叉树前序遍历结果
     * @param preLeft  二叉树前序遍历结果的左边界
     * @param preRight 二叉树前序遍历结果的右边界
     * @param inorder  二叉树后序遍历结果
     * @param inLeft   二叉树后序遍历结果的左边界
     * @param inRight  二叉树后序遍历结果的右边界
     * @return 二叉树的根结点
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        // 因为是递归调用的方法，按照国际惯例，先写递归终止条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 先序遍历的起点元素很重要
        // pivot 中枢；枢纽
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = inLeft;
        // 严格上说还要做数组下标是否越界的判断 pivotIndex < inRight
        while (inorder[pivotIndex] != pivot) {
            pivotIndex++;
        }
        root.left = buildTree(preorder, preLeft + 1, pivotIndex - inLeft + preLeft,
                inorder, inLeft, pivotIndex - 1);
        root.right = buildTree(preorder, pivotIndex - inLeft + preLeft + 1, preRight,
                inorder, pivotIndex + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new Solution2().buildTree(preorder, inorder);
    }
}
