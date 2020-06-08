package ltd.ryantech.bitManipulation.totalHamingDistance477;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.bitManipulation.totalHamingDistance477
 * @description 477. 汉明距离总和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/total-hamming-distance/
 * @leetcode_US_url // https://leetcode.com/problems/total-hamming-distance/
 * @hard_level Medium
 * @tag Bit Manipulation // https://leetcode-cn.com/tag/bit-manipulation/
 * @create 2020/06/08 20:13
 **/

public class Solution1 {
    // 超时
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum += hammingDistance(nums[i], nums[j]);
            }
        }
        return sum;
    }

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }

    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(new Solution1().totalHammingDistance(nums));
    }
}
