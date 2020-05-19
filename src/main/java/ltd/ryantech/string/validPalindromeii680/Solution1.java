package ltd.ryantech.string.validPalindromeii680;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.string.validPalindromeii680
 * @description 验证回文字符串 Ⅱ
 * @leetcode_CN_url // https://leetcode-cn.com/problems/valid-palindrome-ii/
 * @leetcode_US_url // https://leetcode.com/problems/valid-palindrome-ii/
 * @hard_level Easy
 * @tag string // https://leetcode-cn.com/tag/string/
 * @create 2020/05/19 14:11
 **/

public class Solution1 {
    public boolean validPalindrome(String s) {
        int front = 0;
        int end = s.length() - 1;
        // < 符号，中间一个字符不影响回文与否
        while (front < end) {
            if (s.charAt(front) != s.charAt(end)) {
                return validPalindromeHelper(s, front + 1, end) || validPalindromeHelper(s, front, end - 1);
            }
            front++;
            end--;
        }
        return true;
    }

    private boolean validPalindromeHelper(String s, int front, int end) {
        while (front < end) {
            if (s.charAt(front) != s.charAt(end)) {
                return false;
            }
            front++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abca";
        System.out.println(new Solution1().validPalindrome(s1));
        String s2 = "ccabbcacc";
        System.out.println(new Solution1().validPalindrome(s2));
    }
}
