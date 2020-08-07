

# 106_ConstructBinaryTreeFromInorderAndPostorderTraversal_从中序和后序遍历构造二叉树

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

📗Difficulty：	**Medium**	

🎯Tags：

+ **[Tree](https://leetcode.com/tag/tree/)**



---

## 📃题目描述

根据一棵树的中序遍历与后序遍历构造二叉树。

**注意:**

+ 你可以假设树中没有重复的元素。

例如，给出

```
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
```

返回如下的二叉树：

```
3
   / \
  9  20
    /  \
   15   7
```



****

## 🏹🎯解题思路

先给出经典图片，一览 三个序列 的节点访问顺序。

![三种遍历的图示](https://assets.ryantech.ltd/ab103822e75b5b15c615b68560cb2416.jpg)

后序遍历的最后一个访问到的是 `root` 节点，是整棵树的根节点。中序遍历中，整棵树的根节点是处于“中间”被访问到的。

> 下面的图片来自 leetcode-cn 用户 [liweiwei1419 的题解](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/hou-xu-bian-li-python-dai-ma-java-dai-ma-by-liwe-2/)。感谢其的精心绘制。

![思路解析配图](https://assets.ryantech.ltd/20200603145919.png)

如果有一个 `HashMap` 记录了中序遍历的节点值和其下标索引，那么可以在 `O(1)` 时间内找到 `root` 的索引。



![中序和后序遍历的索引位置](https://assets.ryantech.ltd/20200603150204.png)



#### 代码实现

```java
public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || inorder.length == 0) {
        return null;
    }
    int inLen = inorder.length;
    int poLen = postorder.length;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
        inorderMap.put(inorder[i], i);
    }
    return buildTree(inorder, 0, inLen - 1, postorder, 0, poLen - 1, inorderMap);
}

public TreeNode buildTree(int[] inorder, int inLeft, int inRight, int[] postorder, int poLeft, int poRight, Map<Integer, Integer> inorderMap) {
    if (inLeft > inRight || poLeft > poRight) {
        return null;
    }
    // 使用 HashMap 来保存 inorder 序列的 index 信息，快速查找到 rootIndex
    int rootIndex = inorderMap.get(postorder[poRight]);
    TreeNode root = new TreeNode(inorder[rootIndex]);
    // 左子树节点数
    int leftNodes = rootIndex - inLeft;
    // 右子树节点数
    int rightNodes = inRight - rootIndex;
    // 左子树在 inorder 中的区间为 [inLeft, inLeft + leftNodes - 1]
    root.left = buildTree(inorder, inLeft, inLeft + leftNodes - 1, postorder, poLeft, poRight - rightNodes - 1, inorderMap);
    root.right = buildTree(inorder, rootIndex + 1, inRight, postorder, poRight - 1 - rightNodes, poRight - 1, inorderMap);
    return root;
}
```



#### 复杂度分析

+ 时间复杂度：`O(n)` 。递归的复杂度是  `O(log n)` ，遍历一次中序访问顺序数组 `O(n)`。综合下来，复杂度为 `O(n)` 。
+ 空间复杂度： `O(n)` 。`HashMap` 存储每个节点的 `index` 信息。



## 💡总结

### 相似题目

[105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

