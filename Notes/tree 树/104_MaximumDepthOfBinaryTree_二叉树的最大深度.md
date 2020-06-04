

# 104_MaximumDepthOfBinaryTree_二叉树的最大深度

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

📗Difficulty：**Easy**	

🎯Tags：

+ **[Recursion](https://leetcode-cn.com/tag/recursion/)**
+ **[Tree](https://leetcode-cn.com/tag/tree/)**



---

## 📃题目描述

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

**说明:** 叶子节点是指没有子节点的节点。



**样例 1：**

给定二叉树 `[3,9,20,null,null,15,7]`

```
    3
   / \
  9  20
    /  \
   15   7
```

返回它的最大深度 3 。



****

## 🏹🎯解题思路

### 递归算法 DFS

如果是叶子节点，其返回的深度为 `1`，`null` 节点其返回的深度为 `0`。这是递归的返回值。

树的递归很多时候是在维护一个值，这里维护的值就是树的深度。（题目中给定的对深度的定义）



#### 代码实现

```java
// DFS 递归算法
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    } else {
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
```



#### 复杂度分析

+ 时间复杂度： `O(n)` 。每个节点都访问一次。
+ 空间复杂度： `O(n)` 。最坏情况下，即树退化为单链表的情况。 `O(log n)` 为平均空间复杂度。



### 非递归算法 DFS

二叉树的先序遍历，使用栈作为辅助。

压入栈中的元素为 `K-V` 对象，`K` 为节点，`V` 为当前节点的深度。

#### 代码实现

```java
// DFS 非递归算法
// 二叉树的先序遍历
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int depth = 0;
    Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
    stack.push(new Pair<TreeNode, Integer>(root, 1));
    while (!stack.isEmpty()) {
        TreeNode cur = stack.peek().getKey();
        int cur_depth = stack.peek().getValue();
        stack.pop();
        if (cur.right != null) {
            stack.push(new Pair<TreeNode, Integer>(cur.right, cur_depth + 1));
        }
        if (cur.left != null) {
            stack.push(new Pair<TreeNode, Integer>(cur.left, cur_depth + 1));
        }
        depth = Math.max(depth, cur_depth);
    }
    return depth;
}
```



#### 复杂度分析

+ 时间复杂度： `O(n)` 。每个节点都访问一次。
+ 空间复杂度： `O(log n)` 。最坏情况下，即满二叉树的情况，最多存放左子树的一半节点。



### 非递归算法 BFS

如果是人来肉眼数，那么按照层数去数是很直接的一种办法。也就是 BFS 的思路。



#### 代码实现

```java
// 层序遍历 BFS 算法
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNodeSums = queue.size();
            for (int i = 0; i < levelNodeSums; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
```



#### 复杂度分析

+ 时间复杂度： `O(n)` 。每个节点都访问一次。
+ 空间复杂度： `O(log n)` 。最坏情况下，最多存放一层的链表，最后一层，如果是满二叉树的情况，即有一半的节点需要存储。



## 💡总结

二叉树的题目，很多时候可以归结到递归问题上来，在递归中动态维护一个值。

而递归又可以改写为非递归的形式。一般和 DFS / BFS 相互联系。



