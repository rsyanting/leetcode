package ltd.ryantech.binarySearch.sumOfMutatedArrayClosestToTarget1300;

import java.util.Arrays;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.binarySearch.sumOfMutatedArrayClosestToTarget1300
 * @description 1300. 转变数组后最接近目标值的数组和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/
 * @leetcode_US_url // https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 * @hard_level Medium
 * @tag Binary Search // https://leetcode-cn.com/tag/binary-search/
 * @create 2020/06/14 13:50
 **/

public class Solution1 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int length = arr.length;
        int[] prefix = new int[length + 1]; // 前缀和的处理技巧
        for (int i = 0; i < length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        int right = arr[length - 1];
        int left = 1;
        int ans = 0;
        int diff = target;
        for (int value = left; value <= right; value++) {
            /**
             *  第一次出现 value 的位置
             *  自建 API 的局限性，只能查询第一个出现的 target
             *  那么最后一个出现的位置如何写呢？
             */
            int mid = Arrays.binarySearch(arr, value);
            if (mid < 0) {
                mid = -mid - 1;
            }
            int curSum = prefix[mid] + (length - mid) * value;
            if (Math.abs(curSum - target) < diff) {
                ans = value;
                diff = Math.abs(curSum - target);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        System.out.println(Arrays.binarySearch(arr, 4));
        System.out.println(new Solution1().findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803));
    }
}
