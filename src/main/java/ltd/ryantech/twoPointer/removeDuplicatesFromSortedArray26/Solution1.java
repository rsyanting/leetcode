package ltd.ryantech.twoPointer.removeDuplicatesFromSortedArray26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.removeDuplicatesFromSortedArray26
 * @description 26. 删除排序数组中的重复项
 * @leetcode_CN_url // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @leetcode_US_url // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @hard_level Easy
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/10/04 17:17
 **/

public class Solution1 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }

        if (nums.length <= 1) {
            return 1;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }

        // 数组长度为索引 + 1
        return slow + 1;
    }

    @Test
    public void testRemoveDuplicates() {
        Assertions.assertEquals(2, removeDuplicates(new int[]{1, 1, 2}));
        Assertions.assertEquals(5, removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
