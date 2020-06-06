

# 54_SpiralMatrix_螺旋矩阵 2

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/spiral-matrix-ii/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/spiral-matrix-ii/)

📗Difficulty：**Medium**	

🎯Tags：

+ **[Array](https://leetcode-cn.com/tag/array/)**



---

## 📃题目描述

给定一个正整数 `n`，生成一个包含 1 到 `n^2` 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

**样例 1：**

```
输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
```



****

## 🏹🎯解题思路


类似的题目还有，《蛇形填数》。类似于贪吃蛇，只能有 四个方向去移动，而且不能超越一定的范围。

这类题目，称其为**“模拟题”**，就是说，本题的解题过程是模拟人工解决这类问题的过程，并不涉及到很复杂的数据结构和算法。



首先，观察填数的顺序。从左上角开始，然后向右到边界，再向下，再向上，再向右边。**变换 4 次方向。**

![“蛇头”变换过程](https://assets.ryantech.ltd/20200605135753.jpg)

其中一个疑问在，如何在变换方向后确定“折返点”？

对于外圈的点位来说，可以判断是否越界。但是对于内圈的点位，必须要有个指示的东西，否则会重复走走过的路，造成 bug 。

而对于越界的判断有 2 种思路：

+ 先污染，后治理。
+ 不污染，向后看一个。

下面给出第 2 种思路的代码。



### 向后看一步，精准卡位

先检查此位置是否越界，代码更加简洁清晰。



#### 代码实现

```java
public int[][] generateMatrix(int n) {
    if (n <= 0) {
        return new int[][]{};
    }

    int[][] ans = new int[n][n];
    int tot = 1;
    int row = 0;
    int column = 0;
    ans[row][column] = tot;
    while (tot < n * n) {
        while (column + 1 < n && ans[row][column + 1] == 0) {
            ans[row][++column] = ++tot;
        }
        while (row + 1 < n && ans[row + 1][column] == 0) {
            ans[++row][column] = ++tot;
        }
        while (column - 1 >= 0 && ans[row][column - 1] == 0) {
            ans[row][--column] = ++tot;
        }
        while (row - 1 >= 0 && ans[row - 1][column] == 0) {
            ans[--row][column] = ++tot;
        }
    }
    return ans;
}
```



#### 复杂度分析

+ 时间复杂度： `O(n)` 。每个元素都被访问一次。
+ 空间复杂度： `O(n)` 。需要设置一个和输入数组等大的数组来标记元素是否被访问过。



## 💡总结

### 相似题目

[54. 螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix/)

[面试题29. 顺时针打印矩阵](https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)



