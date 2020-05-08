package ltd.ryantech.math.checkStraightLine1232;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.math.checkStraightLine1232
 * @description 缀点成线
 * @leetcode_CN_url // https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 * @leetcode_US_url // https://leetcode.com/problems/check-if-it-is-a-straight-line/
 * @hard_level Easy
 * @tag Math
 * @create 2020/05/08 18:38
 **/

public class Solution1 {
    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length - 1; i++) {
            int x1 = coordinates[i + 1][0] - coordinates[i][0];
            int y1 = coordinates[i + 1][1] - coordinates[i][1];
            if (x * y1 != x1 * y) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {6, 7}};
        System.out.println(new Solution1().checkStraightLine(coordinates));
    }
}
