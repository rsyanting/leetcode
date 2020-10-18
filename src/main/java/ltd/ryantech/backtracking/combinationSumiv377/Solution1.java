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
    // DFS 剪枝
    // 无法解决题目，时间复杂度过高
    public List<List<Integer>> combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        if (nums[0] > target) {
            return res;
        }

        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, target, path, res);

        return res;
    }

    private void dfs(int[] nums, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (target - nums[i] < 0) {
                break;
            }

            path.addLast(nums[i]);
            dfs(nums, len, target - nums[i], path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new Solution1().combinationSum4(nums, 4);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

        int[] nums1 = {1, 2, 4};
        List<List<Integer>> lists1 = new Solution1().combinationSum4(nums1, 32);
        System.out.println(lists1.size());
    }
}
