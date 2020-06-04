package ltd.ryantech.array.productOfArrayExceptSelf238;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.productOfArrayExceptSelf238
 * @description
 * @create 2020/06/04 10:29
 **/

public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix1 = new int[nums.length];
        int[] prefix2 = new int[nums.length];
        int t = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix1[i] = t;
            t = t * nums[i];
        }
        t = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefix2[i] = t;
            t = t * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            prefix1[i] = prefix1[i] * prefix2[i];
        }
        return prefix1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = new Solution2().productExceptSelf(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
