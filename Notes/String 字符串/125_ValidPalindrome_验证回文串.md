

# 125_ValidPalindrome_验证回文串

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/valid-palindrome/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/valid-palindrome/)

📗Difficulty：**Easy**	

🎯Tags：

+ **[Two Pointers](https://leetcode.com/tag/two-pointers/)** 
+ **[String](https://leetcode.com/tag/string/)**

---

## 📃题目描述：

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

**说明：**本题中，我们将空字符串定义为有效的回文串。



**样例 1：**

```
输入: "A man, a plan, a canal: Panama"
输出: true
```



**样例 2：**

```
输入: "race a car"
输出: false
```

****

## 🏹🎯解题思路

### 双指针策略

一个指向 `string` 前部，一个指向 `string` 后部，遇到“非法”（非字母和数字）就相应移动指针，每次比较“合法”位置指针上的值，不相等就返回 `false` 。

```java
// 双指针
// 优化解，使用内建 API
public boolean isPalindrome(String s) {
    int front = 0;
    int end = s.length() - 1;
    while (front < end) {
        while (front < end && !Character.isLetterOrDigit(s.charAt(front))) {
            front++;
        }
        while (front < end && !Character.isLetterOrDigit(s.charAt(end))) {
            end--;
        }

        if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
            return false;
        }
        front++;
        end--;
    }
    return true;
}
```



#### 复杂度分析

+ 时间复杂度：`O(n)`。
+ 空间复杂度：`O(1)`。

### 双指针 非 API 解法

```java
public boolean isPalindrome(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        if (isLetter(s.charAt(i))) {
            stringBuilder.append(s.charAt(i));
        }
    }
    char[] stringArray = stringBuilder.toString().toCharArray();
    // 特判
    if (stringArray.length <= 1) {
        return true;
    }
    int front = 0;
    int end = stringArray.length - 1;
    while (front <= end) {
        char t_front = toLowerLetter(stringArray[front]);
        char t_end = toLowerLetter(stringArray[end]);
        if (t_front != t_end) {
            return false;
        }
        front++;
        end--;
    }
    return true;
}

private boolean isUpperLetter(char c) {
    return (c >= 'A' && c <= 'Z');
}

private boolean isLowerLetter(char c) {
    return (c >= 'a' && c <= 'z');
}

private boolean isDigital(char c) {
    return (c >= '0' && c <= '9');
}

private boolean isLetter(char c) {
    return isUpperLetter(c) || isLowerLetter(c) || isDigital(c);
}

private char toLowerLetter(char c) {
    if (isUpperLetter(c)) {
        return (char) ('a' + (c - 'A'));
    }
    return c;
}
```



## 💡总结：

### 相似题目

#### [680. 验证回文字符串 Ⅱ](https://leetcode-cn.com/problems/valid-palindrome-ii/)

>  给定一个非空字符串 `s`，**最多**删除一个字符。判断是否能成为回文字符串。 
>
> ```
> 示例 1：
> 输入: "aba"
> 输出: True
> ```
>
> ```
> 示例 2：
> 输入: "abca"
> 输出: True
> 解释: 你可以删除c字符。
> ```
>
> 注意： 字符串只包含从 `a-z` 的小写字母。字符串的最大长度是 50000。 



#### [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)

>  请判断一个链表是否为回文链表。 
>
> ```
> 示例 1：
> 输入: 1->2
> 输出: false
> ```
>
> ```
> 示例 2：
> 输入: 1->2->2->1
> 输出: true
> ```

