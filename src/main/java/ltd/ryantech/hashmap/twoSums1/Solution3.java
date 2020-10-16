package ltd.ryantech.hashmap.twoSums1;

import java.util.Arrays;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.hashmap.twoSums1
 * @description 1. 两数之和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/two-sum/
 * @leetcode_US_url // https://leetcode.com/problems/two-sum/
 * @hard_level Easy
 * @tag HashMap // https://leetcode-cn.com/tag/hash-table/
 * @create 2020/10/16 16:42
 **/

public class Solution3 {
    // 在不考虑 index
    // 仅仅返回 元素值 的情况下
    public static int[] twoSum(int[] nums, long target) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                ans[0] = left;
                ans[1] = right;
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int limit = 200000;
        int[] nums = new int[limit];
        for (int i = 0; i < limit; i++) {
            nums[i] = i;
        }
        long target = (limit - 2) * 2 + 1;
        int[] ans;
        long startTime = System.currentTimeMillis();
        ans = twoSum(nums, target);
        long endTime = System.currentTimeMillis();
        System.out.println("Time used is : " + (endTime - startTime));
        System.out.println(ans[0] + " " + ans[1]);

    }
}
