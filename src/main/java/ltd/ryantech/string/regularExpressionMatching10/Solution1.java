package ltd.ryantech.string.regularExpressionMatching10;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.string.regularExpressionMatching10
 * @description 正则表达式匹配
 * @leetcode_CN_url // https://leetcode-cn.com/problems/regular-expression-matching/
 * @leetcode_US_url // https://leetcode.com/problems/regular-expression-matching/
 * @hard_level Hard
 * @tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/05/29 15:46
 **/

public class Solution1 {
    // 从前往后进行分析，进行递归操作
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();

        // 递归结束的时间：j 遍历完 p 字符串，即可跳出递归
        // 如果 i 也刚好完成遍历，那么 s 和 p 完全匹配
        if (j == n) {
            return i == m;
        }

        // 字符 match 的情况：j 指向的字符为 '.' 或者是 i,j 指针各自指向的字符完全相等
        boolean charMatch = (p.charAt(j) == '.') || s.charAt(i) == p.charAt(j);

        // j 的后一个字符不是 '*' , 直接递归调用 isMatch 方法即可
        if (j == n - 1 || p.charAt(j + 1) != '*') {
            // i < m , 在 p 比 s 长的情况，此时也不匹配
            return (i < m) && charMatch && isMatch(s, i + 1, p, j + 1);
        }

        // j 在有效范围内，且 j 不是 s 的最后一个字符
        if (j < n - 1 && p.charAt(j + 1) == '*') {
            // while 循环是本题核心
            while ((i < m) && charMatch) {
                if (isMatch(s, i, p, j + 2)) {
                    return true;

                }
                // 如果无法匹配
                // 尝试用星号组合去匹配更长的一段字符串
                i++;
            }
        }

        if (!charMatch || (i == m && p.charAt(j + 1) == '*')) {
            return isMatch(s, i, p, j + 2);
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ssippi";
        String p1 = "s*p*.";
        System.out.println(new Solution1().isMatch(s1, p1));
//        String s1 = "aa";
//        String p1 = "a*";
//        System.out.println(new Solution1().isMatch(s1, p1));
    }
}
