package ltd.ryantech.array.majorityElement169;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.majorityElement169
 * @description
 * @create 2020/06/16 13:02
 **/

public class Solution4 {
    public int majorityElement(int[] nums) {
        return quickSearch(nums, 0, nums.length - 1, nums.length / 2);
    }

    private int quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于n/2就返回；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return nums[j];
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int ans = new Solution4().majorityElement(nums);
        System.out.println(ans);
    }
}
