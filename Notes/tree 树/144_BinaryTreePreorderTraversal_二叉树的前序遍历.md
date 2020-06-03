

# 144_BinaryTreePreorderTraversal_二叉树的前序遍历

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/binary-tree-preorder-traversal/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

📗Difficulty： **Medium**	

🎯Tags：

+ **[Tree](https://leetcode.com/tag/tree/)**

---

## 📃题目描述

给定一个二叉树，返回它的 `前序` 遍历。



**样例 1：**

```
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
```



**进阶：**

+ 递归算法很简单，可以使用 迭代算法 完成吗？



****

## 🏹🎯解题思路

### 递归算法

首先需要理解什么是 `先序遍历` ，以下面这个为例子。

![三种遍历的图示](https://assets.ryantech.ltd/ab103822e75b5b15c615b68560cb2416.jpg)

先序遍历就是，每次首先访问根节点，在访问左子树，然后访问右子树。访问左子树的过程，首先访问左子树的根节点，然后是该根节点的左子树，右子树……没错，其访问过程是递归的。其过程使用递归算法写起来也最简单，容易理解。(仅仅是看起来容易理解，真正其明白其执行过程，并不一定简单。因为人脑去思考这种东西，是反直觉的，这是计算机的强项。)



#### 代码实现

```java
public class Solution1 {
    // 递归 先序遍历二叉树
    private List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        // 如果 root 为空，则返回 res, res 中没有任何元素
        return res;
    }
	
    // 以下为测试代码
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = new Solution1().preorderTraversal(root);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
```



#### 复杂度分析

+ 时间复杂度：`O(n)`。每个节点都需要访问一次。
+ 空间复杂度：最坏情况下为 `O(n)`，此时的树完全退化为单链表。平均情况下为 `O(log n)`，比如满二叉树的情况。



### 迭代算法

使用 Stack 栈作为辅助进行进行操作。栈具有 `后进先出(FIFO)` 的性质。这里使用一个具体的例子来作为辅助理解。

就使用简单的 样例 1 来解读：

```
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
```



**执行过程：**

1. 当 `root` 不为空时，把 `root` 压入栈中。也就是将 1 节点压入栈中。
2. 进入 `while` 循环，此时栈不空，弹出栈顶元素，即 `root` 节点。res 中加入 `root.val` 。 判断其左子树是否为空，不为空压入，这里为空，不压入；判断其右子树是否为空，不为空压入，这里不为空，压入。此时栈中只有元素 节点2，其也是栈顶元素。`res` 中元素为 `[1]`。
3. 再次判断 `stack` 是否为空。重复 **2** 中的步骤。弹出栈顶元素 **节点2**，作为此时的 `root` 节点。res 中加入 `root.val` 。判断其左子树是否为空，不为空压入，这里不为空，压入；判断其右子树是否为空，不为空压入，这里为空，不压入。此时栈中只有元素 节点3，其也是栈顶元素。`res` 中元素为 `[1,2]`。
4. 再次判断 `stack` 是否为空。重复 **2** 中的步骤。弹出栈顶元素 **节点3**，作为此时的 `root` 节点。res 中加入 `root.val` 。判断其左子树是否为空，不为空压入，这里为空，不压入；判断其右子树是否为空，不为空压入，这里为空，不压入。此时栈中已经空了。`res` 中元素为 `[1,2,3]`。
5. 栈空，程序结束。也结束了 先序遍历 的过程。



#### 代码实现

```java
public class Solution2 {
    // 非递归 先序遍历二叉树
    // 迭代法，使用栈作为辅助
    private List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            // 如果 root 为空，则返回 res, res 中没有任何元素
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            // 压栈的顺序需要注意为 先压右子树，后压左子树
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }
	
    // 以下为测试代码
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = new Solution2().preorderTraversal(root);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
```



#### 复杂度分析

+ 时间复杂度：`O(n)`。每个节点都需要访问一次。
+ 空间复杂度：最坏情况下为 `O(n)`，此时的树完全退化为单链表。平均情况下为 `O(log n)`，比如满二叉树的情况。



## 💡总结

**三个遍历不分家：**

[144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

[94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

[145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

> 如何使用非递归算法实现 [二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/) ？



[102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

> 借助 队列 实现 [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)。

