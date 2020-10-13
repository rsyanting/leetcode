package ltd.ryantech.stack.minimumAddToMakeParenthesesValid921;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.minimumAddToMakeParenthesesValid921
 * @description 921. 使括号有效的最少添加
 * @leetcode_CN_url // https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/
 * @leetcode_US_url // https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 * @hard_level Medium
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/09/30 15:42
 **/

public class Solution1 {

    // 以左括号为基准
    // 通过维护对右括号的需求数need，来计算最小的插入次数。
    public int minAddToMakeValid(String S) {
        int need = 0;
        int res = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') { // 遇见一个左括号，那么需要一个右括号来平衡
                need++;
            }

            if (c == ')') {
                need--; // 遇见了一个右括号，那么减去一个“预定”的右括号

                if (need < 0) { // 右括号多了，失衡，需要补充左括号
                    need = 0; // 注意将右括号数量进行 重置
                    res++;
                }
            }
        }

        return res + need; // 最终需要 res 个左括号 和 need 个右括号
    }

    @Test
    public void testMinAddToMakeValid() {
        Assertions.assertEquals(1, minAddToMakeValid("())"));
        Assertions.assertEquals(3, minAddToMakeValid("((("));
        Assertions.assertEquals(0, minAddToMakeValid("()"));
        Assertions.assertEquals(4, minAddToMakeValid("()))(("));
    }
}
