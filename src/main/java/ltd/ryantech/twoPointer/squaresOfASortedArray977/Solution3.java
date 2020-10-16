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
 * @create 2020/10/16 11:39
 **/

public class Solution3 {
    // 双指针法
    // 指针相遇处理结束
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int left = 0, right = len - 1;
        int idx = len - 1;
        while (left <= right) {
            if (Math.abs(A[left]) <= Math.abs(A[right])) {
                res[idx] = (int) Math.pow(Math.abs(A[right]), 2);
                right--;
            } else {
                res[idx] = (int) Math.pow(Math.abs(A[left]), 2);
                left++;
            }
            idx--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] res = new Solution3().sortedSquares(nums);
        System.out.println(Arrays.toString(res));
    }
}
