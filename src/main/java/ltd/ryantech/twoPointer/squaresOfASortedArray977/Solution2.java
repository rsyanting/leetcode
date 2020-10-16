package ltd.ryantech.twoPointer.squaresOfASortedArray977;

import java.util.Arrays;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.squaresOfASortedArray977
 * @description 977. 有序数组的平方
 * @leetcode_CN_url // https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @hard_level Easy
 * @tag Two Pointer // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/10/16 11:12
 **/

public class Solution2 {
    // 双指针法
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int pivotIndex = 0;
        while (pivotIndex < len && A[pivotIndex] < 0) {
            pivotIndex++;
        }
        // 结束循环后，pivotIndex 所指向的位置，其元素值大于等于 0
        int left = pivotIndex - 1, right = pivotIndex;
        int idx = 0;
        while (left >= 0 && right < len) {
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                res[idx] = (int) Math.pow(Math.abs(A[right]), 2);
                right++;
            } else {
                res[idx] = (int) Math.pow(Math.abs(A[left]), 2);
                left--;
            }
            idx++;
        }

        while (left >= 0) {
            res[idx] = (int) Math.pow(Math.abs(A[left]), 2);
            left--;
            idx++;
        }

        while (right < len) {
            res[idx] = (int) Math.pow(Math.abs(A[right]), 2);
            right++;
            idx++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] res = new Solution2().sortedSquares(nums);
        System.out.println(Arrays.toString(res));
    }
}
