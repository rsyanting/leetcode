package ltd.ryantech.stack.trappingRainWater42;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.trappingRainWater42
 * @description 42. 接雨水
 * @leetcode_CN_url // https://leetcode-cn.com/problems/trapping-rain-water/
 * @hard_level Hard
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/15 19:16
 **/

public class Solution2 {
    // 提前存储好 max_left 和 max_right
    public int trap(int[] height) {
        int res = 0;
        int len = height.length;

        // 特判，如果小于 3 个高度，那么没办法存储雨水
        if (len < 3) {
            return 0;
        }

        int[] max_left_arr = new int[len];
        int[] max_right_arr = new int[len];
        max_left_arr[0] = height[0];
        max_right_arr[len - 1] = height[len - 1];

        for (int i = 1; i < len; i++) {
            max_left_arr[i] = Math.max(max_left_arr[i - 1], height[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            max_right_arr[i] = Math.max(max_right_arr[i + 1], height[i]);
        }

        for (int i = 0; i < len; i++) {
            res += Math.min(max_left_arr[i], max_right_arr[i]) - height[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.trap(heights));
    }
}
