package ltd.ryantech.dynamicProgramming.maximumProductSubarray152;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.dynamicProgramming.maximumProductSubarray152
 * @description 乘积最大子数组
 * @leetcode_CN_url // https://leetcode-cn.com/problems/maximum-product-subarray/
 * @leetcode_US_url // https://leetcode.com/problems/maximum-product-subarray/
 * @hard_level Medium
 * @tag Dynamic Programming // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/05/18 14:12
 **/

public class Solution2 {
    // DP 未优化版
    public int maxProduct(int[] nums) {
        int[] maxPrefix = new int[nums.length + 1];
        int[] minPrefix = new int[nums.length + 1];
        maxPrefix[0] = 1;
        minPrefix[0] = 1;
        int res = Integer.MIN_VALUE;
        int t;
        for (int i = 0; i < nums.length; i++) {
            maxPrefix[i + 1] = Math.max(Math.max(maxPrefix[i] * nums[i], nums[i]), minPrefix[i] * nums[i]);
            minPrefix[i + 1] = Math.min(Math.min(minPrefix[i] * nums[i], nums[i]), maxPrefix[i] * nums[i]);
            t = res;
            res = Math.max(maxPrefix[i + 1], minPrefix[i + 1]);
            res = Math.max(t, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new Solution2().maxProduct(nums));
        // 运行错误
        int[] nums2 = {-2, 3, -4};
        System.out.println(new Solution2().maxProduct(nums2));
        int[] nums3 = {-2, 3, -4, 9, -9, 0, 8, 0};
        System.out.println(new Solution2().maxProduct(nums3));
        int[] nums4 = {0, 2};
        System.out.println(new Solution2().maxProduct(nums4));
    }
}
