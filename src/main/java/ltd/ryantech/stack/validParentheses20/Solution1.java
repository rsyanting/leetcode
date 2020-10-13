package ltd.ryantech.stack.validParentheses20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.validParentheses20
 * @description 20. 有效的括号
 * @leetcode_CN_url // https://leetcode-cn.com/problems/valid-parentheses/
 * @leetcode_US_url // https://leetcode.com/problems/valid-parentheses/
 * @hard_level Easy
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/09/30 15:25
 **/

public class Solution1 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        // 添加 “括号” 对
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) { // 遇到左括号，压入栈中
                stack.offerLast(c);
            } else if (stack.isEmpty() || c != map.get(stack.peekLast())) { // 遇到非左的，进行匹配操作，不匹配的返回 false
                return false;
            } else {
                stack.pollLast(); // 匹配，则弹出当前的栈顶，表示匹配成功
            }
        }

        return stack.isEmpty(); // 最后检查栈是否空，为空说明匹配成功
    }

    @Test
    public void testIsValid() {
        Assertions.assertTrue(isValid("()"));
        Assertions.assertTrue(isValid("()[]{}"));
        Assertions.assertFalse(isValid("(]"));
        Assertions.assertFalse(isValid("([)]"));
        Assertions.assertTrue(isValid("{[]}"));
    }
}
