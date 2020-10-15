package ltd.ryantech.stack.largestRectangleInHistogram84;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.largestRectangleInHistogram84
 * @description 84. 柱状图中最大的矩形
 * @leetcode_CN_url // https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @hard_level Hard
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/15 14:34
 **/

public class Solution2 {
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
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int curHeight = heights[stack.pollLast()];
                // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                area = Math.max(area, curWidth * curHeight);
            }

            stack.offerLast(i);
        } // end of for

        // 遍历完成，但是栈中可能还有元素，套用上面的思路，继续处理
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];

            // 栈中存在相同的元素，将新栈顶的元素，即相同的元素弹出
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }

            int curWeight;
            if (stack.isEmpty()) { // 遍历完成后，且弹栈结束后，栈为空，那么此时，该位置一定可以向左向右延申到底
                curWeight = len;
            } else {
                curWeight = len - stack.peekLast() - 1; // 栈不为空，此时，元素可以向右延申到底，向左最多延申到栈顶元素位置
            }

            area = Math.max(area, curWeight * curHeight);
        }

        return area;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.largestRectangleArea(heights));
    }
}
