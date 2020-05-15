package ltd.ryantech.array.subarraySumEqualsK560;

import java.util.HashMap;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.subarraySumEqualsK560
 * @description 和为 K 的子数组
 * @leetcode_CN_url // https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @leetcode_US_url // https://leetcode.com/problems/subarray-sum-equals-k/
 * @hard_level Medium
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/05/15 15:31
 **/

public class Solution1 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int res = 0;
        hashMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (hashMap.containsKey(sum - k)) {
                res += hashMap.get(sum - k); // 加上部分和的次数
            }
            // 每次对部分和的处理
            if (hashMap.containsKey(sum)) {
                hashMap.put(sum, hashMap.get(sum) + 1); // 部分合已经存在 即更新
            } else {
                hashMap.put(sum, 1); // 存入新的部分合
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(new Solution1().subarraySum(nums, 2));
    }
}
