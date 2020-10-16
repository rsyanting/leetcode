package ltd.ryantech.twoPointer.fourSums18;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.fourSums18
 * @description 18. 四数之和
 * @leetcode_CN_url https://leetcode-cn.com/problems/4sum/
 * @hard_level Medium
 * @tag Two Pointer // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/10/16 17:03
 **/

public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 排序一次即可

        for (int i = 0; i < len - 3; i++) { // 注意循环的范围
            // 调用 threeSum 求解剩下的
            List<List<Integer>> threeSumList = threeSum(nums, i + 1, target - nums[i]);
            for (int j = 0; j < threeSumList.size(); j++) {
                List<Integer> num = new ArrayList<>();
                num.add(nums[i]);
                List<Integer> threeSum = threeSumList.get(j);
                for (int k = 0; k < threeSum.size(); k++) {
                    num.add(threeSum.get(k));
                }
                res.add(num); // 添加全部的元素
            }

            // 跳过重复的元素
            while (i < len - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return res;
    }

    // Three Sum 思路
    // 注意：这里不能直接套用 Three Sum 的代码
    // 部分的细节需要再次思考和修改
    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length - start; // 注意 len 的长度
        if (len < 3) {
            return res;
        }

        for (int k = start; k < nums.length - 2; k++) {
            if (k > start && nums[k] == nums[k - 1]) {
                continue; // 排除掉重复元素
            }

            // 设置双指针
            int left = k + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (sum < target) {
                    while (left < right && nums[left] == nums[++left]) ;// 跳过重复的数字
                } else if (sum > target) {
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
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        List<List<Integer>> res = new Solution1().fourSum(nums, -11);
        for (List<Integer> list : res) {
            System.out.println(list);
        }

        int[] nums1 = {0, 0, 0, 0};
        List<List<Integer>> res1 = new Solution1().fourSum(nums1, 0);
        for (List<Integer> list : res1) {
            System.out.println(list);
        }
    }
}
