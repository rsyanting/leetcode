package ltd.ryantech.backtracking.combinations77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.backtracking.combinations77
 * @description 77. 组合
 * @leetcode_CN_url // https://leetcode-cn.com/problems/combinations/
 * @hard_level Medium
 * @tag Back Tracking // https://leetcode-cn.com/tag/backtracking/
 * @create 2020/10/17 16:50
 **/

public class Solution3 {
    // DFS
    // 按照每一个数选与不选画出二叉树
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // 特判
        if (k <= 0 || n < k) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        // 从 1 开始是题目的设定
        dfs(1, n, k, path, res);
        return res;
    }

    private void dfs(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止的条件
        // 当 path 中存储的元素和要求组合的元素个数相等时，停止 dfs
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 递归终止的条件
        if (begin > n - k + 1) {
            return;
        }

        // 不选当前考虑的数 begin，直接递归到下一层
        dfs(begin + 1, n, k, path, res);

        // 不选当前考虑的数 begin，递归到下一层的时候 k - 1，这里 k 表示还需要选多少个数
        path.addLast(begin);
        dfs(begin + 1, n, k - 1, path, res);
        // 回溯
        path.removeLast();
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        List<List<Integer>> lists = solution3.combine(4, 2);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
