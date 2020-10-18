package ltd.ryantech.backtracking.phoneNumber17;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.backtracking.phoneNumber17
 * @description 17. 电话号码的字母组合
 * @leetcode_CN_url // https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @hard_level Medium
 * @tag Back Tracking // https://leetcode-cn.com/tag/backtracking/
 * @create 2020/10/18 19:38
 **/

public class Solution1 {
    // 全排列问题
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        int len = digits.length();
        Deque<Character> path = new ArrayDeque<>();
        // 建立字母映射
        Map<Integer, char[]> map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});

        dfs(digits, len, 0, map, path, res);

        return res;
    }

    private void dfs(String digits, int len, int depth, Map<Integer, char[]> map, Deque<Character> path, List<String> res) {
        // 递归结束的条件
        if (depth == len) {
            StringBuilder sb = new StringBuilder();
            for (char c : path) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }

        char digit = digits.charAt(depth);
        char[] chars = map.get(Integer.parseInt(String.valueOf(digit)));
        // 全排列
        for (char aChar : chars) {
            path.addLast(aChar);
            dfs(digits, len, depth + 1, map, path, res); // 选取下一个字母
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        String s = "23";
        List<String> res = new Solution1().letterCombinations(s);
        for (String s1 : res) {
            System.out.println(s1);
        }
    }
}
