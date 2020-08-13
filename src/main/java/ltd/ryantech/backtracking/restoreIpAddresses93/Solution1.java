package ltd.ryantech.backtracking.restoreIpAddresses93;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.backtracking.restoreIpAddresses93
 * @description 93. 复原IP地址
 * @leetcode_CN_url // https://leetcode-cn.com/problems/restore-ip-addresses/
 * @leetcode_US_url // https://leetcode.com/problems/restore-ip-addresses/
 * @hard_level Medium
 * @tag Back Tracking // https://leetcode-cn.com/tag/backtracking/
 * @create 2020/08/09 10:24
 **/

public class Solution1 {
    List<String> res = new LinkedList<>();
    Deque<String> subRes = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0);  // dfs入口
        return res;
    }

    public void dfs(String s, int start) {    // 复原从start开始的子串
        if (subRes.size() == 4 && start == s.length()) {  // 满4段，且用光所有字符
            // 4段拼成字符串 推入结果 list
            StringBuilder sb = new StringBuilder();
            // 错误的代码，会导致问题。想一想这是为什么？
//            while (subRes.size() > 1) {
//                sb.append(subRes.removeFirst()).append(".");
//            }
//            sb.append(subRes.removeFirst());
            for (String seg : subRes) {
                sb.append(seg).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        if (subRes.size() == 4 && start < s.length())    // 满4段，但还没用光字符
            return;                                      // 直接返回
        for (int len = 1; len <= 3; len++) {             // 三种长度的选择
            if (start + len - 1 >= s.length()) return;   // 字符不存在，超出边界了
            if (len != 1 && s.charAt(start) == '0') return;     // 不能是0x 0xx
            String str = s.substring(start, start + len); // 当前选择切出的片段
            if (len == 3 && Integer.parseInt(str) > 255) return;          // 不能超过255
            subRes.addLast(str);                          // 作出选择
            dfs(s, start + len);             // 基于这种选择，向下选择
            subRes.removeLast();                          // 发现这种选择不行，撤销
        }
    }

    public static void main(String[] args) {
        List<String> res = new Solution1().restoreIpAddresses("25525511135");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
