

# 10_RegularExpressionMatching_正则表达式匹配

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/regular-expression-matching/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/regular-expression-matching/)

📗Difficulty： **Hard**

🎯Tags：

+ **[Dynamic Programming](https://leetcode.com/tag/dynamic-programming/)**
+ **[String](https://leetcode.com/tag/string/)**

---

## 📃题目描述

给你一个字符串 `s` 和一个字符规律 `p`，请你来实现一个支持 `'.'` 和 `'*'` 的正则表达式匹配。

```
'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
```

所谓匹配，是要涵盖 **整个** 字符串 `s`的，而不是部分字符串。

**说明：**

+ `s` 可能为空，且只包含从 `a-z` 的小写字母。
+ `p` 可能为空，且只包含从 `a-z` 的小写字母，以及字符 `.` 和 `*`。



**样例 1：**

```
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
```



**样例 2：**

```
输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
```



**样例 2：**

```
输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
```



**样例 3：**

```
输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
```



**样例 4：**

```
输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
```



**样例 5：**

```
输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
```



## 🏹🎯解题思路



#### 代码实现

```java
// 来自 《leetcode && 拉钩网  300 分钟搞定算法面试》
// 不是特别好的递归算法，其中细节考虑很多
public class Solution1 {
    // 从前往后进行分析，进行递归操作
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();

        // 递归结束的时间：j 遍历完 p 字符串，即可跳出递归
        // 如果 i 也刚好完成遍历，那么 s 和 p 完全匹配
        if (j == n) {
            return i == m;
        }

        // j 的后一个字符不是 '*' , 直接递归调用 isMatch 方法即可
        if (j == n - 1 || p.charAt(j + 1) != '*') {
            // i < m , 在 p 比 s 长的情况，此时也不匹配
            return (i < m) && firstMatch(s, i, p, j) && isMatch(s, i + 1, p, j + 1);
        }

        // j 的后一个字符是 '*'
        // 一种特殊的情况是，'*' 是最后一个字符
        if (j < n - 1 && p.charAt(j + 1) == '*') {
            // while 循环是本题核心
            while ((i < m) && firstMatch(s, i, p, j)) {
                if (isMatch(s, i, p, j + 2)) {
                    return true;
                }
                // 如果无法匹配
                // 尝试用星号组合去匹配更长的一段字符串
                i++;
            }
        }

        // 当 i 和 j 指向字符不相同
        // 或 i 已经遍历完 s 字符串，同时 j 指向的字符后面跟着一个 '*' 的情况
        // 使用 '*' 号组合表示为一个空字符串，然后递归下去
        if (((i < m) && !firstMatch(s, i, p, j)) || (i == m && p.charAt(j + 1) == '*')) {
            return isMatch(s, i, p, j + 2);
        }

        // 初始调用输入为 i,j 为超过 实际长度的 情况，返回 false
        return false;
    }

    public boolean firstMatch(String s, int i, String p, int j) {
        // 判断 i,j 指针所指字符是否相等
        // 如果 j 位置字符为 '.' , 那么也认为是相等的
        return p.charAt(j) == '.' || s.charAt(i) == p.charAt(j);
    }

    public static void main(String[] args) {
        String s1 = "aa";
        String p1 = "a";
        System.out.println(new Solution1().isMatch(s1, p1));

        String s2 = "aa";
        String p2 = "a*";
        System.out.println(new Solution1().isMatch(s2, p2));

        String s3 = "ab";
        String p3 = ".*";
        System.out.println(new Solution1().isMatch(s3, p3));

        String s4 = "aab";
        String p4 = "c*a*b";
        System.out.println(new Solution1().isMatch(s4, p4));

        String s5 = "mississippi";
        String p5 = "mis*is*p*.";
        System.out.println(new Solution1().isMatch(s5, p5));

        String s6 = "ssippi";
        String p6 = "s*p*.";
        System.out.println(new Solution1().isMatch(s6, p6));

    }
}
```



#### 复杂度分析

+ 时间复杂度：
+ 空间复杂度：



## 💡总结



