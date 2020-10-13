package ltd.ryantech.array.findAllDuplicatesInAnArray442;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.findAllDuplicatesInAnArray442
 * @description 442. 数组中重复的数据
 * @leetcode_CN_url // https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 * @leetcode_US_url // https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * @hard_level Medium
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/10/11 20:36
 **/

public class Solution1 {
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                res.add(Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = new Solution1().findDuplicates(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
