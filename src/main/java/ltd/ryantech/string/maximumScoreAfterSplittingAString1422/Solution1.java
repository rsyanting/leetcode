package ltd.ryantech.string.maximumScoreAfterSplittingAString1422;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.string.maximumScoreAfterSplittingAString1422
 * @description 分割字符串的最大得分
 * @leetcode_CN_url // https://leetcode-cn.com/problems/maximum-score-after-splitting-a-string/
 * @leetcode_US_url // https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 * @hard_level Easy
 * @tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/05/15 12:49
 **/

public class Solution1 {
    public int maxScore(String s) {
        int[] dpLeft = new int[s.length()];
        dpLeft[0] = s.charAt(0) == '0' ? 1 : 0;
        // 注意保证左右字符串均不为空串
        for (int i = 1; i < s.length() - 1; i++) {
            dpLeft[i] = dpLeft[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
        }

        int[] dpRight = new int[s.length()];
        dpRight[s.length() - 1] = s.charAt(s.length() - 1) == '1' ? 1 : 0;
        for (int j = s.length() - 2; j > 0; j--) {
            dpRight[j] = dpRight[j + 1] + (s.charAt(j) == '1' ? 1 : 0);
        }

        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            res = Math.max(res, dpLeft[i] + dpRight[i + 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "011101";
        System.out.println(new Solution1().maxScore(s1));
    }
}
