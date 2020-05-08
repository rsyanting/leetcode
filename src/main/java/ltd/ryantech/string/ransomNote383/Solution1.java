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
 * @tag string
 * @create 2020/05/04 09:55
 **/

public class Solution1 {
    // 哈希表计数
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> counter1 = new HashMap<>();
        for (char key : ransomNote.toCharArray()) {
            counter1.put(key, counter1.getOrDefault(key, 1) + 1);
        }
        HashMap<Character, Integer> counter2 = new HashMap<>();
        for (char key : magazine.toCharArray()) {
            counter2.put(key, counter2.getOrDefault(key, 1) + 1);
        }
        for (char key : counter1.keySet()) {
            if (!counter2.containsKey(key)) {
                return false;
            }
            if (counter1.get(key) > counter2.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "abbc";
        String magazine = "abbbccc";
        System.out.println(new Solution1().canConstruct(ransomNote, magazine));
    }
}
