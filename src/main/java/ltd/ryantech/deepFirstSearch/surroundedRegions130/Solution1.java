package ltd.ryantech.deepFirstSearch.surroundedRegions130;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.dynamicProgramming.surroundedRegions130
 * @description 被围绕的区域
 * @leetcode_CN_url // https://leetcode-cn.com/problems/surrounded-regions/
 * @leetcode_US_url // https://leetcode.com/problems/surrounded-regions/
 * @hard_level Medium
 * @tag Deep First Search
 * @create 2020/05/07 21:31
 **/

public class Solution1 {
    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                boolean isEdge = (row == 0 || row == board.length - 1 ||
                        column == 0 || column == board[0].length - 1);
                if (isEdge && board[row][column] == 'O') {
                    dfs(board, row, column);
                }
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == 'O') {
                    board[row][column] = 'X';
                }
                if (board[row][column] == 'P') {
                    board[row][column] = 'O';
                }
            }
        }
    }


    public void dfs(char[][] board, int row, int column) {
        if (row < 0 || row >= board.length ||
                column < 0 || column >= board[0].length ||
                board[row][column] != 'O' || board[row][column] == 'P') {
            return;
        }
        board[row][column] = 'P';
        // dfs 方向为 上 下 左 右
        dfs(board, row + 1, column);
        dfs(board, row - 1, column);
        dfs(board, row, column - 1);
        dfs(board, row, column + 1);
        return;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        Solution1 solution1 = new Solution1();
        solution1.solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i]);
        }
    }
}
