package ltd.ryantech.dynamicProgramming.isSubsequence392;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.dynamicProgramming.isSubsequence392
 * @description 392. 判断子序列
 * @leetcode_CN_url // https://leetcode-cn.com/problems/is-subsequence/
 * @leetcode_US_url // https://leetcode.com/problems/is-subsequence/
 * @hard_level Easy
 * @tag Dynamic Programming // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/06/09 21:35
 **/

public class Solution2 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        } else if (t.length() == 0) {
            return false;
        }

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int idx = 0; idx < t.length(); idx++) {
            if (!map.containsKey(t.charAt(idx))) {
                List<Integer> pos = new ArrayList<>();
                pos.add(idx);
                map.put(t.charAt(idx), pos);
            } else {
                map.get(t.charAt(idx)).add(idx);
            }
        }

        int index = -1;
        for (int idx = 0; idx < s.length(); idx++) {
            if (!map.containsKey(s.charAt(idx))) {
                return false;
            } else {
                int left = 0;
                int right = map.get(s.charAt(idx)).size();
                List<Integer> list = map.get(s.charAt(idx));
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (list.get(mid) > index) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                // left 已经到最末尾了，还没找到，则返回 false
                if (left == list.size()) {
                    return false;
                }
                index = list.get(left); // 在后半部分找
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "b";
        String t = "tfdudhwuaabx";
        System.out.println(new Solution2().isSubsequence(s, t));
    }
}
