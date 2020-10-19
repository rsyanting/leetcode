package ltd.ryantech.stack.backspaceStringCompare844;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.backspaceStringCompare844
 * @description 844. 比较含退格的字符串
 * @leetcode_CN_url // https://leetcode-cn.com/problems/backspace-string-compare/
 * @hard_level Easy
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/19 16:38
 **/

public class Solution1 {
    public boolean backspaceCompare(String S, String T) {
        Deque<Character> stackS = new ArrayDeque<>();
        Deque<Character> stackT = new ArrayDeque<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                // 如果栈中没有元素，那么不弹栈，否则弹栈
                if (!stackS.isEmpty()) {
                    stackS.removeLast();
                }
            } else {
                stackS.addLast(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                // 如果栈中没有元素，那么不弹栈，否则弹栈
                if (!stackT.isEmpty()) {
                    stackT.removeLast();
                }
            } else {
                stackT.addLast(T.charAt(i));
            }
        }

        // 判定相等的逻辑
        // 当 2 个栈均为空时，相等
        if (stackS.isEmpty() && stackT.isEmpty()) {
            return true;
        }

        // 2 个栈的 size 必须相等
        if (stackS.size() == stackT.size()) {
            while (!stackS.isEmpty() && !stackT.isEmpty()) {
                if (stackS.removeLast() == stackT.removeLast()) {
                } else {
                    return false;
                }
            }
            return stackS.isEmpty() && stackT.isEmpty();
        }

        return false;
    }

    public static void main(String[] args) {
        String S1 = "ab#c";
        String T1 = "ad#c";
        System.out.println(new Solution1().backspaceCompare(S1, T1));

        String S2 = "ab##";
        String T2 = "c#d#";
        System.out.println(new Solution1().backspaceCompare(S2, T2));

        String S3 = "a##c";
        String T3 = "#a#c";
        System.out.println(new Solution1().backspaceCompare(S3, T3));

        String S4 = "a#c";
        String T4 = "b";
        System.out.println(new Solution1().backspaceCompare(S4, T4));
    }
}
