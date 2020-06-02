

# 94_BinaryTreeInorderTraversal_二叉树的中序遍历

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/binary-tree-inorder-traversal/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

📗Difficulty：	**Medium**	

🎯Tags：

+ **[Tree](https://leetcode.com/tag/tree/)**

---

## 📃题目描述

给定一个二叉树，返回它的 **中序** 遍历。



**样例 1：**

```
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
```



**进阶：**

+ 递归算法很简单，你可以通过迭代算法完成吗？



****

## 🏹🎯解题思路

### 递归算法

二叉树的三种遍历顺序图示。

![三种遍历的图示](https://assets.ryantech.ltd/ab103822e75b5b15c615b68560cb2416.jpg)

中序遍历，就是对非空节点，首先访问其左子树，再访问其根节点，最后访问其右子树。这个一个递归的概念。所以使用递归的代码很容易描述其过程。



#### 代码实现

```java
public class Solution1 {
    // 递归 中序遍历二叉树
    private List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = new Solution1().inorderTraversal(root);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
```



#### 复杂度分析

+ 时间复杂度： `O(n)` 。每个节点访问一次。
+ 空间复杂度：  `O(n)` 。最坏的情况下，即树完全退化为单链表的情况下。



### 迭代算法，利用栈辅助

可以看出一个特点，如果一个树其根节点不为空，那么 `中序遍历` 的节点顺序，**第一个是这棵树最左边的叶子节点**，然后逐层向上访问“根节点”，和右子树。

借助栈的 `后进先出 FILO` 特性，将根节点的左子树的左子树，依次压入栈中，再逐个弹出。对于右子树，也做相同的处理。



#### 代码实现

```java
public class Solution2 {
    // 非递归 中序遍历二叉树
    // 迭代法，使用栈作为辅助
    public List<Integer> inorderTraversal(TreeNode root) {
        private List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 先走到左子树的叶子节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 弹出最后一个元素，即最左端的叶子节点
            root = stack.pop();
            // 访问 “中序” 根节点
            res.add(root.val);
            // 处理右子树
            root = root.right;
        }
        // 如果 root 为空，则返回 res, res 中没有任何元素
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = new Solution2().inorderTraversal(root);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
```

![三种遍历的图示](https://assets.ryantech.ltd/ab103822e75b5b15c615b68560cb2416.jpg)



#### 复杂度分析

+ 时间复杂度： `O(n)` 。每个节点访问一次。
+ 空间复杂度： `O(n)` 。最坏的情况下，即树完全退化为单链表的情况下。



## 💡总结

**三个遍历不分家：**

[144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

[94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

[145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

> 如何使用非递归算法实现 [二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/) ？



[102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

> 借助 队列 实现 [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)。



