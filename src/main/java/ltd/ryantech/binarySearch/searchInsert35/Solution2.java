package ltd.ryantech.binarySearch.searchInsert35;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.binarySearch.searchInsert35
 * @description 35. 搜索插入位置
 * @leetcode_CN_url // https://leetcode-cn.com/problems/search-insert-position/
 * @leetcode_US_url // https://leetcode.com/problems/search-insert-position/
 * @hard_level Easy
 * @tag Binary Search // https://leetcode-cn.com/tag/binary-search/
 * @create 2020/06/21 16:22
 **/

public class Solution2 {
    // “排除法” 版 两分搜索
    public int searchInsert(int[] nums, int target) {
        // 特判
        if (nums.length == 0) {
            return 0;
        } else if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int left = 0;
        int right = nums.length - 1;
        // 循环结束时有 left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 严格小于 target 的元素一定不是解
            if (nums[mid] < target) {
                // 下一轮搜索区间是 [mid + 1,right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new Solution2().searchInsert(nums, 5));

        int[] nums1 = {1, 3, 5, 6};
        System.out.println(new Solution2().searchInsert(nums1, 2));
    }
}
