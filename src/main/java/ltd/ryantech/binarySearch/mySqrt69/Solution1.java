package ltd.ryantech.binarySearch.mySqrt69;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.binarySearch.mySqrt69
 * @description 69. x 的平方根
 * @leetcode_CN_url // https://leetcode-cn.com/problems/sqrtx/
 * @leetcode_US_url // https://leetcode.com/problems/sqrtx/
 * @hard_level Easy
 * @tag Binary Search // https://leetcode-cn.com/tag/binary-search/
 * @create 2020/06/25 23:24
 **/

public class Solution1 {
    public int mySqrt(int x) {
        long left = 1;
//        long right = x / 2 + 1; // 一个规律是一个数的 平方根小于其值的一半
        long right = x / 2; // 一个规律是一个数的 平方根小于其值的一半
        while (left <= right) {
//            long mid = (left + right + 1) >>> 1;
            long mid = (left + right) >>> 1;
//            System.out.println("mid = " + mid);
            long sum = mid * mid;
//            System.out.println("sum = " + sum);
            if (sum == x) {
                return (int) mid;
            } else if (sum > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 结束时有 left > right
        return (int) (left - 1);
    }

    public static void main(String[] args) {
        int n1 = 4;
        System.out.println(new Solution1().mySqrt(n1));
        int n2 = 8;
        System.out.println(new Solution1().mySqrt(n2));
        System.out.println(new Solution1().mySqrt(3));
        System.out.println(new Solution1().mySqrt(2147395599));
//        System.out.println(Integer.MAX_VALUE);
    }
}
