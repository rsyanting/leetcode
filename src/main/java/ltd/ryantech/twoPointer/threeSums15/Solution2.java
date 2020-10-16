package ltd.ryantech.twoPointer.threeSums15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.threeSums15
 * @description 15. 三数之和
 * @leetcode_CN_url https://leetcode-cn.com/problems/3sum/
 * @hard_level Medium
 * @tag Two Pointer // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/10/16 11:53
 **/

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums); // 首先将数组进行升序的排序
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break; // 不可能出现三数字和为 0 的情况了
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue; // 排除掉重复元素
            }

            // 设置双指针
            int left = k + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]) ;// 跳过重复的数字
                } else if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]) ; // 跳过重复的数字
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[++left]) ;// 跳过重复的数字
                    while (left < right && nums[right] == nums[--right]) ;// 跳过重复的数字
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new Solution2().threeSum(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
