

# 374_GuessNumber_猜数字大小

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/guess-number-higher-or-lower/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/guess-number-higher-or-lower/)

📗Difficulty：**Easy**	

🎯Tags：

+ **[二分查找](https://leetcode-cn.com/tag/binary-search/)** 

---

## 📃题目描述

现在来玩一个猜数字游戏。 游戏规则如下：

测评系统从 `1` 到 `n` 选择一个数字。 你需要猜测评系统选择了哪个数字。每次你猜错了，测评系统会告诉你这个数字是大了还是小了。你调用一个预先定义好的接口 `guess(int num)`，这个接口会返回 `3` 个可能的结果`（-1，1 或 0）`：

```
-1 : 测评系统的数字比较小
 1 : 测评系统的数字比较大
 0 : 恭喜！你猜对了！
```



**样例 1：**

```
输入: n = 10, pick = 6
输出: 6
```



****

## 🏹🎯解题思路

经典二分搜索。根据接口 `guess(int num)` 返回的结果确定如何收缩边界。

### ①“三分式”二分搜索

注意循环条件是 `left <= right` 。



#### 代码实现

```java
// 经典 “三分式” 两分查找
public int guessNumber(int n) {
    int left = 1;
    int right = n;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int res = guess(mid);
        if (res == 0) {
            return mid;
        } else if (res == -1) { // target < n 的情况
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}
```



#### 复杂度分析

+ 时间复杂度：`O(log n)` 。
+ 空间复杂度：`O(1)` 。

---

### ②“二分式”二分搜索

严格大于 `target` 的元素不是解。那么下一轮循环的边界为 `[left,mid - 1]` 。也就是说，区间被分为 `[left,mid -1]` 和 `[mid,right]` 的情况。



#### 代码实现

```java
// “两分式” 两分查找
public int guessNumber(int n) {
    int left = 1;
    int right = n;
    while (left < right) {
        int mid = left + (right - left + 1) / 2;
        int res = guess(mid);
        // 严格大于 target 的元素不是解
        if (res == -1) { // target < n 的情况
            // 下一轮的搜索区间是 [left,mid - 1]
            right = mid - 1;
        } else {
            left = mid;
        }
    }
    return left;
}
```



#### 复杂度分析

+ 时间复杂度：`O(log n)` 。
+ 空间复杂度：`O(1)` 。

---

### ③“二分式”二分搜索

严格小于 `target` 的元素不是解。那么下一轮循环的边界为 `[mid + 1,right]` 。也就是说，区间被分为 `[left,mid]` 和 `[mid + 1,right]` 的情况。



#### 代码实现

```java
// “两分式” 两分查找
public int guessNumber(int n) {
    int left = 1;
    int right = n;
    while (left < right) {
        int mid = left + (right - left) / 2;
        int res = guess(mid);
        // 严格小于 target 的元素不是解
        if (res == 1) { // target > n 的情况
            // 下一轮的搜索区间是 [mid + 1,right]
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}
```



#### 复杂度分析

+ 时间复杂度：`O(log n)` 。
+ 空间复杂度：`O(1)` 。

---

## 💡总结

#### 延伸题解

[借本题说一说取中位数的写法（Python 代码、Java 代码）](https://leetcode-cn.com/problems/guess-number-higher-or-lower/solution/shi-fen-hao-yong-de-er-fen-cha-zhao-fa-mo-ban-pyth/)

> mid 的取值问题。
>
> 使用 `int mid = left + (right - left) / 2` 来避免溢出错误。

[用「排除法」（减治思想）写二分查找问题、与其它二分查找模板的比较](https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/)

> 完整讲解了 “二分式”二分搜索法。