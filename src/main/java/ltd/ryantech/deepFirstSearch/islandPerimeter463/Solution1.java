package ltd.ryantech.deepFirstSearch.islandPerimeter463;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.deepFirstSearch.islandPerimeter463
 * @description 岛屿的周长
 * @leetcode_CN_url // https://leetcode-cn.com/problems/island-perimeter/
 * @leetcode_US_url // https://leetcode.com/problems/island-perimeter/
 * @hard_level Easy
 * @tag Depth First Search
 * @create 2020/05/08 09:58
 **/

public class Solution1 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                // 题目中给定，只有一个岛屿，一次 dfs 即可
                if (grid[row][column] == 1) {
                    return dfs(grid, row, column);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int row, int column) {
        // 越界 ，周长加 1
        if (row < 0 || row >= grid.length ||
                column < 0 || column >= grid[0].length) {
            return 1;
        }
        // 边缘为湖泊，加 1
        if (grid[row][column] == 0) {
            return 1;
        }
        // 已经访问过的陆地，返回 0
        if (grid[row][column] == 2) {
            return 0;
        }
        grid[row][column] = 2;
        // dfs 方向为 上 下 左 右
        int length = dfs(grid, row - 1, column) +
                dfs(grid, row + 1, column) +
                dfs(grid, row, column - 1) +
                dfs(grid, row, column + 1);
        return length;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(new Solution1().islandPerimeter(grid));
    }
}
