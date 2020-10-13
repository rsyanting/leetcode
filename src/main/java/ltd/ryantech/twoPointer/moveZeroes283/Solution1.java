package ltd.ryantech.twoPointer.moveZeroes283;

import org.junit.jupiter.api.Test;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.moveZeroes283
 * @description 283. 移动零
 * @leetcode_CN_url // https://leetcode-cn.com/problems/move-zeroes/
 * @leetcode_US_url // https://leetcode.com/problems/move-zeroes/
 * @hard_level Easy
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/10/05 14:49
 **/

public class Solution1 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        for (j = i; j < n; j++) {
            nums[j] = 0;
        }
    }

    @Test
    public void testMoveZeroes() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
