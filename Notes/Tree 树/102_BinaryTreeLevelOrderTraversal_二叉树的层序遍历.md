

# 102_BinaryTreeLevelOrderTraversal_二叉树的层序遍历

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/binary-tree-level-order-traversal/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

📗Difficulty： **Medium**

🎯Tags：

+ **[Tree](https://leetcode.com/tag/tree/)**
+ **[Breadth First Search](https://leetcode-cn.com/tag/breadth-first-search/)**
+ **[Queue](https://leetcode-cn.com/tag/queue/)**

---

## 📃题目描述

给你一个二叉树，请你返回其按 **层序遍历** 得到的节点值。 （即逐层地，从左到右访问所有节点）。



**样例 1：**

```
二叉树：[3,9,20,null,null,15,7]

  3
   / \
  9  20
    /  \
   15   7
```

其层次遍历的结果：

```
[
  [3],
  [9,20],
  [15,7]
]
```



****

## 🏹🎯解题思路

树可以看成是图的一种特殊情况。对图的遍历有两种通用的方法，BFS 和 DFS。对图的层序遍历可以利用 BFS 来完成。

![三种遍历的图示](https://assets.ryantech.ltd/ab103822e75b5b15c615b68560cb2416.jpg)

如果对上面的树进行 `层序遍历`，其访问过程是：`A->B->C->D->E->F->G`。

对最后一行来说，`D` 的根节点的 `B` ，`F` 的根节点是 `C` 。

可以利用 队列 的 `FIFO` 的性质，先将每层的节点按徐入队，然后依次出队即可。



#### 代码实现

```java
public class Solution1 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每一层的节点数
            int level_size = queue.size();
            TreeNode cur = queue.peek();
            // 每一层的 val 值
            List<Integer> level_res = new LinkedList<>();
            for (int i = 0; i < level_size; i++) {
                cur = queue.poll();
                level_res.add(cur.val);
                // 将当前节点的左右子树入队
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(level_res);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = new Solution1().levelOrder(root);
        for (List list : res) {
            for (Object integer : list) {
                System.out.println(integer);
            }
        }
    }
}

```



#### 复杂度分析

+ 时间复杂度： `O(n)` 。每个节点都访问一次。
+ 空间复杂度： `O(n)` 。最坏情况下存储一层的节点，如果是最后一层，那么其数量最大为 `n / 2` 。



## 💡总结

**三个遍历不分家：**

[144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

[94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

[145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

> 如何使用非递归算法实现 [二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/) ？



[102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

> 借助 队列 实现 [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)。



