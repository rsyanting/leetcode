

# 112_PathSum_路径总和

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/path-sum/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/path-sum/)

📗Difficulty：**Easy**	

🎯Tags：

+ **[Tree](https://leetcode-cn.com/tag/tree/)**



---

## 📃题目描述

给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

**说明: 叶子节点是指没有子节点的节点。**



**示例 1:** 
给定如下二叉树，以及目标和 `sum = 22`

```
			  5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
```

返回 `true`, 因为存在目标和为 22 的根节点到叶子节点的路径 `5->4->11->2`。



****

## 🏹🎯解题思路

### 递归算法 DFS

这里需要注意的一个点是，只有到达根节点的时候，才需要判断路径值 和 `sum` 是否相等。

这里用的是每次去减去 node.val 最后看 node.val 是不是等于 0。



#### 代码实现

```java
public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
        return false;
    }
    return hasPathSumHelper(root, sum);
}

public boolean hasPathSumHelper(TreeNode root, int sum) {
    // 到达根节点
    if (root.left == null && root.right == null) {
        return root.val == sum;
    }
    // 左孩子为 null 时候
    if (root.left == null) {
        return hasPathSumHelper(root.right, sum - root.val);
    }
    // 右孩子为 null 的时候
    if (root.right == null) {
        return hasPathSumHelper(root.left, sum - root.val);
    }
    return hasPathSumHelper(root.right, sum - root.val) || hasPathSumHelper(root.left, sum - root.val);
}
```



#### 复杂度分析

+ 时间复杂度： `O(n)` 。最坏情况下每个节点都需要被范围一次。最少需要访问半边子树。
+ 空间复杂度： `O(n)` 。最坏情况下的空间复杂度，即完全退化为单链表的情况。一般情况下的复杂度为  `O(log n)`  。





### 迭代算法 DFS 栈改写

使用栈改写递归。这里选择维护题目中给定的定义：路径值。

新建一个 `K-V` 类，`K` 为 `node` 节点，`V` 为到此 `node` 的路径值。



#### 代码实现

```java
public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
        return false;
    }

    Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
    stack.push(new Pair<>(root, root.val));
    while (!stack.isEmpty()) {
        Pair<TreeNode, Integer> cur = stack.pop();
        // 头节点 到 叶节点
        if (cur.getKey().left == null && cur.getKey().right == null) {
            if (cur.getValue() == sum) {
                return true;
            }
        }

        if (cur.getKey().right != null) {
            stack.push(new Pair<>(cur.getKey().right, cur.getValue() + cur.getKey().right.val));
        }

        if (cur.getKey().left != null) {
            stack.push(new Pair<>(cur.getKey().left, cur.getValue() + cur.getKey().left.val));
        }
    }
    return false;
}
```



#### 复杂度分析

+ 时间复杂度： `O(n)` 。最坏情况下每个节点都需要被范围一次。最少需要访问半边子树。
+ 空间复杂度： `O(log n)` 。最坏情况下的空间复杂度，即满二叉树的情况下。



### 迭代算法 BFS

思想是 BFS 的思想，细节也差不多……



#### 代码实现

```java
public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
        return false;
    }

    Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
    queue.offer(new Pair<>(root, root.val));
    while (!queue.isEmpty()) {
        Pair<TreeNode, Integer> cur = queue.poll();
        // 头节点 到 叶节点
        if (cur.getKey().left == null && cur.getKey().right == null) {
            if (cur.getValue() == sum) {
                return true;
            }
        }

        if (cur.getKey().right != null) {
            queue.offer(new Pair<>(cur.getKey().right, cur.getValue() + cur.getKey().right.val));
        }

        if (cur.getKey().left != null) {
            queue.offer(new Pair<>(cur.getKey().left, cur.getValue() + cur.getKey().left.val));
        }
    }
    return false;
}
```



#### 复杂度分析

+ 时间复杂度： `O(n)` 。最坏情况下每个节点都需要被范围一次。最少需要访问半边子树。
+ 空间复杂度： `O(log n)` 。最坏情况下的空间复杂度，即存储下面一层节点的情况。

## 💡总结



### 相似题目

[226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

> 经典递归算法。简单题。



[101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)



