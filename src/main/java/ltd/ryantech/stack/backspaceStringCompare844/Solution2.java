package ltd.ryantech.stack.backspaceStringCompare844;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.backspaceStringCompare844
 * @description 844. 比较含退格的字符串
 * @leetcode_CN_url // https://leetcode-cn.com/problems/backspace-string-compare/
 * @hard_level Easy
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/19 17:02
 **/

public class Solution2 {
    public boolean backspaceCompare(String S, String T) {
        int sSkipNum = 0; // 记录 S 中 # 的数量
        int tSkipNum = 0; // 记录 T 中 # 的数量
        int i = S.length() - 1;
        int j = T.length() - 1;

        while (true) {
            while (i >= 0) { // 从后向前，消除 S 的 #
                if (S.charAt(i) == '#') {
                    sSkipNum++;
                } else {
                    if (sSkipNum > 0) {
                        sSkipNum--;
                    } else { // 如果 sSkipNum <= 0 说明没有 # 号了，无法再删除了，跳出循环即可
                        // 因为能否删除和后面的 # 有关，和前面的 # 无关
                        break;
                    }
                }
                i--;
            }

            // 从后向前，消除T的#
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    tSkipNum++;
                } else {
                    if (tSkipNum > 0) {
                        tSkipNum--;
                    } else {
                        break;
                    }
                }
                j--;
            }

            // 后半部分 # 消除完了，接下来比较S[i] != T[j]
            // S 或者 T 遍历完了
            if (i < 0 || j < 0) {
                break;
            }

            // 外层嵌套的 while 依旧成立，继续进行迭代的判定
            if (S.charAt(i) != T.charAt(j)) {
                return false;
            }
            i--;
            j--;

        } // end of while loop

        return i == -1 && j == -1;
    }

    public static void main(String[] args) {
        String S1 = "ab#c";
        String T1 = "ad#c";
        System.out.println(new Solution2().backspaceCompare(S1, T1));

        String S2 = "ab##";
        String T2 = "c#d#";
        System.out.println(new Solution2().backspaceCompare(S2, T2));

        String S3 = "a##c";
        String T3 = "#a#c";
        System.out.println(new Solution2().backspaceCompare(S3, T3));

        String S4 = "a#c";
        String T4 = "b";
        System.out.println(new Solution2().backspaceCompare(S4, T4));
    }
}
