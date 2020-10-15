package ltd.ryantech.stack.largestRectangleInHistogram84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.largestRectangleInHistogram84
 * @description 84. 柱状图中最大的矩形
 * @leetcode_CN_url // https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @hard_level Hard
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/15 14:43
 **/

public class Solution3 {
    // 哨兵思想
    // 使用栈作为辅助
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }


        int area = 0;
        // 新数组的 头部 和 尾部，元素均设置为 0
        int[] newHeight = new int[len + 2];
        System.arraycopy(heights, 0, newHeight, 1, len);
        len += 2;
        heights = newHeight;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(0);

        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.pollLast()];
                int width = i - stack.peekLast() - 1; // 栈非空
                area = Math.max(area, width * height);
            }
            stack.offerLast(i);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.largestRectangleArea(heights));
    }
}
