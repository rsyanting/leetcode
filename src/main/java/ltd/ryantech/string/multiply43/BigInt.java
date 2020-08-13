package ltd.ryantech.string.multiply43;

import java.math.BigInteger;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.string.multiply43
 * @description 43. 字符串相乘
 * @leetcode_CN_url // https://leetcode-cn.com/problems/multiply-strings/
 * @leetcode_US_url // https://leetcode.com/problems/multiply-strings/
 * @hard_level Medium
 * @tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/08/13 15:41
 **/

public class BigInt {
    public String multiply(String num1, String num2) {
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);
        BigInteger sum = n1.multiply(n2);
        return sum.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BigInt().multiply("3792", "389218432"));
    }
}
