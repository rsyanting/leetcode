package ltd.ryantech.backtracking.combinationSumiii216;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.backtracking.combinationSumiii216
 * @description 216. 组合总和 III
 * @leetcode_CN_url // https://leetcode-cn.com/problems/combination-sum-iii/
 * @hard_level Medium
 * @tag Back Tracking // https://leetcode-cn.com/tag/backtracking/
 * @create 2020/10/17 21:41
 **/

public class Solution1 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        if (n <= 0 || k <= 0) {
            return res;
        }

        int[] nums = new int[9];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, n, k, path, res);

        return res;
    }

    private void dfs(int[] nums, int len, int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        // 递归结束的条件
        if (n == 0 && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 剪枝，如果下一个数字比 n 小，那么提前 break 搜索下一个数字
            if (n - nums[i] < 0) {
                break;
            }

            path.addLast(nums[i]);
            dfs(nums, len, i + 1, n - nums[i], k, path, res); // 向后继续寻找
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution1().combinationSum3(3, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

        List<List<Integer>> lists1 = new Solution1().combinationSum3(3, 9);
        for (List<Integer> list : lists1) {
            System.out.println(list);
        }
    }
}
