package ltd.ryantech.backtracking.permutations46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.backtracking.permutations46
 * @description 46. 全排列
 * @leetcode_CN_url // https://leetcode-cn.com/problems/permutations/
 * @hard_level Medium
 * @tag Back Tracking // https://leetcode-cn.com/tag/backtracking/
 * @create 2020/10/17 11:22
 **/

public class Solution1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // 特判
        if (nums == null || nums.length == 0) {
            return res;
        }

        int len = nums.length;

        Deque<Integer> path = new ArrayDeque<>(); // 回溯栈
        boolean[] used = new boolean[len]; // 默认所有的元素都没有被使用过
        // depth 为当前的深度，最大深度为 len 大小
        // 从第 0 个元素开始
        dfs(nums, len, 0, path, used, res);

        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        // 递归结束的条件
        if (depth == len) {
            res.add(new ArrayList<>(path)); // 注意，这里生成一个新的拷贝
            return;
        }

        // 尝试遍历每一个元素
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue; // 如果被使用了，那么跳过
            }

            path.addLast(nums[i]); // 添加元素到当前 path，即选择当前的 nums[i]
            used[i] = true; // 标记已经选择了该 nums[i]
            dfs(nums, len, depth + 1, path, used, res); // 尝试寻找下一个元素 depth + 1
            // 回溯
            path.removeLast(); // 移除最后一个选择的元素，进行回溯
            used[i] = false; // 标记该元素未被使用
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> lists = new Solution1().permute(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
