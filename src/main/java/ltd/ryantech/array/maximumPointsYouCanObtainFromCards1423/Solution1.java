package ltd.ryantech.array.maximumPointsYouCanObtainFromCards1423;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.maximumPointsYouCanObtainFromCards1423
 * @description 可获得的最大点数
 * @leetcode_CN_url // https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 * @leetcode_US_url // https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 * @hard_level Medium
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/05/15 14:13
 **/

public class Solution1 {
    // 超出时间限制
    // 未优化版 滑动窗口思想
    public int maxScore(int[] cardPoints, int k) {
        int res = 0;
        int t_res = 0;
        int front = k;
        int end = cardPoints.length - 1;
        while (front >= 0 && end >= cardPoints.length - k - 1) {
            for (int i = 0; i < front; i++) {
                t_res += cardPoints[i];
            }
            for (int j = cardPoints.length - 1; j > end; j--) {
                t_res += cardPoints[j];
            }
            res = Math.max(res, t_res);
            t_res = 0;
            front--;
            end--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] cards = {1, 2, 3, 4, 5, 6, 1};
        System.out.println(new Solution1().maxScore(cards, 3));
    }
}
