package ltd.ryantech.backtracking.combinationSumii40;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.backtracking.combinationSumii40
 * @description 40. 组合总和 II
 * @leetcode_CN_url // https://leetcode-cn.com/problems/combination-sum-ii/
 * @hard_level Medium
 * @tag Back Tracking // https://leetcode-cn.com/tag/backtracking/
 * @create 2020/10/17 21:21
 **/

public class Solution1 {
    // DFS
    // 大剪枝 + 小剪枝
    // 参考 39. 组合总和 的剪枝代码
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates); // 关键步骤

        if (candidates[0] > target) {
            return res;
        }

        int len = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, len, 0, target, path, res);

        return res;
    }

    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 递归结束的条件
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 大剪枝，如果小于了，那么不需要搜索了，跳到下一个元素去搜索
            if (target - candidates[i] < 0) {
                break;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, len, i + 1, target - candidates[i], path, res); // i + 1 元素不能重复使用
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = new Solution1().combinationSum2(nums, 8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
