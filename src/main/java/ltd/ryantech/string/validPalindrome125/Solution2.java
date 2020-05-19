package ltd.ryantech.string.validPalindrome125;

import javax.xml.stream.events.Characters;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.string.validPalindrome125
 * @description 验证回文串
 * @leetcode_CN_url // https://leetcode-cn.com/problems/valid-palindrome/
 * @leetcode_US_url // https://leetcode.com/problems/valid-palindrome/
 * @hard_level Easy
 * @tag string // https://leetcode-cn.com/tag/string/
 * @create 2020/05/19 13:43
 **/

public class Solution2 {
    // 双指针
    // 优化解，使用内建 API
    public boolean isPalindrome(String s) {
        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < end && !Character.isLetterOrDigit(s.charAt(front))) {
                front++;
            }
            while (front < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            front++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(new Solution2().isPalindrome(s1));
        String s2 = "0P";
        System.out.println(new Solution2().isPalindrome(s2));
    }
}
