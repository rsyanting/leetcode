

# 145_BinaryTreePostorderTraversal_二叉树的后序遍历

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/binary-tree-postorder-traversal/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

📗Difficulty：	**Hard**

🎯Tags：

+ **[Tree](https://leetcode.com/tag/tree/)**

---

## 📃题目描述

给定一个二叉树，返回它的 `后序` 遍历。



**样例 1：**

```
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
```



**进阶：**

+ 递归算法很简单，你可以通过迭代算法完成吗？



****

## 🏹🎯解题思路

### 递归算法



#### 代码实现

```java
public class Solution1 {
    // 递归 后序遍历二叉树
    private List<Integer> res = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            res.add(root.val);
        }
        // 如果 root 为空，则返回 res, res 中没有任何元素
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = new Solution1().postorderTraversal(root);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
```



#### 复杂度分析

+ 时间复杂度： `O(1)`    `O(log n)`      `O(n)`      `O(n log n)`
+ 空间复杂度：`O(1)`    `O(log n)`     `O(n)`



### 迭代算法



#### 代码实现

```java
public class Solution2 {
    // 递归 后序遍历二叉树
    private List<Integer> res = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur == null) {
                stack.pop();
                res.add(stack.peek().val);
                stack.pop();
                continue;
            }
            stack.push(null);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        // 如果 root 为空，则返回 res, res 中没有任何元素
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = new Solution2().postorderTraversal(root);
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