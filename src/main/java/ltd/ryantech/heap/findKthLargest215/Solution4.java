package ltd.ryantech.heap.findKthLargest215;

import java.util.Random;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.heap.findKthLargest215
 * @description 215. 数组中的第K个最大元素
 * @leetcode_CN_url // https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @leetcode_US_url // https://leetcode.com/problems/kth-largest-element-in-an-array/
 * @hard_level Medium
 * @tag Heap // https://leetcode-cn.com/tag/heap/
 * @create 2020/06/17 19:54
 **/

public class Solution4 {
    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index < target) {
                left = index + 1;
            } else if (index > target) {
                right = index - 1;
            } else {
                return nums[index];
            }
        }
    }

    // 在区间 [left, right] 这个区间执行 partition 操作

    private int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int res = new Solution4().findKthLargest(arr, 2);
        System.out.println(res);
    }
}
