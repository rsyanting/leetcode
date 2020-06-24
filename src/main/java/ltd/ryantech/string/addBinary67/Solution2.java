package ltd.ryantech.string.addBinary67;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.string.addBinary67
 * @description 67. 二进制求和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/add-binary/
 * @leetcode_US_url // https://leetcode.com/problems/add-binary/
 * @hard_level Easy
 * @tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/06/23 14:24
 **/

public class Solution2 {
    // 重构 竖式 模拟计算
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? ((a.charAt(a.length() - 1 - i)) - '0') : 0;
            carry += i < b.length() ? ((b.charAt(b.length() - 1 - i)) - '0') : 0;
            sb.append((char) (carry % 2 + '0')); // '0' + 1 -> 1(int)
            carry /= 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        System.out.println(new Solution2().addBinary(a, b));
    }
}
