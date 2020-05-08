package ltd.ryantech.hashmap.twoSums1;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.hashmap.twoSums1
 * @description
 * @create 2020/04/25 23:31
 **/

public class Solution2 {
    public static int[] twoSum(int[] nums, long target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
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
        long target = (limit - 2) * 2 + 1;
        int[] ans;
        long startTime = System.currentTimeMillis();
        ans = twoSum(nums, target);
        long endTime = System.currentTimeMillis();
        System.out.println("Time used is : " + (endTime - startTime));
        System.out.println(ans[0] + " " + ans[1]);

    }
}
