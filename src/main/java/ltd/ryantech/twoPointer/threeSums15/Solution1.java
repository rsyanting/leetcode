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
 * @create 2020/10/16 15:17
 **/

public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new Solution1().threeSum(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
