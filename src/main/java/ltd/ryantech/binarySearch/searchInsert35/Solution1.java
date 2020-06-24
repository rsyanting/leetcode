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
 * @create 2020/06/21 15:10
 **/

public class Solution1 {
    // 经典 “三分式” 两分搜索
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new Solution1().searchInsert(nums, 5));

        int[] nums1 = {1, 3, 5, 6};
        System.out.println(new Solution1().searchInsert(nums1, 2));
    }
}
