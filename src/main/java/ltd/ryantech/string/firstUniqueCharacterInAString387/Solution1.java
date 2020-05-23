package ltd.ryantech.string.firstUniqueCharacterInAString387;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.string.firstUniqueCharacterInAString387
 * @description 字符串中的第一个唯一字符
 * @leetcode_CN_url // https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @leetcode_US_url // https://leetcode.com/problems/first-unique-character-in-a-string/
 * @hard_level Easy
 * @tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/05/23 11:54
 **/

public class Solution1 {
    public int firstUniqChar(String s) {
        int[] keys = new int[26];
        for (char key : s.toCharArray()) {
            keys[key - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (keys[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().firstUniqChar("loveleetcode"));
    }
}
