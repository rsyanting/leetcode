package ltd.ryantech.binarySearch.findTheDuplicateNumber287;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.binarySearch.findTheDuplicateNumber287
 * @description 寻找重复数
 * @leetcode_CN_url // https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @leetcode_US_url // https://leetcode.com/problems/find-the-duplicate-number/
 * @hard_level Medium
 * @tag Binary Search // https://leetcode-cn.com/tag/binary-search/
 * @create 2020/05/26 11:29
 **/

public class Solution1 {
    // 额外开一个数组，检查是否某个数字出现重复
    // 空间复杂度不达标
    public int findDuplicate(int[] nums) {
        int[] ans = new int[nums.length];
        for (int num : nums) {
            if (ans[num] == 0) {
                ans[num]++;
            } else {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println(new Solution1().findDuplicate(nums1));
    }
}
