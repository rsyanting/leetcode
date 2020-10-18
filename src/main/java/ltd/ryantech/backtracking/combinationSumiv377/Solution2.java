package ltd.ryantech.backtracking.combinationSumiv377;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.backtracking.combinationSumiv377
 * @description 377. 组合总和 Ⅳ
 * @leetcode_CN_url // https://leetcode-cn.com/problems/combination-sum-iv/
 * @hard_level Medium
 * @tag Back Tracking // https://leetcode-cn.com/tag/backtracking/
 * @create 2020/10/18 16:35
 **/

public class Solution2 {
    // 动态规划
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // 这个值被其它状态参考，设置为 1 是合理的
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int res = new Solution2().combinationSum4(nums, 4);
        System.out.println(res);

        int[] nums1 = {1, 2, 4};
        int res2 = new Solution2().combinationSum4(nums1, 32);
        System.out.println(res2);
    }
}
