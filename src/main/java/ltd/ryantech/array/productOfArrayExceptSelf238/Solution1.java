package ltd.ryantech.array.productOfArrayExceptSelf238;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.productOfArrayExceptSelf238
 * @description 238. 除自身以外数组的乘积
 * @leetcode_CN_url // https://leetcode-cn.com/problems/product-of-array-except-self/
 * @leetcode_US_url // https://leetcode.com/problems/product-of-array-except-self/
 * @hard_level Medium
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/06/04 08:28
 **/

public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int t = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = t;
            t = t * nums[i];
        }
        t = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = t * res[i];
            t = t * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = new Solution1().productExceptSelf(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
