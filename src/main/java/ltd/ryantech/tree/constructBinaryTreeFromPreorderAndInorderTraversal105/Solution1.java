package ltd.ryantech.tree.constructBinaryTreeFromPreorderAndInorderTraversal105;

import ltd.ryantech.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.constructBinaryTreeFromPreorderAndInorderTraversal105
 * @description 105. 从前序与中序遍历序列构造二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @leetcode_US_url // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/02 20:36
 **/

public class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preorder.length; // 树中的节点数量与遍历方式无关
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, length - 1,
                inorder, 0, length - 1,
                indexMap);
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
                              int[] inorder, int inorderStart, int inorderEnd,
                              Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            // 递归结束情形 1 : 先序遍历的开始范围大于结束范围，此时表示二叉树中没有节点
            return null;
        }

        int rootVal = preorder[preorderStart]; // 先序遍历的情况下，第一个 index 处为根节点
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = indexMap.get(rootVal);
        int leftNodes = rootIndex - inorderStart;
        int rightNodes = inorderEnd - rootIndex;
        // 左右子树的构建
        // 注意先序和中序的下标位置
        root.left = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes,
                inorder, inorderStart, rootIndex - 1,
                indexMap);
        root.right = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd,
                inorder, rootIndex + 1, inorderEnd,
                indexMap);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new Solution1().buildTree(preorder, inorder);
    }
}
