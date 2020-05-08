package ltd.ryantech.hashmap.wordPattern290;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.hashmap.wordPattern
 * @description
 * @create 2020/04/25 23:27
 **/

public class Solution1 {
    // https://leetcode-cn.com/problems/word-pattern/
    // https://leetcode.com/problems/word-pattern/
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        String[] strArray = str.split("\\s");
        if (pattern.length() != strArray.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char cur = pattern.charAt(i);
            if (!hashMap.containsKey(cur)) {
                if (hashSet.contains(strArray[i])) {
                    return false;
                }
                hashMap.put(cur, strArray[i]);
                hashSet.add(strArray[i]);
            } else {
                if (!hashMap.get(cur).equals(strArray[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(new Solution1().wordPattern(pattern, str));
    }
}
