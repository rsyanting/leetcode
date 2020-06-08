package ltd.ryantech.bitManipulation.totalHamingDistance477;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.bitManipulation.totalHamingDistance477
 * @description 477. 汉明距离总和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/total-hamming-distance/
 * @leetcode_US_url // https://leetcode.com/problems/total-hamming-distance/
 * @hard_level Medium
 * @tag Bit Manipulation // https://leetcode-cn.com/tag/bit-manipulation/
 * @create 2020/06/08 20:21
 **/

public class Solution2 {
    int totalHammingDistance(int[] nums) {
        if (nums.length == 0)
            return 0;

        int ans = 0, length = nums.length;
        int[] cnt = new int[32];         // count of elements with a particular bit ON

        for (int num : nums) {         // loop over every element
            int idx = 0;
            while (num > 0) {           // check every bit
                cnt[idx] += (num & 0x1);
                num = num >> 1;
                idx++;
            }
        }

        for (int k : cnt) {           // loop over every bit count
            ans += k * (length - k);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(new Solution2().totalHammingDistance(nums));
    }
}
