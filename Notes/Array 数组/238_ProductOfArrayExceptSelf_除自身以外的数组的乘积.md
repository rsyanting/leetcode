

# 238_ProductOfArrayExceptSelf_除自身以外的数组的乘积

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/product-of-array-except-self/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/product-of-array-except-self/)

📗Difficulty： **Medium**	

🎯Tags：

+ **[Array](https://leetcode-cn.com/tag/array/)**



---

## 📃题目描述

给你一个长度为 `n` 的整数数组 `nums`，其中 `n > 1`，返回输出数组 `output` ，其中 `output[i]` 等于 `nums` 中除 `nums[i]` 之外其余各元素的乘积。

**样例 1：**

```
输入: [1,2,3,4]
输出: [24,12,8,6]
```

**提示：**

+ 题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
+ **说明:** 请**不要使用除法，**且在 O(*n*) 时间复杂度内完成此题。

**进阶：**

+ 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组**不被视为**额外空间。）



## 🏹🎯解题思路

前缀积 和 后缀积 思想。

给定一个数组`[1,2,3,4]`，对于 `index = 1` 的数组来说，即对 `2` 来说，其前缀积为 `1`，其后缀积为 `12` ，该位置的数值为 `前缀积 * 后缀积`。

如果有 2 个数组保存前缀积 和 后缀积，然后对其进行乘法操作即可。

#### 代码实现

```java
public int[] productExceptSelf(int[] nums) {
    int[] prefix1 = new int[nums.length];
    int[] prefix2 = new int[nums.length];
    int t = 1;
    for (int i = 0; i < nums.length; i++) {
        prefix1[i] = t;
        t = t * nums[i];
    }
    t = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
        prefix2[i] = t;
        t = t * nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
        prefix1[i] = prefix1[i] * prefix2[i];
    }
    return prefix1;
}
```



#### 复杂度分析

+ 时间复杂度： `O(n)`  。
+ 空间复杂度： `O(n)`  。



### 优化算法

后缀和的计算采取 逆序index遍历 的方式，一边遍历一边计算。

#### 代码实现

```java
public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    int t = 1;
    for (int i = 0; i < nums.length; i++) {
        res[i] = t;
        t = t * nums[i];
    }
    t = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
        res[i] = t * res[i];
        t = t * nums[i];
    }
    return res;
}
```



#### 复杂度分析

+ 时间复杂度： `O(n)`  。
+ 空间复杂度： `O(1)`  。



## 💡总结

前缀和 后缀和 思想。



