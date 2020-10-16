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
 * @create 2020/10/16 11:08
 **/

public class Solution1 {
    // 暴力排序
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) Math.pow(A[i], 2);
        }
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] res = new Solution1().sortedSquares(nums);
        System.out.println(Arrays.toString(res));
    }
}
