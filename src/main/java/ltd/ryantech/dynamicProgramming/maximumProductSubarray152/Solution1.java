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
 * @create 2020/05/18 14:05
 **/

public class Solution1 {
    // 前缀积
    // 未考虑负数情况
    public int maxProduct(int[] nums) {
        int[] maxPrefix = new int[nums.length + 1];
        maxPrefix[0] = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxPrefix[i + 1] = Math.max(maxPrefix[i] * nums[i], nums[i]);
            res = Math.max(maxPrefix[i + 1], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new Solution1().maxProduct(nums));
        // 运行错误
        int[] nums2 = {-2, 3, -4};
        System.out.println(new Solution1().maxProduct(nums2));
    }
}
