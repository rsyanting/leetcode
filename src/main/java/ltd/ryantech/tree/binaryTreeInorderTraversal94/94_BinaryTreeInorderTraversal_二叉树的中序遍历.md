

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



![三种遍历的图示](https://assets.ryantech.ltd/ab103822e75b5b15c615b68560cb2416.jpg)



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

+ 时间复杂度： `O(1)`    `O(log n)`      `O(n)`      `O(n log n)`
+ 空间复杂度：`O(1)`    `O(log n)`     `O(n)`





### 代码实现

```java
public class Solution2 {
    // 非递归 中序遍历二叉树
    // 迭代法，使用栈作为辅助
    private List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            // 如果 root 为空，则返回 res, res 中没有任何元素
            return res;
        }
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





#### 复杂度分析

+ 时间复杂度： `O(1)`    `O(log n)`      `O(n)`      `O(n log n)`
+ 空间复杂度：`O(1)`    `O(log n)`     `O(n)`





## 💡总结

**三个遍历不分家：**

[144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

[94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

[145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

> 如何使用非递归算法实现 [二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/) ？



[102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

> 借助 队列 实现 [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)。



