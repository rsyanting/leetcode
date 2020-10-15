package ltd.ryantech.stack.largestRectangleInHistogram84;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.largestRectangleInHistogram84
 * @description 84. 柱状图中最大的矩形
 * @leetcode_CN_url // https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @hard_level Hard
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/13 22:21
 **/

public class Solution1 {
    // 暴力解法
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            // 向左寻找
            int left = i;
            int curHeight = heights[i];

            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }

            // 向右寻找
            int right = i;
            while (right < (len - 1) && heights[right + 1] >= curHeight) {
                right++;
            }

            res = Math.max(res, (right - left + 1) * curHeight);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.largestRectangleArea(heights));
    }
}
