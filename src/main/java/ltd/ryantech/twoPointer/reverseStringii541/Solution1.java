package ltd.ryantech.twoPointer.reverseStringii541;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.reverseStringii541
 * @description 541. 反转字符串 II
 * @leetcode_CN_url // https://leetcode-cn.com/problems/reverse-string-ii/
 * @leetcode_US_url // https://leetcode.com/problems/reverse-string-ii/
 * @hard_level Easy
 * @tag Two Pointer // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/06/04 20:07
 **/

public class Solution1 {
    public String reverseStr(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int lastReached = 0;
        int start = 0;
        int end = start;
        int stringLength = s.length();
        while (start < stringLength) {
            while ((end - start + 1) < k && end < stringLength - 1) {
                end++;
            }
            lastReached = end + k;
            if (lastReached < stringLength) {

            }
            for (int i = end; i >= start; i--) {
                stringBuilder.append(s.charAt(i));
            }
            for (int i = end + 1; i <= lastReached; i++) {
                stringBuilder.append(s.charAt(i));
            }
            start = lastReached + 1;
            end = start;
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(new Solution1().reverseStr(s, 4));
    }
}
