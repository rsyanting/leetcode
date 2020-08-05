package ltd.ryantech.binarySearch.guessNumber374;


/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.binarySearch.guessNumber374
 * @description 374. 猜数字大小
 * @leetcode_CN_url // https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 * @leetcode_US_url // https://leetcode.com/problems/guess-number-higher-or-lower/
 * @hard_level Easy
 * @tag Binary Search // https://leetcode-cn.com/tag/binary-search/
 * @create 2020/06/25 15:27
 **/

public class Solution1 {
    int target;

    public Solution1(int target) {
        this.target = target;
    }

    int guess(int num) {
        // this.target < num 返回 -1
        // this.target = num 返回 0
        // this.target > num 返回 1
        return Integer.compare(this.target, num);
    }

    // 经典 “三分式” 两分查找
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == -1) { // target < n 的情况
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1(6);
        System.out.println(solution1.guessNumber(10));
    }
}
