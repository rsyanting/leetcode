package ltd.ryantech.backtracking.combinationSumiv377;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.backtracking.combinationSumiv377
 * @description 377. 组合总和 Ⅳ
 * @leetcode_CN_url // https://leetcode-cn.com/problems/combination-sum-iv/
 * @hard_level Medium
 * @tag Back Tracking // https://leetcode-cn.com/tag/backtracking/
 * @create 2020/10/17 22:03
 **/

public class Solution1 {
    public List<List<Integer>> combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, target, path, res);

        return res;
    }

    private void dfs(int[] nums, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            path.addLast(nums[i]);
            dfs(nums, len, i + 1, target - nums[i], path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new Solution1().combinationSum4(nums, 4);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
