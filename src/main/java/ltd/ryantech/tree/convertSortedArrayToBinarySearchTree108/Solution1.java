package ltd.ryantech.tree.convertSortedArrayToBinarySearchTree108;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.tree.convertSortedArrayToBinarySearchTree108
 * @description 108. 将有序数组转换为二叉搜索树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @leetcode_US_url // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/07/03 17:25
 **/

public class Solution1 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }


    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = new Solution1().sortedArrayToBST(nums);
        System.out.println(root.val);
    }
}
