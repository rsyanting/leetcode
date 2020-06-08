package ltd.ryantech.bitManipulation.numberOf1Bits191;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.bitManipulation.numberOf1Bits191
 * @description 191. 位1的个数
 * @leetcode_CN_url // https://leetcode-cn.com/problems/number-of-1-bits/
 * @leetcode_US_url // https://leetcode.com/problems/number-of-1-bits/
 * @hard_level Easy
 * @tag Bit Manipulation // https://leetcode-cn.com/tag/bit-manipulation/
 * @create 2020/06/08 19:44
 **/

public class Solution1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 23;
        System.out.println(new Solution1().hammingWeight(n));
    }
}
