

# 105_ConstructBinaryTreeFromPreorderAndInorderTraversal_从前序与中序遍历序列构造二叉树

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

📗Difficulty： **Medium** 

🎯Tags：

+ **[Tree](https://leetcode.com/tag/tree/)**



---

## 📃题目描述

根据一棵树的前序遍历与中序遍历构造二叉树。

**注意:**

	+ 你可以假设树中没有重复的元素。

例如，给出

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
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

![三种遍历的图示](https://assets.ryantech.ltd/ab103822e75b5b15c615b68560cb2416.jpg)

还是以上面这幅经典图片作为演示讲解。

先序遍历的第一个访问到的是 `root` 节点，是整棵树的根节点。中序遍历中，整棵树的根节点是处于“中间”被访问到的。

> 下面的图片来自 leetcode-cn 用户 [liweiwei1419 的题解](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/qian-xu-bian-li-python-dai-ma-java-dai-ma-by-liwei/)。感谢其的精心绘制。

![思路解析配图](https://assets.ryantech.ltd/20200603145636.png)

如果有一个 `HashMap` 记录了中序遍历的节点值和其下标索引，那么可以在 `O(1)` 时间内找到 `root` 的索引。

![样例的图示](https://assets.ryantech.ltd/20200603142659.jpg)

有 2 种方法可以采取，一种是传入数组的拷贝，一种是传入数组的索引，这里采用第二种传入索引的方式。

再来一张更加清晰的说明，来自 leetcode-cn 用户 [liweiwei1419 的题解](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/qian-xu-bian-li-python-dai-ma-java-dai-ma-by-liwei/)。

![](https://assets.ryantech.ltd/20200603142915.png)



具体的

#### 代码实现

```java
public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0) {
        return null;
    }
    Map<Integer, Integer> indexMap = new HashMap<>();
    int length = preorder.length; // 树中的节点数量与遍历方式无关
    for (int i = 0; i < length; i++) {
        indexMap.put(inorder[i], i);
    }
    return buildTree(preorder, 0, length - 1,
                     inorder, 0, length - 1,
                     indexMap);
}

public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
                          int[] inorder, int inorderStart, int inorderEnd,
                          Map<Integer, Integer> indexMap) {
    if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
        // 递归结束情形 1 : 先序遍历的开始范围大于结束范围，此时表示二叉树中没有节点
        return null;
    }

    int rootVal = preorder[preorderStart]; // 先序遍历的情况下，第一个 index 处为根节点
    TreeNode root = new TreeNode(rootVal);
    int rootIndex = indexMap.get(rootVal);
    int leftNodes = rootIndex - inorderStart;
    int rightNodes = inorderEnd - rootIndex;
    // 左右子树的构建
    // 注意先序和中序的下标位置
    root.left = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes,
                          inorder, inorderStart, rootIndex - 1,
                          indexMap);
    root.right = buildTree(preorder, preorderStart + leftNodes + 1, preorderEnd,
                           inorder, rootIndex + 1, inorderEnd,
                           indexMap);
    return root;
}
```



#### 复杂度分析

+ 时间复杂度：`O(n)` 。递归的复杂度是  `O(log n)` ，遍历一次中序访问顺序数组 `O(n)`。综合下来，复杂度为 `O(n)` 。
+ 空间复杂度： `O(n)` 。`HashMap` 存储每个节点的 `index` 信息。



## 💡总结

### 相似题目

[106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

> 根据一棵树的中序遍历与后序遍历构造二叉树。
>
> 注意:
> 你可以假设树中没有重复的元素。
>
> 例如，给出
>
> `中序遍历 inorder = [9,3,15,20,7]`
> `后序遍历 postorder = [9,15,7,20,3]`
>
> 返回：
>
> ```
>  3
>    / \
>   9  20
>     /  \
>    15   7
> ```

