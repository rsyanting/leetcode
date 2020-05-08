package ltd.ryantech.bitManipulation.numberComplement476;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.bitManipulation.numberComplement476
 * @description 数字的补数
 * @leetcode_CN_url // https://leetcode-cn.com/problems/number-complement/
 * @leetcode_US_url // https://leetcode.com/problems/number-complement/
 * @hard_level Easy
 * @tag Bit Manipulation
 * @create 2020/05/04 15:24
 **/

public class Solution1 {
    /**
     * num          = 00000101
     * mask         = 00000011
     * ~num         = 11111010
     * mask & ~num  = 00000010
     */
    public int findComplement(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }

    public static void main(String[] args) {
        int n1 = 5;
        System.out.println(new Solution1().findComplement(n1));
    }
}
