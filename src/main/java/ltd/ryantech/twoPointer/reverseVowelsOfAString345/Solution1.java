package ltd.ryantech.twoPointer.reverseVowelsOfAString345;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.reverseVowelsOfAString345
 * @description 345. 反转字符串中的元音字母
 * @leetcode_CN_url // https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * @leetcode_US_url // https://leetcode.com/problems/reverse-vowels-of-a-string/
 * @hard_level Easy
 * @tag Two Pointer // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/06/04 19:13
 **/

public class Solution1 {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] s1 = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char t;
        while (left < right) {
            while (left < right && !set.contains(s1[left])) {
                left++;
            }
            while (left < right && !set.contains(s1[right])) {
                right--;
            }
            t = s1[left];
            s1[left] = s1[right];
            s1[right] = t;
            left++;
            right--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s1) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new Solution1().reverseVowels(s));
    }
}
