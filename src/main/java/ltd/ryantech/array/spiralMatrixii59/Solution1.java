package ltd.ryantech.array.spiralMatrixii59;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.spiralMatrixii59
 * @description 59. 螺旋矩阵 II
 * @leetcode_CN_url // https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @leetcode_US_url // https://leetcode.com/problems/spiral-matrix-ii/
 * @hard_level Medium
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/06/05 11:44
 **/

public class Solution1 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[][]{};
        }

        int[][] ans = new int[n][n];
        int tot = 1;
        int row = 0;
        int column = 0;
        ans[row][column] = tot;
        while (tot < n * n) {
            while (column + 1 < n && ans[row][column + 1] == 0) {
                ans[row][++column] = ++tot;
            }
            while (row + 1 < n && ans[row + 1][column] == 0) {
                ans[++row][column] = ++tot;
            }
            while (column - 1 >= 0 && ans[row][column - 1] == 0) {
                ans[row][--column] = ++tot;
            }
            while (row - 1 >= 0 && ans[row - 1][column] == 0) {
                ans[--row][column] = ++tot;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] res = new Solution1().generateMatrix(3);
        for (int[] nums : res) {
            for (int num : nums) {
                System.out.println(num);
            }
        }
    }
}
