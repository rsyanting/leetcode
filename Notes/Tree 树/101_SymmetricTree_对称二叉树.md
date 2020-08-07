

# 101_SymmetricTree_对称二叉树

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/symmetric-tree/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/symmetric-tree/)

📗Difficulty：**Easy**	

🎯Tags：

+ **[Tree](https://leetcode-cn.com/tag/tree/)**



---

## 📃题目描述

给定一个二叉树，检查它是否是镜像对称的。



**样例 1：**

例如，二叉树 `[1,2,2,3,4,4,3]` 是对称的。

```
	1
   / \
  2   2
 / \ / \
3  4 4  3
```



**样例 2：**

但是下面这个 `[1,2,2,null,3,null,3]` 则不是镜像对称的:

```
 	1
   / \
  2   2
   \   \
   3    3
```



**进阶：**

+ 你可以运用递归和迭代两种方法解决这个问题吗？



****

## 🏹🎯解题思路

### 递归算法 DFS 思想

沿着左子树的左子树走到底部，同时沿着右子树的右子树走到底部，每次比较其底部的值。然后沿着左子树的右子树，沿着右子树的左子树走到底部，进行比较，逐层向上递归，每次比较其值。再递归向上。



#### 代码实现

```java
// 递归解法
// 思想类似于 DFS 深度优先搜索
// 沿着左子树的左子树走到底部，同时沿着右子树的右子树走到底部，每次比较其底部的值，再递归向上。
// 然后沿着左子树的右子树，沿着右子树的左子树走到底部，进行比较，逐层向上递归，每次比较其值。
public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
}

public boolean isMirror(TreeNode t1, TreeNode t2) {
    // 根节点的情况，其值相同
    if (t1 == null && t2 == null) {
        return true;
    }
    // 出现了不对称残缺，非镜像
    if (t1 == null || t2 == null) {
        return false;
    }
    return (t1.val == t2.val)
        && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
}
```



#### 复杂度分析

+ 时间复杂度： `O(n)` 。每个节点都要访问 1 次。
+ 空间复杂度： `O(n)` 。最坏情况下，即一棵树完全退化为单链表的情况。平均情况下为 `O(log n)` 。



### 迭代算法 BFS 思想

按层来比较是否镜像。



#### 代码实现

```java
// 非递归算法
// 使用队列辅助，类似 BFS 思想
public boolean isSymmetric(TreeNode root) {
    if (root == null) {
        return true;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(root);
    while (!queue.isEmpty()) {
        TreeNode left = queue.poll();
        TreeNode right = queue.poll();
        // 访问到根节点的情况下
        if (left == null && right == null) {
            continue;
        }
        // 出现了不对称残缺，非镜像
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        queue.add(left.left);
        queue.add(right.right);
        queue.add(left.right);
        queue.add(right.left);
    }
    return true;
}
```



#### 复杂度分析

+ 时间复杂度： `O(n)` 。每个节点都要访问 1 次。
+ 空间复杂度： `O(n)` 。最坏情况下，即访问到最下面一行的情况下，需要存储 2 份最下面一层节点。



## 💡总结

### 相似题目

[226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

> 相似，但不完全一样。



