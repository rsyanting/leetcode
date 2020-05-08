package ltd.ryantech.deepFirstSearch.maxAreaOfIsland695;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.dynamicProgramming.maxAreaOfIsland695
 * @description 岛屿的最大面积
 * @leetcode_CN_url // https://leetcode-cn.com/problems/max-area-of-island/
 * @leetcode_US_url // https://leetcode.com/problems/max-area-of-island/
 * @hard_level Easy
 * @tag Depth First Search
 * @create 2020/05/06 22:05
 **/

public class Solution1 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxArea = -1;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                maxArea = Math.max(maxArea, dfs(grid, row, column));
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int row, int column) {
        // index 越界；grid 位置不为 1；返回 0
        if (row < 0 || row >= grid.length ||
                column < 0 || column >= grid[0].length ||
                grid[row][column] != 1) {
            return 0;
        }

        // 标记已经访问过的点
        grid[row][column] = 0;
        // 岛屿初始面积为 1
        int baseArea = 1;
        // dfs 方向为 上 下 左 右
        int aroundArea = dfs(grid, row - 1, column) +
                dfs(grid, row + 1, column) +
                dfs(grid, row, column - 1) +
                dfs(grid, row, column + 1);
        return baseArea + aroundArea;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(new Solution1().maxAreaOfIsland(grid));
    }
}
