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
 * @create 2020/06/25 22:34
 **/

public class Solution3 {
    int target;

    public Solution3(int target) {
        this.target = target;
    }

    int guess(int num) {
        // this.target < num 返回 -1
        // this.target = num 返回 0
        // this.target > num 返回 1
        return Integer.compare(this.target, num);
    }

    // “两分式” 两分查找
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            // 严格小于 target 的元素不是解
            if (res == 1) { // target > n 的情况
                // 下一轮的搜索区间是 [mid + 1,right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3(6);
        System.out.println(solution3.guessNumber(10));
    }
}
