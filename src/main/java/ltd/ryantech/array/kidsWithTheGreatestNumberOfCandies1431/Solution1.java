package ltd.ryantech.array.kidsWithTheGreatestNumberOfCandies1431;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.kidsWithTheGreatestNumberOfCandies1431
 * @description 拥有最多糖果的孩子
 * @leetcode_CN_url // https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 * @leetcode_US_url // https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * @hard_level Easy
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/06/01 14:48
 **/

public class Solution1 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;
        for (int num : candies) {
            maxCandies = Math.max(num, maxCandies);
        }
        List<Boolean> res = new LinkedList<>();
        for (int num : candies) {
            if (num + extraCandies >= maxCandies) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> res = new Solution1().kidsWithCandies(candies, extraCandies);
        for (Boolean i : res) {
            System.out.println(i);
        }
    }
}
