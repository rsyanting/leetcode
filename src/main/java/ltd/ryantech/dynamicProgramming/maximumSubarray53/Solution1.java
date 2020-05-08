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
 * @create 2020/05/05 13:42
 **/

public class Solution1 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];

        if (n > 1) {
            for (int i = 1; i < n; i++) {
                // dp[] 为以 i 结尾的子序列的最大值
                dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
                maxSum = Math.max(dp[i], maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = new Solution1().maxSubArray(nums);
        System.out.println(res);
    }
}
