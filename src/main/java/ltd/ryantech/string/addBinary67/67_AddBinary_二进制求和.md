

# 67_AddBinary_二进制求和

## 📌题目详情

[leetcode 题目地址](https://leetcode-cn.com/problems/add-binary/)

[leetcode-cn 题目地址](https://leetcode.com/problems/add-binary/)

📗Difficulty：**Easy**	

🎯Tags：

+ **[数学](https://leetcode-cn.com/tag/math/)**
+ **[字符串](https://leetcode-cn.com/tag/string/)**

---

## 📃题目描述

给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 **非空** 字符串且只包含数字 `1` 和 `0`。



**样例 1：**

```
输入: a = "11", b = "1"
输出: "100"
```



**样例 2：**

```
输入: a = "1010", b = "1011"
输出: "10101"
```



**提示：**

- 每个字符串仅由字符 `'0'` 或 `'1'` 组成。
- `1 <= a.length, b.length <= 10^4`
- 字符串如果不是 `"0"` ，就都不含前导零。

---

## 🏹🎯解题思路

### 竖式模拟

需要注意，最后要判断最后一个进位是否需要加上去。



#### 代码实现

```java
// 重构 竖式 模拟计算
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? ((a.charAt(a.length() - 1 - i)) - '0') : 0;
            carry += i < b.length() ? ((b.charAt(b.length() - 1 - i)) - '0') : 0;
            sb.append((char) (carry % 2 + '0')); // '0' + 1 -> 1(int)
            carry /= 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
```



#### 复杂度分析

+ 时间复杂度： `O(n)` 。
+ 空间复杂度：`O(n)`  。



## 💡总结



