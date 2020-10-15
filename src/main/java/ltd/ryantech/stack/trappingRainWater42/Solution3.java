package ltd.ryantech.stack.trappingRainWater42;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.trappingRainWater42
 * @description 42. 接雨水
 * @leetcode_CN_url // https://leetcode-cn.com/problems/trapping-rain-water/
 * @hard_level Hard
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/15 19:31
 **/

public class Solution3 {
    // 递减单调栈 思路
    public int trap(int[] height) {
        int res = 0;
        int len = height.length;

        // 特判，如果小于 3 个高度，那么没办法存储雨水
        if (len < 3) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        while (idx < len) {
            while (!stack.isEmpty() && height[idx] > height[stack.peekLast()]) {
                int valley = stack.pollLast(); // 弹出当前栈顶，当前栈顶对应的 idx 处形成低洼
                if (stack.isEmpty()) {
                    break; // 如果为空，说明没有左边界来形成低洼，跳出循环即可
                }
                int width = idx - stack.peekLast() - 1; // 积水宽度
                int valley_depth = Math.min(height[idx], height[stack.peekLast()]) - height[valley];
                res += width * valley_depth;
            }
            stack.offerLast(idx++);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.trap(heights));
    }
}
