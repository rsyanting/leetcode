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
 * @create 2020/10/17 21:05
 **/

public class Solution3 {
    // DFS
    // 排序 + 剪枝
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates); // 先行进行一个排序

        if (candidates[0] > target) { // 如果排序的第一个数字大于 target，那么说明不存在这样的解
            return res;
        }

        int len = candidates.length;

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);

        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res); // 这里依旧从 i 处开始搜索
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> lists = new Solution3().combinationSum(nums, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
