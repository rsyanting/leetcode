package ltd.ryantech.bitManipulation.powerOfTwo231;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.bitManipulation.powerOfTwo231
 * @description 231. 2的幂
 * @leetcode_CN_url // https://leetcode-cn.com/problems/power-of-two/
 * @leetcode_US_url // https://leetcode.com/problems/power-of-two/
 * @hard_level Easy
 * @tag Bit Manipulation // https://leetcode-cn.com/tag/bit-manipulation/
 * @create 2020/06/08 18:59
 **/

public class Solution1 {
    public boolean isPowerOfTwo(int n) {
        return n != 0 && (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        int num1 = 1;
        System.out.println(new Solution1().isPowerOfTwo(num1));

        int num2 = 0;
        System.out.println(new Solution1().isPowerOfTwo(num2));

        int num3 = -4;
        System.out.println(new Solution1().isPowerOfTwo(num3));

        int num4 = 8;
        System.out.println(new Solution1().isPowerOfTwo(num4));
    }
}
