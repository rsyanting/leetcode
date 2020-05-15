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
 * @create 2020/05/15 14:34
 **/

public class Solution2 {
    // 前缀和
    // 避免了多次重复的计算，节约时间
    public int maxScore(int[] cardPoints, int k) {
        // prefix 数组，index 代表前面 index 个的卡牌点数和
        // 例如：prefix[1] 表示前面的一共 1 个卡牌和
        int[] prefix = new int[cardPoints.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            prefix[i + 1] = prefix[i] + cardPoints[i];
        }
        int res = 0;
        // 注意此处的循环条件
        // 有可能全部从数组左边开始拿，拿够 k 个
        for (int i = 0; i <= k; i++) {
            // prefix[cardPoints.length - k + i] 为滑动窗口的思想
            // 用总的和减去上面这个部分和，即为右边剩下的部分和
            res = Math.max(res, prefix[i] + prefix[cardPoints.length] - prefix[cardPoints.length - k + i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] cards = {1, 2, 3, 4, 5, 6, 1};
        System.out.println(new Solution2().maxScore(cards, 3));
    }
}
