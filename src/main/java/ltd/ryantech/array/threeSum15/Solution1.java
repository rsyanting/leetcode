package ltd.ryantech.array.threeSum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.threeSum15
 * @description 15. 三数之和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/3sum/
 * @leetcode_US_url // https://leetcode.com/problems/3sum/
 * @hard_level Medium
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/06/24 11:23
 **/

public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break; // 三个数字均大于 0 ，不可能再产生符合条件的结果。
            if (k > 0 && nums[k] == nums[k - 1]) continue; // 元素有重复，跳过重复的元素
            int i = k + 1, j = nums.length - 1; // i 向右搜索，j 向左搜索
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ; // 跳过重复元素
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ; // 跳过重复元素
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ; // 继续跳过重复元素
                    while (i < j && nums[j] == nums[--j]) ; // 继续跳过重复元素
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {};
        List<List<Integer>> res = new Solution1().threeSum(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
