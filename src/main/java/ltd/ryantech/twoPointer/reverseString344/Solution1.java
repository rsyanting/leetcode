package ltd.ryantech.twoPointer.reverseString344;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.reverseString344
 * @description 344. 反转字符串
 * @leetcode_CN_url // https://leetcode-cn.com/problems/reverse-string/
 * @leetcode_US_url // https://leetcode.com/problems/reverse-string/
 * @hard_level Easy
 * @tag Two Pointer // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/06/04 20:04
 **/

public class Solution1 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char t;
        while (left < right) {
            t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
    }
}
