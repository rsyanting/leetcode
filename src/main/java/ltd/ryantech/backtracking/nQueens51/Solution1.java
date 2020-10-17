package ltd.ryantech.backtracking.nQueens51;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.backtracking.nQueens51
 * @description 51. N 皇后
 * @leetcode_CN_url // https://leetcode-cn.com/problems/n-queens/
 * @hard_level Hard
 * @tag Back Tracking // https://leetcode-cn.com/tag/backtracking/
 * @create 2020/10/17 16:58
 **/

public class Solution1 {
    private int n;
    // 记录某一列是否放置了皇后
    // 我们是按照行，再到列进行探测的，当前探测行的上面一行肯定是填写过了，所有不需要标志位
    private boolean[] col;
    // 记录主对角线上的单元格是否放置了皇后
    private boolean[] main;
    // 记录副对角线上的单元格是否放置了皇后
    private boolean[] sub;

    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.res = new ArrayList<>();

        if (n == 0) {
            return this.res;
        }

        this.n = n;
        this.col = new boolean[n];
        this.main = new boolean[2 * n - 1]; // 关于对角线的条数，可以画图进行规律的查找
        this.sub = new boolean[2 * n - 1];

        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path); // 从第 0 行开始探测

        return this.res;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            // 深度优先遍历到下标为 n，表示 [0.. n - 1] 已经填完，得到了一个结果
            List<String> board = convert2board(path);
            res.add(board);
            return;
        }

        // 针对下标为 row 的每一列，尝试是否可以放置
        for (int j = 0; j < n; j++) {
            // col 是竖直列，如果放置过了，为 true
            // sub 副对角线的特点是，一个对角线上的横纵坐标和 value 固定，即 row + j 固定
            //   value 的特点是 ： 0 1 2 3 4 5 6 ，从上到下的访问顺序
            // main 主对角线的特点是，横坐标 - 纵坐标 值 value 固定，value 的特点是
            //   value 是一个 --- 0 +++ 的一个序列，例如 n = 4 时
            //   value 从上到下是 -3 -2 -1 0 1 2 3
            //   value = row - j + n - 1，可以保证这样的序列
            if (!col[j] && !sub[row + j] && !main[row - j + n - 1]) {
                path.addLast(j);
                col[j] = true;// 标记被访问了
                sub[row + j] = true;
                main[row - j + n - 1] = true;

                dfs(row + 1, path);

                // 回溯
                main[row - j + n - 1] = false;
                sub[row + j] = false;
                col[j] = false;
                path.removeLast();
            }
        }
    }

    private List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            // 填充空白区域
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    row.append(".");
                }
            }
            // 填入皇后的位置
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<List<String>> lists = solution1.solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
