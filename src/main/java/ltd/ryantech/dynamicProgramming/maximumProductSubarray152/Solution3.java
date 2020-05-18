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
 * @create 2020/05/18 14:46
 **/

public class Solution3 {
    // DP 优化版
    public int maxProduct(int[] nums) {
        int preMaxPrefix = 1;
        int preMinPrefix = 1;
        int res = Integer.MIN_VALUE;
        int t;
        int curPreMaxPrefix;
        int curPreMinPrefix;
        for (int i = 0; i < nums.length; i++) {
            curPreMaxPrefix = Math.max(Math.max(preMaxPrefix * nums[i], nums[i]), preMinPrefix * nums[i]);
            curPreMinPrefix = Math.min(Math.min(preMinPrefix * nums[i], nums[i]), preMaxPrefix * nums[i]);
            t = res;
            res = Math.max(curPreMaxPrefix, curPreMinPrefix);
            res = Math.max(t, res);
            preMaxPrefix = curPreMaxPrefix;
            preMinPrefix = curPreMinPrefix;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new Solution3().maxProduct(nums));
        // 运行错误
        int[] nums2 = {-2, 3, -4};
        System.out.println(new Solution3().maxProduct(nums2));
        int[] nums3 = {-2, 3, -4, 9, -9, 0, 8, 0};
        System.out.println(new Solution3().maxProduct(nums3));
        int[] nums4 = {0, 2};
        System.out.println(new Solution3().maxProduct(nums4));
    }
}
