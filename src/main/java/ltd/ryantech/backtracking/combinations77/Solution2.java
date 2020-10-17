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
 * @create 2020/10/17 15:28
 **/

public class Solution2 {
    // DFS 减枝方法
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // 特判
        if (k <= 0 || n < k) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        // 从 1 开始是题目的设定
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止的条件
        // 当 path 中存储的元素和要求组合的元素个数相等时，停止 dfs
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索的起点
        // 搜索的起点有上界，并不是可以取到最后一个
        // 例如 n = 6，k = 4 情况下，path.size = 1 接下来需要 3 个数字，搜索最大起点是 4
        // 例如 n = 6，k = 4 情况下，path.size = 2 接下来需要 2 个数字，搜索最大起点是 5
        // 这里为什么不需要 used ？因为这里只能向后搜索了，这里是组合，向前搜索会导致重复组合
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, res); // 继续尝试向后搜索
            // 回溯
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<List<Integer>> lists = solution2.combine(4, 2);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
