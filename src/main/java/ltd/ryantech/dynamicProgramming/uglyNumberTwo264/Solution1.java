package ltd.ryantech.dynamicProgramming.uglyNumberTwo264;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.dynamicProgramming.uglyNumberTwo264
 * @description 264. 丑数 2
 * @leetcode_CN_url // https://leetcode-cn.com/problems/ugly-number-ii/
 * @leetcode_US_url // https://leetcode.com/problems/ugly-number-ii/
 * @hard_level Medium
 * @tag Dynamic Programming
 * @create 2020/05/08 16:14
 **/

public class Solution1 {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int pMultiply2 = 0;
        int pMultiply3 = 0;
        int pMultiply5 = 0;
        while (nextUglyIndex < n) {
            int min = Math.min(Math.min(uglyNumbers[pMultiply2] * 2, uglyNumbers[pMultiply3] * 3), uglyNumbers[pMultiply5] * 5);
            uglyNumbers[nextUglyIndex] = min;
            while (uglyNumbers[pMultiply2] * 2 <= uglyNumbers[nextUglyIndex]) {
                pMultiply2++;
            }
            while (uglyNumbers[pMultiply3] * 3 <= uglyNumbers[nextUglyIndex]) {
                pMultiply3++;
            }
            while (uglyNumbers[pMultiply5] * 5 <= uglyNumbers[nextUglyIndex]) {
                pMultiply5++;
            }
            nextUglyIndex++;
        }
        return uglyNumbers[nextUglyIndex - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().nthUglyNumber(10));
        System.out.println(new Solution1().nthUglyNumber(2));
    }
}
