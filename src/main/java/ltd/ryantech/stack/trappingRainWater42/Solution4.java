package ltd.ryantech.stack.trappingRainWater42;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.trappingRainWater42
 * @description 42. 接雨水
 * @leetcode_CN_url // https://leetcode-cn.com/problems/trapping-rain-water/
 * @hard_level Hard
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/15 20:39
 **/

public class Solution4 {
    // 双指针 思路
    // 从 动态规划 思想延展开来
    public int trap(int[] height) {
        int res = 0;
        int len = height.length;

        // 特判，如果小于 3 个高度，那么没办法存储雨水
        if (len < 3) {
            return 0;
        }

        int left_max = 0, right_max = 0;
        int left = 0, right = len - 1; // 数组的下标范围
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    res += left_max - height[left]; // 此处可以积水，计算积水量
                }
                left++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    res += right_max - height[right]; // 此处可以积水，计算积水量
                }
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.trap(heights));
    }
}
