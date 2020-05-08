package ltd.ryantech.dynamicProgramming.maximumSubarray53;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.dynamicProgramming.maximumSubarray53
 * @description 最大子序和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/maximum-subarray/
 * @leetcode_US_url // https://leetcode.com/problems/maximum-subarray/
 * @hard_level Easy
 * @tag Dynamic Programming
 * @create 2020/05/05 13:59
 **/

public class Solution2 {
    // 空间复杂度优化版
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int prev = nums[0];
        int cur = nums[0];
        int maxSum = nums[0];
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                cur = nums[i] + (Math.max(prev, 0));
                prev = cur;
                maxSum = Math.max(cur, maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = new Solution2().maxSubArray(nums);
        System.out.println(res);
    }
}
