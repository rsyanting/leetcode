package ltd.ryantech.deepFirstSearch.numberOfIslands200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.deepFirstSearch.numberOfIslands200
 * @description 岛屿数量
 * @leetcode_CN_url // https://leetcode-cn.com/problems/number-of-islands/
 * @leetcode_US_url // https://leetcode.com/problems/number-of-islands/
 * @hard_level Medium
 * @tag Deep First Search
 * @create 2020/05/13 14:06
 **/

public class Solution2 {
    // BFS 解法
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    bfs(grid, row, column);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int row, int column) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cur_row = cur[0];
            int cur_column = cur[1];
            // 合法则加入，与 DFS 的剪枝有区别
            if (cur_row >= 0 && cur_row < grid.length &&
                    cur_column >= 0 && cur_column < grid[0].length &&
                    grid[cur_row][cur_column] != '0') {
                grid[cur_row][cur_column] = '0';
                // dfs 方向为 上 下 左 右
                queue.add(new int[]{cur_row - 1, cur_column});
                queue.add(new int[]{cur_row + 1, cur_column});
                queue.add(new int[]{cur_row, cur_column - 1});
                queue.add(new int[]{cur_row, cur_column + 1});
            }
        }
    }

    public static void main(String[] args) {
        char[][] islands = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(new Solution2().numIslands(islands));
    }
}
