

# 226_InvertBinaryTree_翻转二叉树

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/invert-binary-tree/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/invert-binary-tree/)

📗Difficulty：**Easy**	

🎯Tags：

+ **[Tree](https://leetcode.com/tag/tree/)**



---

## 📃题目描述

翻转一棵二叉树。

**输入：**

```
    4
   /   \
  2     7
 / \   / \
1   3 6   9
```

**输出：**

```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```



****

## 🏹🎯解题思路

注意递归的返回条件：

```java
if (root == null) {
    return null;
}
```



#### 代码实现

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    TreeNode right = invertTree(root.right);
    TreeNode left = invertTree(root.left);
    root.left = right;
    root.right = left;
    return root;
}
```



#### 复杂度分析

+ 时间复杂度：  `O(n)` 。每个节点访问一次。
+ 空间复杂度： `O(n)` 。最坏情况下复杂度为 `O(n)` ，此时树完全退化为单链表。平均情况下为 `O(n)` 。



### 迭代法——使用 栈/队列 辅助操作



```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerLast(root);
    while (!deque.isEmpty()) {
        TreeNode cur = deque.pollFirst(); // 队列
        //            TreeNode cur = deque.pollLast(); // 栈
        if (cur.left != null) {
            deque.offerLast(cur.left);
        }
        if (cur.right != null) {
            deque.offerLast(cur.right);
        }
        // 交换
        TreeNode tmp = cur.left;
        cur.left = cur.right;
        cur.right = tmp;
    }
    return root;
}
```

#### 复杂度分析

+ 时间复杂度：  `O(n)` 。每个节点访问一次。
+ 空间复杂度： `O(log n)` 。最坏情况下复杂度为 `O(log n)` ，需要存储最后一层的全部叶子节点。



---

## 💡总结

树和递归操作不分家。树本身就是一个递归的定义。

