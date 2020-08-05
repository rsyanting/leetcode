package ltd.ryantech.dynamicProgramming.minPathSum64;


/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.dynamicProgramming.minPathSum64
 * @description 64. 最小路径和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/minimum-path-sum/
 * @leetcode_US_url // https://leetcode.com/problems/minimum-path-sum/
 * @hard_level Medium
 * @tag Dynamic Programming // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/07/23 11:33
 **/

public class Solution2 {
    // 优化后的方法，能减少冗余的 if 判断
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) {
            return grid[0][0];
        }

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }

        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution2().minPathSum(grid));
    }
}
