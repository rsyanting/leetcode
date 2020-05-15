package ltd.ryantech.string.ransomNote383;

import java.util.HashMap;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.string.ransomNote383
 * @description 赎金信件
 * @leetcode_CN_url // https://leetcode-cn.com/problems/ransom-note/
 * @leetcode_US_url // https://leetcode.com/problems/ransom-note/
 * @hard_level Easy
 * @tag string // https://leetcode-cn.com/tag/string/
 * @create 2020/05/04 09:58
 **/

public class Solution2 {
    // 字符数组计数器
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] times = new int[26];
        for (char key : magazine.toCharArray()) {
            times[key - 'a']++;
        }
        for (char key : ransomNote.toCharArray()) {
            if (--times[key - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "abbc";
        String magazine = "abbbccc";
        System.out.println(new Solution2().canConstruct(ransomNote, magazine));
    }
}
