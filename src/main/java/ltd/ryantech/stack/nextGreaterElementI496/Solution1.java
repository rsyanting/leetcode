package ltd.ryantech.stack.nextGreaterElementI496;

import java.util.Arrays;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.nextGreaterElementI496
 * @description 496. 下一个更大元素 I
 * @leetcode_CN_url // https://leetcode-cn.com/problems/next-greater-element-i/
 * @hard_level Easy
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/13 14:22
 **/

public class Solution1 {
    // 暴力法
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (target == nums2[j]) {
                    for (int k = j; k < nums2.length; k++) {
                        if (target < nums2[k]) {
                            res[i] = nums2[k];
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] res = new Solution1().nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
