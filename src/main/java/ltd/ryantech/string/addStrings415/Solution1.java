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
 * @create 2020/08/03 14:07
 **/

public class Solution1 {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int tmp = 0;
        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        while (l1 >= 0 && l2 >= 0) {
            tmp = (num1.charAt(l1) - '0') + (num2.charAt(l2) - '0') + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            l1--;
            l2--;
        }

        while (l1 >= 0) {
            tmp = (num1.charAt(l1) - '0') + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            l1--;
        }

        while (l2 >= 0) {
            tmp = (num2.charAt(l2) - '0') + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            l2--;
        }

        // 考虑 999 + 1 的情况，最后需要加上最高位的进位
        if (carry > 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().addStrings("123", "456"));
        System.out.println(new Solution1().addStrings("999", "1"));
    }
}
