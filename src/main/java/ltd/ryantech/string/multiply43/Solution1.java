package ltd.ryantech.string.multiply43;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.string.multiply43
 * @description 43. 字符串相乘
 * @leetcode_CN_url // https://leetcode-cn.com/problems/multiply-strings/
 * @leetcode_US_url // https://leetcode.com/problems/multiply-strings/
 * @hard_level Medium
 * @tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/08/13 15:30
 **/

public class Solution1 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    // 两数相加
    // 415. 字符串相加 https://leetcode-cn.com/problems/add-strings/
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
        System.out.println(new Solution1().multiply("123", "456"));
    }
}
