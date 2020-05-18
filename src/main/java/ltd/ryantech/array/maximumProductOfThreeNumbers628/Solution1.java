package ltd.ryantech.array.maximumProductOfThreeNumbers628;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.maximumProductOfThreeNumbers628
 * @description 三个数的最大乘积
 * @leetcode_CN_url // https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * @leetcode_US_url // https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * @hard_level Medium
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/05/18 16:51
 **/

public class Solution1 {
    public int maximumProduct(int[] nums) {
        // 找出最大的 3 个正数和最小的 2 个负数 即可
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // min1 是最小的数
            if (nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] <= min2) {
                min2 = nums[i];
            }
            // max1 是最大的数字
            if (nums[i] >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] >= max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] >= max3) {
                max3 = nums[i];
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Solution1().maximumProduct(nums));
    }
}
