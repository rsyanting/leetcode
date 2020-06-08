package ltd.ryantech.bitManipulation.hammingDistance461;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.bitManipulation.hammingDistance461
 * @description 461. 汉明距离
 * @leetcode_CN_url // https://leetcode-cn.com/problems/hamming-distance/
 * @leetcode_US_url // https://leetcode.com/problems/hamming-distance/
 * @hard_level Easy
 * @tag Bit Manipulation // https://leetcode-cn.com/tag/bit-manipulation/
 * @create 2020/06/08 19:48
 **/

public class Solution1 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().hammingDistance(93, 73));
    }
}
