package ltd.ryantech.twoPointer.threeSums15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.threeSums15
 * @description
 * @create 2020/06/12 21:19
 **/

public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    while (i < j) {
                        if (nums[i] == nums[i + 1]) {
                            i++;
                        }
                    }
                } else if (sum > 0) {
                    while (i < j) {
                        if (nums[j] == nums[j - 1]) {
                            j--;
                        }
                    }
                } else {
                    ans.add(new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while (i < j) {
                        if (nums[i] == nums[i + 1]) {
                            i++;
                        }
                    }
                    i++;
                    while (i < j) {
                        if (nums[j] == nums[j - 1]) {
                            j--;
                        }
                    }
                    j--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
