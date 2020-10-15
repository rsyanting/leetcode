package ltd.ryantech.stack.trappingRainWater42;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.trappingRainWater42
 * @description 42. 接雨水
 * @leetcode_CN_url // https://leetcode-cn.com/problems/trapping-rain-water/
 * @hard_level Hard
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/15 16:57
 **/

public class Solution1 {
    // 暴力解法
    public int trap(int[] height) {
        int res = 0;
        int len = height.length;

        if (len < 3) {
            return 0;
        }

        for (int i = 1; i < len - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }

            for (int j = i; j < len; j++) {
                max_right = Math.max(max_right, height[j]);
            }

            res += Math.min(max_left, max_right) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.trap(heights));
    }
}
