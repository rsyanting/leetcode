package ltd.ryantech.stack.dailyTemperatures739;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.dailyTemperatures739
 * @description 739. 每日温度
 * @leetcode_CN_url // https://leetcode-cn.com/problems/daily-temperatures/
 * @hard_level Medium
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/13 12:45
 **/

public class Solution2 {
    // 单调栈 解法
    // 时间复杂度 O(n) ，每个元素最多有 1 次进栈和出栈的机会
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        int len = T.length;
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            int t = T[i];
            while (!stack.isEmpty() && t > T[stack.peekLast()]) {
                int prevIndex = stack.pollLast();
                res[prevIndex] = i - prevIndex;
            }
            stack.offerLast(i); // 栈中存储的是 index 下标
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};

        Solution2 solution2 = new Solution2();

        int[] res = solution2.dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }
}
