package ltd.ryantech.math.countDigitOne233;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.math.countDigitOne43
 * @description 233. 数字 1 的个数
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/number-of-digit-one/
 * @hard_level Medium
 * @tag Math // https://leetcode-cn.com/tag/math/
 * @create 2020/08/19 10:59
 **/

public class Solution1 {
    // 遍历，不寻找规律的方法
    public int countDigitOne(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += numberOfOne(i);
        }
        return res;
    }

    public int numberOfOne(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 1) {
                count++;
            }
            n = n / 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().countDigitOne(824883294));
    }
}
