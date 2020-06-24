package ltd.ryantech.array.majorityElement169;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.majorityElement169
 * @description 169. 多数元素
 * @leetcode_CN_url // https://leetcode-cn.com/problems/majority-element/
 * @leetcode_US_url // https://leetcode.com/problems/majority-element/
 * @hard_level Easy
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/06/16 11:13
 **/

public class Solution2 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
            if (counter.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int ans = new Solution2().majorityElement(nums);
        System.out.println(ans);
    }
}
