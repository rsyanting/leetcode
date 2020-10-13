package ltd.ryantech.array.firstMissingPositive41;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.firstMissingPositive41
 * @description 41. 缺失的第一个正数
 * @leetcode_CN_url // https://leetcode-cn.com/problems/first-missing-positive/
 * @leetcode_US_url // https://leetcode.com/problems/first-missing-positive/
 * @hard_level Hard
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/10/11 21:16
 **/

public class Solution1 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] >= 1 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0;i < len;i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return len + 1;
    }

    private void swap(int[] nums, int i, int k) {
        int t = nums[i];
        nums[i] = nums[k];
        nums[k] = t;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(new Solution1().firstMissingPositive(nums));
    }
}
