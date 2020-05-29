

# 563_BinaryTreeTilt_二叉树的坡度

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/binary-tree-tilt/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/binary-tree-tilt/)

📗Difficulty：**Easy**	

🎯Tags：

+ **[Tree](https://leetcode.com/tag/tree/)**

---

## 📃题目描述

给定一个二叉树，计算整个树的坡度。

一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。

整个树的坡度就是其所有节点的坡度之和。



**样例 1：**

```
输入: 
         1
       /   \
      2     3
输出: 1
解释: 
结点的坡度 2 : 0
结点的坡度 3 : 0
结点的坡度 1 : |2-3| = 1
树的坡度 : 0 + 0 + 1 = 1
```



**注意：**

1. 任何子树的结点的和不会超过32位整数的范围。
2. 坡度的值不会超过32位整数的范围。



****

## 🏹🎯解题思路



#### 代码实现

```java
public class Solution1 {
    int tilt = 0;

    public int findTilt(TreeNode root) {
        tiltHelper(root);
        return tilt;
    }

    public int tiltHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = tiltHelper(root.left);
        int rightValue = tiltHelper(root.right);
        tilt += Math.abs(leftValue - rightValue);
        return leftValue + rightValue + root.val;
    }
}
```



#### 复杂度分析

+ 时间复杂度：`O(n)`。
+ 空间复杂度：`O(n)`。最坏情况下，一个完全倾斜的树，此时需要的空间为 `O(n)` ，平均情况下为 `O(log n)` 。



## 💡总结



