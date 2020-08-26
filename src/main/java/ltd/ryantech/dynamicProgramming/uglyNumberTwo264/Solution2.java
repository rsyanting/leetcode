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
 * @create 2020/08/21 15:01
 **/

public class Solution2 {
    public boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        int res = 0;
        int idx = 0;
        while (idx < n) {
            res++;
            if (isUgly(res)) {
                idx++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().nthUglyNumber(20));
    }
}
