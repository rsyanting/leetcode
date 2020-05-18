package ltd.ryantech.twoPointer.subarrayProductLessThanK713;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.subarrayProductLessThanK713
 * @description 乘积小于 K 的子数组
 * @leetcode_CN_url // https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * @leetcode_US_url // https://leetcode.com/problems/subarray-product-less-than-k/
 * @hard_level Medium
 * @tag Two Pointer // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/05/18 16:26
 **/

public class Solution1 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 非常特殊的边界条件 特判
        if (k <= 1) {
            return 0;
        }
        int left = 0;
        int res = 0;
        int mul = 1;
        for (int right = 0; right < nums.length; right++) {
            mul *= nums[right];
            // 找到满足的最左 left
            while (mul >= k) {
                mul = mul / nums[left];
                left++;
            }
            // 避免重复计算
            res += right - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        System.out.println(new Solution1().numSubarrayProductLessThanK(nums, 100));
    }
}
