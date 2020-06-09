

# 477_TotalHammingDistance_汉明距离总和

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/total-hamming-distance/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/total-hamming-distance/)

📗Difficulty： **Easy**	

🎯Tags：

+ **[Bit Manipulation](https://leetcode-cn.com/tag/bit-manipulation/)** 



---

## 📃题目描述

两个整数的 [汉明距离](https://baike.baidu.com/item/汉明距离/475174?fr=aladdin) 指的是这两个数字的二进制数对应位不同的数量。

计算一个数组中，任意两个数之间汉明距离的总和。



**样例 1：**

```
输入: 4, 14, 2

输出: 6

解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
所以答案为：
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
```



**注意:**

1. 数组中元素的范围为从 `0`到 `10^9`。
2. 数组的长度不超过 `10^4`。

****

## 🏹🎯解题思路

### 双重循环模拟组合

对 2 个数字的汉明距离计算，参考 [461. 汉明距离](https://leetcode-cn.com/problems/hamming-distance/) 的做法，时间复杂度为 `O(1)` 。

然后使用双重循环来模拟 组合，复杂度 `O(n ^ 2)` ，超时……



#### 代码实现

```java
// O(n ^ 2) 超时
public int totalHammingDistance(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            sum += hammingDistance(nums[i], nums[j]);
        }
    }
    return sum;
}

public int hammingDistance(int x, int y) {
    int xor = x ^ y;
    return Integer.bitCount(xor);
}
```



#### 复杂度分析

+ 时间复杂度： `O(n ^ 2)`。双重循环，模拟全部的组合。
+ 空间复杂度： `O(1)` 。



### 考虑二进制中的每一位

> 以下题解来自于 [leetcode-cn 官方题解](https://leetcode-cn.com/problems/total-hamming-distance/solution/yi-ming-ju-chi-zong-he-by-leetcode/)，感谢工作人员的编写。

思考这样一个问题，有 2 组数据，A 组数据中有 2 个数字，B 组数据中有 3 个数字，现在要求从A，B中各取出 1 个数据，组合在一起，请问有多少种组合？

这是一个全排列问题，有 2 * 3 种组合。

思考下面的问题，对于下面 3 个数字，其最高位的 二进制 位，将为 1 的分到 A 组，为 0 的分到 B 组中去。根据汉明距离的定义，只有 `1，0 之间`的汉明距离为 1，`1 和 1` 以及 `0 和 0` 的汉明距离为 0，那么就等于的全排列问题。

```
4  -> 0100
14 -> 1110
2  -> 0010
sum = 1 * (3  - 1) + 2 * (3 - 2) + 2 * (3 - 2) = 2 + 2 + 2 = 6
```



#### 代码实现

```java
int totalHammingDistance(int[] nums) {
    if (nums.length == 0)
        return 0;

    int ans = 0, length = nums.length;
    int[] cnt = new int[32];         // count of elements with a particular bit ON

    for (int num : nums) {         // loop over every element
        int idx = 0;
        while (num > 0) {           // check every bit
            cnt[idx] += (num & 0x1);
            num >>= 1;
            idx++;
        }
    }

    for (int k : cnt) {           // loop over every bit count
        ans += k * (length - k);
    }

    return ans;
}
```



#### 复杂度分析

+ 时间复杂度： `O(n)`。遍历数组中的每个元素。
+ 空间复杂度： `O(1)` 。确定的空间。

## 💡总结

### 相似题目

[461. 汉明距离](https://leetcode-cn.com/problems/hamming-distance/)

