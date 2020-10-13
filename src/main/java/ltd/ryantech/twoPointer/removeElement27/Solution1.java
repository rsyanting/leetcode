package ltd.ryantech.twoPointer.removeElement27;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.removeElement27
 * @description 27. 移除元素
 * @leetcode_CN_url // https://leetcode-cn.com/problems/remove-element/
 * @leetcode_US_url // https://leetcode.com/problems/remove-element/
 * @hard_level Easy
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/10/11 23:39
 **/

public class Solution1 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new Solution1().removeElement(nums, 2));
    }
}
