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
 * @create 2020/05/05 12:27
 **/

public class Solution2 {
    // 给定 100110
    // 返回 011001
    // 相加 111111
    // 那么求出和，再减去即可
    public int findComplement(int num) {
        int i = 0;
        int j = 0;
        while (i < num) {
            i = i + (int) Math.pow(2, j); // 1,3,7,15,31.......
            j++;
        }
        return i - num;
    }

    public static void main(String[] args) {
        int n1 = 15;
        System.out.println(new Solution2().findComplement(n1));
    }
}
