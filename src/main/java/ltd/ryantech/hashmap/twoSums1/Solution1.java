package ltd.ryantech.hashmap.twoSums1;

import java.util.HashMap;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.hashmap.twoSums1
 * @description
 * @create 2020/04/25 23:30
 **/

public class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            /** map 的 key 为 nums 数组中的数
             *  每次循环都检查一次，map 中是否包含 target - nums[i]
             *  因为题目已经假定只有一个解答，如果有，则将 index 写到 ans 数组中
             *  如果没有找到匹配的 index ，那么将这个 nums[i] 放入 hashMap 的 key 中
             */
            if (hashMap.containsKey(target - nums[i])) {
                ans[0] = hashMap.get(target - nums[i]);
                ans[1] = i;
                return ans;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int limit = 200000;
        int[] nums = new int[limit];
        for (int i = 0; i < limit; i++) {
            nums[i] = i;
        }
        int target = (limit - 2) * 2 + 1;
        int[] ans = new int[2];
        long startTime = System.currentTimeMillis();
        ans = twoSum(nums, target);
        long endTime = System.currentTimeMillis();
        System.out.println("Time used is : " + (endTime - startTime));
        System.out.println(ans[0] + " " + ans[1]);
    }

}
