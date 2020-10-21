package ltd.ryantech.twoPointer.longPressedName925;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.longPressedName925
 * @description 925. 长按键入
 * @leetcode_CN_url https://leetcode-cn.com/problems/long-pressed-name/
 * @hard_level Easy
 * @tag Two Pointer // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/10/21 13:26
 **/

public class Solution2 {
    // 双指针思路
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                // typed 中遇到了重复的字符
                j++;
            } else {
                // 不匹配的情况，返回 false
                return false;
            }
        }

        // 如果最后 i 等于 name.length() 每个元素都被匹配上了
        return i == name.length();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        String name = "kikcxmvzi";
        String typed = "kiikcxxmmvvzz";
        System.out.println("false ? " + solution2.isLongPressedName(name, typed));

        String name1 = "alex";
        String typed1 = "aaleex";
        System.out.println("true ? " + solution2.isLongPressedName(name1, typed1));

        String name2 = "saeed";
        String typed2 = "ssaaedd";
        System.out.println("false ? " + solution2.isLongPressedName(name2, typed2));

        String name3 = "leelee";
        String typed3 = "lleeelee";
        System.out.println("true ? " + solution2.isLongPressedName(name3, typed3));

        String name4 = "laiden";
        String typed4 = "laiden";
        System.out.println("true ? " + solution2.isLongPressedName(name4, typed4));
    }
}
