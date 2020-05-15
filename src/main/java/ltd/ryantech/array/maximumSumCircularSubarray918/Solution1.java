package ltd.ryantech.array.maximumSumCircularSubarray918;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.maximumSumCircularSubarray918
 * @description 环形子数组的最大和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/maximum-sum-circular-subarray/
 * @leetcode_US_url // https://leetcode-cn.com/problems/maximum-sum-circular-subarray/
 * @hard_level Medium
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/05/15 15:45
 **/

/**
 * 类似问题有 求最大数组之和
 */
public class Solution1 {
    public int maxSubarraySumCircular(int[] A) {
        int res = 0;
        int temp = 0;
        int subarrayMax = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            temp = Math.max(A[i], temp + A[i]);
            subarrayMax = Math.max(subarrayMax, temp);
        }

        return subarrayMax;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, -2, 3, -2};
        System.out.println(new Solution1().maxSubarraySumCircular(nums1));
        int[] nums2 = {5, -3, 5};
        System.out.println(new Solution1().maxSubarraySumCircular(nums2));
    }
}
