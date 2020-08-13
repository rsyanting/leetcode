package ltd.ryantech.string.addStrings415;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.string.addStrings415
 * @description 415. 字符串相加
 * @leetcode_CN_url // https://leetcode-cn.com/problems/add-strings/
 * @leetcode_US_url // https://leetcode-cn.com/problems/add-strings/
 * @hard_level Easy
 * @tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/08/13 15:32
 **/

public class Solution2 {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
            i--;
            j--;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().addStrings("123", "456"));
        System.out.println(new Solution2().addStrings("999", "1"));
    }
}
