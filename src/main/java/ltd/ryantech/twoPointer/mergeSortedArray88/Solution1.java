package ltd.ryantech.twoPointer.mergeSortedArray88;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.mergeSortedArray88
 * @description 合并两个有序数组
 * @leetcode_CN_url // https://leetcode-cn.com/problems/merge-sorted-array/
 * @leetcode_US_url // https://leetcode.com/problems/merge-sorted-array/
 * @hard_level Easy
 * @tag Two Pointer // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/05/24 10:48
 **/

public class Solution1 {
    /**
     * @param nums1 数组 1
     * @param m     nums1 中的元素个数
     * @param nums2 数组 2
     * @param n     nums2 中的元素个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0 || n <= 0 || nums1.length == m) {
            return;
        }

        // 第一个卡点：数据搬迁
        // 首先将 nums1 中的元素移动向后移动
        // 使得 nums1 前面的 m 个数字成为“脏数据”
        for (int i = n + m - 1, j = m - 1; j >= 0; j--) {
            nums1[i] = nums1[j];
            i--;
        }

        int nums2Index = 0;
        int nums1Index = n;
        int index = 0;
        while (nums2Index < n && nums1Index < m + n) {
            // nums1 中元素较小
            if (nums1[nums1Index] <= nums2[nums2Index]) {
                nums1[index] = nums1[nums1Index];
                index++;
                nums1Index++;
            } else {
                nums1[index] = nums2[nums2Index];
                index++;
                nums2Index++;
            }
        }
        // nums2 中还有剩余元素
        if (nums2Index < n) {
            for (int i = nums2Index; i < n; i++) {
                nums1[index] = nums2[i];
                index++;
            }
        } else {
            for (int i = nums1Index; i < m + n; i++) {
                nums1[index] = nums1[i];
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5, 6, 0};
        int[] nums2 = {3};
        new Solution1().merge(nums1, 5, nums2, 1);
        int[] nums3 = {1, 2, 3, 0, 0, 0, 0, 0};
        int[] nums4 = {2, 5, 6};
        new Solution1().merge(nums3, 3, nums4, 3);
        System.out.println();
    }
}
