package ltd.ryantech.backtracking.combinationSum39;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.backtracking.combinationSum39
 * @description 39. 组合总和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/combination-sum/
 * @hard_level Medium
 * @tag Back Tracking // https://leetcode-cn.com/tag/backtracking/
 * @create 2020/10/17 21:16
 **/

public class Solution2 {
    // DFS 未剪枝
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return res;
        }

        int len = candidates.length;

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);

        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res); // 这里依旧从 i 处开始搜索
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> lists = new Solution2().combinationSum(nums, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
