package ltd.ryantech.array.threeSumClosest16;

import java.util.Arrays;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.threeSumClosest16
 * @description 16. 最接近的三数之和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/3sum-closest/
 * @leetcode_US_url // https://leetcode.com/problems/3sum-closest/
 * @hard_level Medium
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/06/24 14:11
 **/

public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];
        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int left = k + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum; // 更新最小距离
                }
                if (sum > target) {
                    right--; // 需要更小的 sum
                } else if (sum < target) {
                    left++; // 需要更大的 sum
                } else {
                    return ans; // 严格相等，返回
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        int res = new Solution1().threeSumClosest(nums, 1);
        System.out.println(res);
    }
}
