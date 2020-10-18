package ltd.ryantech.backtracking.permutationsii47;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.backtracking.permutationsii47
 * @description 47. 全排列 II
 * @leetcode_CN_url // https://leetcode-cn.com/problems/permutations-ii/
 * @hard_level Medium
 * @tag Back Tracking // https://leetcode-cn.com/tag/backtracking/
 * @create 2020/10/18 11:33
 **/

public class Solution2 {
    // DFS 剪枝
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums); // 首先进行排序，为了剪枝

        Deque<Integer> path = new ArrayDeque<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        dfs(nums, len, used, path, res);

        return res;
    }

    private void dfs(int[] nums, int len, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 全排列从 0 开始查找
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件
            // used[i - 1] 是因为 nums[i - 1] 在回退过程中刚刚被撤销了选择，这里很重要
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, used, path, res);

            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = new Solution2().permuteUnique(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
