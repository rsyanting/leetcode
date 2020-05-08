package ltd.ryantech.tree.validateBinarySearchTree98;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech
 * @description leetcode TreeNode 定义
 * @leetcode_Tag https://leetcode.com/tag/tree/
 * @create 2020/05/05 14:25
 **/

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

