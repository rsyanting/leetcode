package ltd.ryantech.array.majorityElement169;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.majorityElement169
 * @description 169. 多数元素
 * @leetcode_CN_url // https://leetcode-cn.com/problems/majority-element/
 * @leetcode_US_url // https://leetcode.com/problems/majority-element/
 * @hard_level Easy
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/06/16 11:17
 **/

public class Solution3 {
    // 摩尔投票算法
    public int majorityElement(int[] nums) {
        int major = Integer.MIN_VALUE;
        int counter = 0;
        for (int num : nums) {
            if (counter == 0) {
                major = num;
            }
            if (major == num) {
                counter++;
            } else {
                counter--;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int ans = new Solution3().majorityElement(nums);
        System.out.println(ans);
    }
}
