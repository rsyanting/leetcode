package ltd.ryantech.stack.dailyTemperatures739;

import java.util.Arrays;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.dailyTemperatures739
 * @description 739. 每日温度
 * @leetcode_CN_url // https://leetcode-cn.com/problems/daily-temperatures/
 * @hard_level Medium
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/13 13:28
 **/

public class Solution3 {
    // 暴力解法，时间复杂度 O(n * m)
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        // 反向遍历 气温 数组
        for (int i = length - 1; i >= 0; --i) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; ++t) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }

            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }
            next[T[i]] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};

        Solution3 solution3 = new Solution3();

        int[] res = solution3.dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }
}
