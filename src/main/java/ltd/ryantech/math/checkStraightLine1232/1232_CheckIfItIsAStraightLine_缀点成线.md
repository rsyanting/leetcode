

# 1232_CheckIfItIsAStraightLine_缀点成线

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/check-if-it-is-a-straight-line/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/)

📗Difficulty：**Easy**	

🎯Tags：

+ **[Math](https://leetcode-cn.com/tag/math/)**



---

## 📃题目描述

在一个 `XY` 坐标系中有一些点，我们用数组 `coordinates` 来分别记录它们的坐标，其中 `coordinates[i] = [x, y]` 表示横坐标为 `x`、纵坐标为 `y` 的点。

请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 `true`，否则请返回 `false`。

![样例1](https://assets.ryantech.ltd/untitled-diagram-2.jpg)

**样例 1：**

```
输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
输出：true
```

![样例2](https://assets.ryantech.ltd/20200603210727.png)

**样例 2：**

```
输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
输出：false
```



**提示：**

+ `2 <= coordinates.length <= 1000`
+ `coordinates[i].length == 2`
+ `-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4`
+ `coordinates` 中不含重复的点



****

## 🏹🎯解题思路

以第 1，2 个点的斜率为基准。为了避免斜率无限大的情况，将除法改为乘法。



#### 代码实现

```java
public boolean checkStraightLine(int[][] coordinates) {
    int x = coordinates[1][0] - coordinates[0][0];
    int y = coordinates[1][1] - coordinates[0][1];
    for (int i = 2; i < coordinates.length - 1; i++) {
        int x1 = coordinates[i + 1][0] - coordinates[i][0];
        int y1 = coordinates[i + 1][1] - coordinates[i][1];
        if (x * y1 != x1 * y) {
            return false;
        }
    }
    return true;
}
```



#### 复杂度分析

+ 时间复杂度：`O(n)` 。
+ 空间复杂度：`O(1)` 。



## 💡总结

注意避免除数为 0 带来的问题。

