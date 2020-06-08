

# 461_HammingDistance_汉明距离

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/hamming-distance/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/hamming-distance/)

📗Difficulty： **Easy**	

🎯Tags：

+ **[Bit Manipulation](https://leetcode-cn.com/tag/bit-manipulation/)** 



---

## 📃题目描述

两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 `x` 和 `y`，计算它们之间的汉明距离。

注意：
`0 ≤ x, y < 2^31`。



**样例 1：**

```
输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。
```



****

## 🏹🎯解题思路

#### 利用 bitCount API 

直接 `XOR` 异或之后，计算异或的结果中的 `1` 的数量即可。



#### 代码实现

```java
public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }
```



#### 复杂度分析

+ 时间复杂度：`O(1)`  。
+ 空间复杂度：`O(1)`  。



#### (n & n - 1) 反转最后一位的 1

[191. 位1的个数](https://leetcode-cn.com/problems/number-of-1-bits/) 的解法之一。

![n & n - 1 图示](https://assets.ryantech.ltd/abfd6109e7482d70d20cb8fc1d632f90eacf1b5e89dfecb2e523da1bcb562f66-image.png)



#### 代码实现

```java
public int hammingDistance(int x, int y) {
    int xor = x ^ y;
    int ans = 0;
    while (xor != 0) {
        if (xor % 2 == 1) {
            ans++;
        }
        xor = xor >> 1;
    }
    return ans;
}
```



#### 复杂度分析

+ 时间复杂度：`O(1)`  。
+ 空间复杂度：`O(1)`  。




## 💡总结

### 相似题目

[477. 汉明距离总和](https://leetcode-cn.com/problems/total-hamming-distance/)



