package ltd.ryantech.deepFirstSearch.numberOfIslands200;

import java.util.Stack;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.deepFirstSearch.numberOfIslands200
 * @description 岛屿数量
 * @leetcode_CN_url // https://leetcode-cn.com/problems/number-of-islands/
 * @leetcode_US_url // https://leetcode.com/problems/number-of-islands/
 * @hard_level Medium
 * @tag Deep First Search
 * @create 2020/05/13 14:21
 **/

public class Solution3 {
    // DFS 用栈改造递归
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
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, column});
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int cur_row = cur[0];
            int cur_column = cur[1];
            // 符合条件的压入栈中
            if (cur_row >= 0 && cur_row < grid.length &&
                    cur_column >= 0 && cur_column < grid[0].length &&
                    grid[cur_row][cur_column] != '0') {
                grid[cur_row][cur_column] = '0';
                // dfs 方向为 上 下 左 右
                stack.push(new int[]{cur_row - 1, cur_column});
                stack.push(new int[]{cur_row + 1, cur_column});
                stack.push(new int[]{cur_row, cur_column - 1});
                stack.push(new int[]{cur_row, cur_column + 1});
            }
        }
    }

    public static void main(String[] args) {
        char[][] islands = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(new Solution3().numIslands(islands));
    }
}
