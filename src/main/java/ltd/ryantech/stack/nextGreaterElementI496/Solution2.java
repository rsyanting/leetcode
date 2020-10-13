package ltd.ryantech.stack.nextGreaterElementI496;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.nextGreaterElementI496
 * @description 496. 下一个更大元素 I
 * @leetcode_CN_url // https://leetcode-cn.com/problems/next-greater-element-i/
 * @hard_level Easy
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/13 14:33
 **/

public class Solution2 {
    // 单调栈 法
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>(); // 使得查找速度更快
        Deque<Integer> stack = new LinkedList<>();

        for (int t : nums2) {
            while (!stack.isEmpty() && t > stack.peekLast()) {
                map.put(stack.pollLast(), t);
            }
            stack.offerLast(t);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pollLast(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] res = new Solution2().nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
