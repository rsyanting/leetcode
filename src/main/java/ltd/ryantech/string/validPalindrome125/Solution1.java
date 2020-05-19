package ltd.ryantech.string.validPalindrome125;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.string.validPalindrome125
 * @description 验证回文串
 * @leetcode_CN_url // https://leetcode-cn.com/problems/valid-palindrome/
 * @leetcode_US_url // https://leetcode.com/problems/valid-palindrome/
 * @hard_level Easy
 * @tag string // https://leetcode-cn.com/tag/string/
 * @create 2020/05/19 11:18
 **/

public class Solution1 {
    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isLetter(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
            }
        }
        char[] stringArray = stringBuilder.toString().toCharArray();
        // 特判
        if (stringArray.length <= 1) {
            return true;
        }
        int front = 0;
        int end = stringArray.length - 1;
        while (front <= end) {
            char t_front = toLowerLetter(stringArray[front]);
            char t_end = toLowerLetter(stringArray[end]);
            if (t_front != t_end) {
                return false;
            }
            front++;
            end--;
        }
        return true;
    }

    private boolean isUpperLetter(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    private boolean isLowerLetter(char c) {
        return (c >= 'a' && c <= 'z');
    }

    private boolean isDigital(char c) {
        return (c >= '0' && c <= '9');
    }

    private boolean isLetter(char c) {
        return isUpperLetter(c) || isLowerLetter(c) || isDigital(c);
    }

    private char toLowerLetter(char c) {
        if (isUpperLetter(c)) {
            return (char) ('a' + (c - 'A'));
        }
        return c;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(new Solution1().isPalindrome(s1));
        String s2 = "0P";
        System.out.println(new Solution1().isPalindrome(s2));
    }
}
