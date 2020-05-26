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
 * @create 2020/05/26 13:18
 **/

public class Solution2 {
    // 两分查找法
    // 时间复杂度 O(n * log n)
    // 空间复杂度 O(1)
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int left = 0, right = length - 1;

        while (left < right) {
            int cnt = 0;
            int mid = left + (right - left + 1) / 2; // 加 1 是为了避免出现死循环
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left, mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println(new Solution2().findDuplicate(nums1));
    }
}
