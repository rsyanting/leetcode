package ltd.ryantech.array.maximumProductOfThreeNumbers628;

import sun.security.util.Length;

import java.util.Arrays;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.maximumProductOfThreeNumbers628
 * @description 三个数的最大乘积
 * @leetcode_CN_url // https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * @leetcode_US_url // https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * @hard_level Medium
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/05/18 20:40
 **/

public class Solution3 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Solution3().maximumProduct(nums));
    }
}
