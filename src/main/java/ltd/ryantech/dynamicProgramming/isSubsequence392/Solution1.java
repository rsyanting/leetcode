package ltd.ryantech.dynamicProgramming.isSubsequence392;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.dynamicProgramming.isSubsequence392
 * @description 392. 判断子序列
 * @leetcode_CN_url // https://leetcode-cn.com/problems/is-subsequence/
 * @leetcode_US_url // https://leetcode.com/problems/is-subsequence/
 * @hard_level Easy
 * @tag Dynamic Programming // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/06/09 15:32
 **/

public class Solution1 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        } else if (t.length() == 0) {
            return false;
        }

        int match = 0;
        for (int idx = 0; idx < t.length() && match < s.length(); idx++) {
            if (s.charAt(match) == t.charAt(idx)) {
                match++;
            }
        }
        return match == s.length();
    }

    public static void main(String[] args) {
        String s = "b";
        String t = "t";
        System.out.println(new Solution1().isSubsequence(s, t));
    }
}
