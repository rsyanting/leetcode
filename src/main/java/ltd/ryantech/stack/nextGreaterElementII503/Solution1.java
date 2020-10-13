package ltd.ryantech.stack.nextGreaterElementII503;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.nextGreaterElementII503
 * @description 503. 下一个更大元素 II
 * @leetcode_CN_url // https://leetcode-cn.com/problems/next-greater-element-ii/
 * @hard_level Medium
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/13 14:53
 **/

public class Solution1 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len];
        for (int i = len * 2 - 1; i >= 0; i--) { // 倒着往栈里放
            int t = nums[i % len];
            while (!stack.isEmpty() && stack.peekLast() <= t) { // 判定个子高矮
                stack.pollLast(); // // 矮个起开，反正也被挡着了...
            }
            res[i % len] = stack.isEmpty() ? -1 : stack.peekLast(); // 这个元素身后的第一个高个
            stack.offerLast(nums[i % len]); // 进栈，接受之后的身高判定
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(solution1.nextGreaterElements(nums)));

        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution1.nextGreaterElements(nums1)));
    }
}
