package ltd.ryantech.stack.removeAllAdjacentDuplicatesInString1047;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.removeAllAdjacentDuplicatesInString1047
 * @description 1047. 删除字符串中的所有相邻重复项
 * @leetcode_CN_url // https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * @hard_level Easy
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/16 22:07
 **/

public class Solution2 {
    // 使用 队列 辅助操作
    public String removeDuplicates(String S) {
        Deque<Character> deque = new ArrayDeque<>();

        int i = 0;
        int len = S.length();
        StringBuilder sb = new StringBuilder();

        for (i = 0; i < len; i++) {
            if (deque.isEmpty() || deque.peekLast() != S.charAt(i)) {
                deque.offerLast(S.charAt(i));
            } else {
                deque.pollLast();
            }
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst()); // 出队，最后不需要转置
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new String("abbaca");
        System.out.println(new Solution2().removeDuplicates(s));
    }
}
