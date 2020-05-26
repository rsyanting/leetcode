

# 287_FindTheDuplicateNumber_寻找重复数

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/find-the-duplicate-number/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/find-the-duplicate-number/)

📗Difficulty： **Medium**	

🎯Tags：

+ **[Binary Search](https://leetcode-cn.com/tag/binary-search/)**

---

## 📃题目描述

给定一个包含 `n + 1` 个整数的数组 `nums`，其数字都在 `1` 到 `n` 之间（包括 `1` 和 `n`），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

**样例 1：**

```
输入: [1,3,4,2,2]
输出: 2
```



**样例 2：**

```
输入: [3,1,3,4,2]
输出: 3
```



**说明：**

1. **不能**更改原数组（假设数组是只读的）。
2. 只能使用额外的 `O(1)` 的空间。
3. 时间复杂度小于 `O(n ^ 2)` 。
4. 数组中只有一个重复的数字，但它可能不止重复出现一次。

****

## 🏹🎯解题思路

### 数组槽位哈希法

一种简单的思路是，额外开一个数组，将 `nums[i]` 依次和新数组中的对应下标位置上的数字进行比较，如果为 0 ，自增 1，表示有 1 个数字，下次访问到 `nums[i]` 不为 0 时，说明出现了重复的数字。

但是这种方法不满足 O(1) 的空间复杂度。

#### 代码实现

```java
// 额外开一个数组，检查是否某个数字出现重复
// 空间复杂度不达标
public int findDuplicate(int[] nums) {
    int[] ans = new int[nums.length];
    for (int num : nums) {
        if (ans[num] == 0) {
            ans[num]++;
        } else {
            return num;
        }
    }
    return -1;
}
```



#### 复杂度分析

+ 时间复杂度：`O(n)` 。最坏情况下，数组中每个数字遍历一次。
+ 空间复杂度：`O(n)`。需要一个额外等大的数组。



### 两分查找法

> 以下分析来自于 [leetcode-cn 用户 liweiwei1419](https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/)，特别感谢其带来的精彩分析，再次感谢！

> 需要指出的是，以下的分析建立在题目给定的特殊条件之下。在测试条件外的数据，此方法无效。

#### 额外的补充知识

> 抽屉原理：桌上有十个苹果，要把这十个苹果放到九个抽屉里，无论怎样放，我们会发现至少会有一个抽屉里面放不少于两个苹果。

**题目给出的限制：**

1. 不能更改原数组（假设数组是只读的）
2. 只能使用额外的 `O(1)` 的空间



**容易想到的方法有：**

- 使用哈希表判重，这违反了限制 2
- 将原始数组排序，排序以后，重复的数相邻，即找到了重复数，这违反了限制 1
- 使用类似「力扣」第 41 题：[缺失的第一个正数](https://leetcode-cn.com/problems/first-missing-positive) （**原地哈希**）的思路，当两个数发现要放在同一个地方的时候，就发现了这个重复的元素，这违反了限制 1
- 既然要定位数，这个数恰好是一个整数，可以在「整数的有效范围内」做二分查找，但是比较烦的一点是得反复看整个数组好几次，本题解就介绍通过二分法定位一个有范围的整数



#### 思路解析

这道题要求我们查找的数是一个整数，并且给出了这个整数的范围（在 1 和 n 之间，包括 1 和 n），并且给出了一些限制，于是可以使用二分查找法定位在一个区间里的整数。

二分法的思路是先猜一个数（有效范围 `[left, right]`里的中间数 `mid`），然后统计原始数组中小于等于这个中间数的元素的个数 `cnt`，如果 `cnt` 严格大于 `mid`，（注意我加了着重号的部分「小于等于」、「严格大于」）。根据抽屉原理，重复元素就在区间 `[left, mid]` 里。

与绝大多数二分法问题的不同点是：正着思考是容易的，即：思考哪边区间存在重复数是容易的，因为有抽屉原理做保证。



以 `[2, 4, 5, 2, 3, 1, 6, 7]` 为例，一共 `8` 个数，`n + 1 = 8`，`n = 7`，根据题目意思，每个数都在 `1` 和 `7` 之间。

例如：区间 `[1, 7]` 的中位数是 `4`，遍历整个数组，统计小于等于 `4` 的整数的个数，最多为 `5` 个，等于 `4` 的时候也可能有重复。但是，如果整个数组里小于等于 `4` 的整数的个数如果严格大于 `4` 个，就说明重复的数存在于区间 `[1, 4]`。

#### 代码实现

```java
// 两分查找法
// 时间复杂度 O(n * log n)
// 空间复杂度 O(1)
public int findDuplicate(int[] nums) {
    int length = nums.length;
    int left = 0, right = length - 1;

    while (left < right) {
        int cnt = 0;
        int mid = left + (right - left + 1) / 2; // int mid = (left + right) >>> 1;
        for (int num : nums) {
            if (num <= mid) {
                cnt++;
            }
        }

        // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
        // 此时重复元素一定出现在 [1, 4] 区间里
        if (cnt > mid) {
            // 重复元素位于区间 [left, mid]
            right = mid;
        } else {
            // if 分析正确了以后，else 搜索的区间就是 if 的反面
            // [mid + 1, right]
            left = mid + 1;
        }
    }
    return left;
}
```

+ 第一次循环，`left = 1`，`right = 7`，`mid = 4`，`cnt = 5`，说明重复的元素在左区间。
+ 第二次循环，`left = 1`，`right = 4`，`mid = 2`，`cnt = 3`，说明重复的元素在左区间。
+ 第三次循环，`left = 1`，`right = 2`，`mid = 1`，`cnt = 1`，说明重复的元素在右区间。
+ 第四次循环，`left = 2`，`right = 2` 不满足外围 while 循环，`return left`。



#### 复杂度分析

+ 时间复杂度：`O(n log n)` 。两分查找复杂度为 `O(log n)`。统计一次个数，复杂度为 `O(n)` 。
+ 空间复杂度：`O(1)`。

本题为[《剑指 Offer》 中的 面试题 3](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/) 的一个变种问题，在书中有解释其做法，为两分查找法。



![剑指Offer 中的额外说明](https://assets.ryantech.ltd/20200526160831.png)

## 💡总结

本题为[《剑指 Offer》 中的 面试题 3](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/) 的一个变种问题，在书中有解释其做法，为两分查找法。



[41. 缺失的第一个正数](https://leetcode-cn.com/problems/first-missing-positive/) 是原地哈希的一个题目，使用原地哈希的方式来查找。

同样的，[《剑指 Offer》的面试题 3]() 的最佳解法也是原地哈希。

原地哈希的思想很简单，但是代码编写起来稍有复杂，需要多加练习。



[leetcode-cn 用户 liweiwei1419](https://leetcode-cn.com/u/liweiwei1419/) 还总结了一份非常全的 两分问题 [讲解](https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/)，不仅包含了详细的思路简介，还包含了题目列表，非常全面且细致，再次感谢他的辛苦整理和讲解，再次感谢~~！！



