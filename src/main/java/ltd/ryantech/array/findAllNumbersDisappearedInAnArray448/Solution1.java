package ltd.ryantech.array.findAllNumbersDisappearedInAnArray448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.findAllNumbersDisappearedInAnArray448
 * @description 448. 找到所有数组中消失的数字
 * @leetcode_CN_url // https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * @leetcode_US_url // https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * @hard_level Easy
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/10/11 20:00
 **/

public class Solution1 {
    // 使用数组的下标来标记数字的出现于否
    // 将 nums[i] - 1 对应的下标元素置为负数
    // 如果一个元素 k 一直没有出现，那么对应的位置：nums[k - 1] 为正数
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 注意这里的 abs ，避免出现访问越界的情况
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = new Solution1().findDisappearedNumbers(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
