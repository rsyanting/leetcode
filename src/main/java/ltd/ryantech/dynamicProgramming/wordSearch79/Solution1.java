package ltd.ryantech.dynamicProgramming.wordSearch79;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.dynamicProgramming.wordSearch79
 * @description 最大子序和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/word-search/
 * @leetcode_US_url // https://leetcode.com/problems/word-search/
 * @hard_level Medium
 * @tag Dynamic Programming
 * @create 2020/05/06 18:32
 **/

public class Solution1 {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board == null || board.length == 0) {
            return false;
        }

        char[] words = word.toCharArray();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (dfs(board, words, row, column, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] words, int row, int column, int pos) {
        // index 越界；board 位置字符和 words 中的 pos 位置字符不相等；返回 false
        if (row < 0 || row >= board.length ||
                column < 0 || column > board[0].length ||
                words[pos] != board[row][column]) {
            return false;
        }
        // 如果此时 pos 的值和字符串长度长度相等，意味着搜索到了该字符串，匹配成功
        if (pos == words.length - 1) {
            return true;
        }
        // 记录下当前 board 元素的值，需要回溯的情况下，进行回溯。
        char tmp = board[row][column];
        board[row][column] = '/'; // 假定输入字符串中不含 空串 和 '/' 字符
        // 深度遍历的方向为 下 上 右 左
        // 任意一个方向匹配，则继续搜索，如果全部不相等就尝试回溯，否则最终返回 false，匹配失败
        boolean res = dfs(board, words, row + 1, column, pos + 1) ||
                dfs(board, words, row - 1, column, pos + 1) ||
                dfs(board, words, row, column + 1, pos + 1) ||
                dfs(board, words, row, column - 1, pos + 1);
        board[row][column] = tmp; // 回溯
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABDEF";
        System.out.println(new Solution1().exist(board, word));
    }
}
