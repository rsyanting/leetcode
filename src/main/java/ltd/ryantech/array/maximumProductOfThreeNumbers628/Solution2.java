package ltd.ryantech.array.maximumProductOfThreeNumbers628;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.maximumProductOfThreeNumbers628
 * @description 三个数的最大乘积
 * @leetcode_CN_url // https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * @leetcode_US_url // https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * @hard_level Medium
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/05/18 19:55
 **/

public class Solution2 {
    // 优先队列
    // 空间复杂度不佳
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            maxQueue.offer(nums[i]);
            minQueue.offer(nums[i]);
        }
        int max1 = maxQueue.poll();
        int max2 = maxQueue.poll();
        int max3 = maxQueue.poll();
        int min1 = minQueue.poll();
        int min2 = minQueue.poll();
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Solution2().maximumProduct(nums));
    }
}
