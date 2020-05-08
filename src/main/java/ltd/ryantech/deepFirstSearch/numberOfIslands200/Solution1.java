package ltd.ryantech.deepFirstSearch.numberOfIslands200;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.dynamicProgramming.numberOfIslands200
 * @description 岛屿数量
 * @leetcode_CN_url // https://leetcode-cn.com/problems/number-of-islands/
 * @leetcode_US_url // https://leetcode.com/problems/number-of-islands/
 * @hard_level Medium
 * @tag Deep First Search
 * @create 2020/05/07 21:11
 **/

public class Solution1 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    dfs(grid, row, column);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length ||
                column < 0 || column >= grid[0].length ||
                grid[row][column] == '0') {
            return;
        }
        int baseCount = 1;
        grid[row][column] = '0';
        // dfs 方向为 上 下 左 右
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
        return;
    }

    public static void main(String[] args) {
        char[][] islands = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(new Solution1().numIslands(islands));
    }
}
