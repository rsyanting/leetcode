package ltd.ryantech.tree.constructBinaryTreeFromInorderAndPostorderTraversal106;

import ltd.ryantech.tree.TreeNode;

import java.util.HashMap;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.constructBinaryTreeFromInorderAndPostorderTraversal106
 * @description 106. 从中序与后序遍历序列构造二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @leetcode_US_url // https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/02 21:10
 **/

public class Solution1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int inLen = inorder.length;
        int poLen = postorder.length;
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inLen - 1, postorder, 0, poLen - 1, inorderMap);
    }

    public TreeNode buildTree(int[] inorder, int inLeft, int inRight, int[] postorder, int poLeft, int poRight, HashMap<Integer, Integer> inorderMap) {
        if (inLeft > inRight || poLeft > poRight) {
            return null;
        }
        // 使用 HashMap 来保存 inorder 序列的 index 信息，快速查找到 rootIndex
        int rootIndex = inorderMap.get(postorder[poRight]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 左子树节点数
        int leftNodes = (rootIndex - 1) - inLeft;
        // 右子树节点数
        int rightNodes = inRight - (rootIndex + 1);
        // 左子树在 inorder 中的区间为 [inLeft, inLeft + leftNodes]
        root.left = buildTree(inorder, inLeft, inLeft + leftNodes, postorder, poLeft, poLeft + leftNodes, inorderMap);
        root.right = buildTree(inorder, rootIndex + 1, rootIndex + 1 + rightNodes, postorder, poRight - 1 - rightNodes, poRight - 1, inorderMap);
//        root.left = buildTree(inorder, inLeft, rootIndex - 1, postorder, poLeft, poRight - 1 - (inRight - rootIndex), inorderMap);
//        root.right = buildTree(inorder, rootIndex + 1, inRight, postorder, poRight - (inRight - rootIndex), poRight - 1, inorderMap);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = new Solution1().buildTree(inorder, postorder);
    }
}
