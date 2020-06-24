package ltd.ryantech.array.majorityElement169;

import java.util.Arrays;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.majorityElement169
 * @description 169. 多数元素
 * @leetcode_CN_url // https://leetcode-cn.com/problems/majority-element/
 * @leetcode_US_url // https://leetcode.com/problems/majority-element/
 * @hard_level Easy
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/06/16 11:10
 **/

public class Solution1 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int ans = new Solution1().majorityElement(nums);
        System.out.println(ans);
    }
}
