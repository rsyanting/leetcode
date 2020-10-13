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
 * @create 2020/10/13 12:39
 **/

public class Solution1 {
    // 暴力解法，时间复杂度 O(n ^ 2)
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        int len = T.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};

        Solution1 solution1 = new Solution1();

        int[] res = solution1.dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }
}
