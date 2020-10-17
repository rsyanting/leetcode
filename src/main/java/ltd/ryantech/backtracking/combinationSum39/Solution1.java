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
 * @create 2020/10/17 20:42
 **/

public class Solution1 {
    // 我的思路
    // 无法得出最终的解
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates); // 先行进行一个排序

        if (candidates[0] > target) { // 如果排序的第一个数字大于 target，那么说明不存在这样的解
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        int curSum = 0;
        dfs(candidates, target, 0, curSum, path, res);

        return res;
    }

    private void dfs(int[] candidates, int target, int begin, int curSum, Deque<Integer> path, List<List<Integer>> res) {
        //
        if (curSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, target, i + 1, curSum + candidates[i], path, res);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> lists = new Solution1().combinationSum(nums, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
