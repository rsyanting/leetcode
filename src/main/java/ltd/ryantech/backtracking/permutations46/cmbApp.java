package ltd.ryantech.backtracking.permutations46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.backtracking.permutations46
 * @description
 * @create 2020/10/17 15:02
 **/

public class cmbApp {
    // 招商银行 笔试题
    // 排列，非全排列
    // 给定 [1,2,3,4] 选出 3 个数字，求解出全部的且不相等的三位数字，例如 123 132 213 ...
    public List<List<Integer>> getThreeNums(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        int len = nums.length;

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len]; // 标记该元素是否被使用了
        dfs(nums, k, 0, path, used, res); // 初始 dfs 的 depth = 0

        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        // dfs 终止的条件
        // 当 path 中的数字数量和 len 相等时，说明寻找到了一组这样的数据
        if (path.size() == len) {
            res.add(new ArrayList<>(path)); // 注意，这里生成一个新的拷贝
            return;
        }

        // 尝试遍历每一个元素
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue; // 如果被使用过了，那么跳过
            }

            path.addLast(nums[i]); // 添加当前的元素到 path 栈中去
            used[i] = true; // 标记当前元素被使用了
            dfs(nums, len, depth + 1, path, used, res); // 继续 dfs，depth + 1
            // 回溯
            path.removeLast(); // 移除被使用过的元素
            used[i] = false; // 标记没有使用该元素
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        cmbApp cmbApp = new cmbApp();
        List<List<Integer>> lists = cmbApp.getThreeNums(nums, 3);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
