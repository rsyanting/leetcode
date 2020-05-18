

# 152_MaximumProductSubarray_乘积最大子数组

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/maximum-product-subarray/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/maximum-product-subarray/)

📗Difficulty： **Medium**	

🎯Tags：

+ **[Dynamic Programming](https://leetcode.com/tag/dynamic-programming/)**

---

## 📃题目描述：

给你一个整数数组 `nums` ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 

**样例 1：**

```
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
```

**样例 2：**

```
输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
```

****

## 🏹🎯解题思路

一道非常相似的题目是：[53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/) ：

> 给定一个整数数组 `nums` ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

一个非常容易想到的算法是：部分和 。

```java
public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }

    int[] dp = new int[nums.length];
    int res = nums[0];
    dp[0] = nums[0];
    if (nums.length > 1) {
        for (int i = 1;i < nums.length;i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            res = Math.max(res,dp[i]);
        }
    }
    return res;
}
```

那么这道题是不是也可以这样“如法炮制”呢？按照上面的思路有这样的代码：

```java
// 部分积
// 未考虑负数情况
public int maxProduct(int[] nums) {
    int[] maxPrefix = new int[nums.length + 1];
    maxPrefix[0] = 1;
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
        maxPrefix[i + 1] = Math.max(maxPrefix[i] * nums[i], nums[i]);
        res = Math.max(maxPrefix[i + 1], res);
    }
    return res;
}
```

然而，给定的数组中包含了负数，这样的情况下，使用上述代码，无法处理 **“负负得正”**的情况。

其根本原因出现在状态转移方程之上，本题的状态转移方程和 [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/) 是不一样的。

### 寻找状态转移方程

对于 [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/) 来说，其转移方程为 ： `max（以前一个数结尾的最大值，当前元素）`。

分情况讨论：

+  考虑当前位置如果是一个负数的话
    + 那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样就可以负负得正，并且我们希望这个积尽可能「负得更多」，即尽可能小。 
+  如果当前位置是一个正数的话
    + 我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大 。

那么而本题的转移方程应该是这样：`max (以前一个元素结尾的最大积 * 当前元素，以前一个元素结尾的最小积 * 当前元素，当前元素 )` 和 `min (以前一个元素结尾的最大积 * 当前元素，以前一个元素结尾的最小积 * 当前元素，当前元素 )`。这样就可以处理“负负得正”的情况。

### 代码实现

```java
// DP 未优化版
public int maxProduct(int[] nums) {
    int[] maxPrefix = new int[nums.length + 1];
    int[] minPrefix = new int[nums.length + 1];
    maxPrefix[0] = 1;
    minPrefix[0] = 1;
    int res = Integer.MIN_VALUE;
    int t;
    for (int i = 0; i < nums.length; i++) {
        maxPrefix[i + 1] = Math.max(Math.max(maxPrefix[i] * nums[i], nums[i]), minPrefix[i] * nums[i]);
        minPrefix[i + 1] = Math.min(Math.min(minPrefix[i] * nums[i], nums[i]), maxPrefix[i] * nums[i]);
        t = res;
        res = Math.max(maxPrefix[i + 1], minPrefix[i + 1]);
        res = Math.max(t, res);
    }
    return res;
}
```

##### 复杂度分析

+ 时间复杂度：`O(n) `。遍历一次数组。
+ 空间复杂度：`O(n)` 。需要额外 2 个数组，长度为 nums.length + 1 来存储结果。

#### 优化空间复杂度

可以从上述代码发现， `maxPrefix[i + 1]` 的结果和  `maxPrefix[i]`，即前一个元素有关。

有一种思想称**“滚动数组”**，可以只用两个变量来维护 i 时刻的状态。

```java
// DP 优化版
public int maxProduct(int[] nums) {
    int preMaxPrefix = 1;
    int preMinPrefix = 1;
    int res = Integer.MIN_VALUE;
    int t;
    int curPreMaxPrefix;
    int curPreMinPrefix;
    for (int i = 0; i < nums.length; i++) {
        curPreMaxPrefix = Math.max(Math.max(preMaxPrefix * nums[i], nums[i]), preMinPrefix * nums[i]);
        curPreMinPrefix = Math.min(Math.min(preMinPrefix * nums[i], nums[i]), preMaxPrefix * nums[i]);
        t = res;
        res = Math.max(curPreMaxPrefix, curPreMinPrefix);
        res = Math.max(t, res);
        preMaxPrefix = curPreMaxPrefix; // 更新最新值
        preMinPrefix = curPreMinPrefix;
    }
    return res;
}
```

##### 复杂度分析

+ 时间复杂度：`O(n) `。遍历一次数组。
+ 空间复杂度：`O(1)` 。

## 💡总结：

### 相似题目

#### [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)

> 给定一个整数数组 `nums` ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 



#### [628. 三个数的最大乘积](https://leetcode-cn.com/problems/maximum-product-of-three-numbers/)

>  给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
>
>  给定的整型数组长度范围是[3,10^4]，数组中所有的元素范围是[-1000, 1000]。 
>
>  入的数组中任意三个数的乘积不会超出32位有符号整数的范围。 



#### [713. 乘积小于K的子数组](https://leetcode-cn.com/problems/subarray-product-less-than-k/)

> 给定一个正整数数组 `nums`。
>
> 找出该数组内乘积小于 `k` 的连续的子数组的个数。
>
> 示例 1：
>
> 输入: nums = [10,5,2,6], k = 100
> 输出: 8
> 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
> 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。





