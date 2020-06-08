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
 * @create 2020/06/08 22:55
 **/

public class Solution2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        int mask = 0x1;
        for (int idx = 0; idx < 32; idx++) {
            if ((n & mask) != 0) {
                res++;
            }
            mask = mask << 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 23;
        System.out.println(new Solution2().hammingWeight(n));
    }
}
