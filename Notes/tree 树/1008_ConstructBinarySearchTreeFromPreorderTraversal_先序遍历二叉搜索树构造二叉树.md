

# 1008_ConstructBinarySearchTreeFromPreorderTraversal_先序遍历二叉搜索树构造二叉树

## 📌题目详情

[leetcode 题目地址](https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/)

📗Difficulty：	**Medium**	

🎯Tags：

+ **[Tree](https://leetcode.com/tag/tree/)**



---

## 📃题目描述

返回与给定先序遍历 `preorder` 相匹配的二叉搜索树（binary search tree）的根结点。

(回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 `node.left` 的任何后代，`值总 < node.val`，而 `node.right` 的任何后代，`值总 > node.val`。此外，先序遍历首先显示节点的值，然后遍历 `node.left`，接着遍历 `node.right`。）

**样例 1：**

```
输入：[8,5,1,7,10,12]
输出：[8,5,10,1,7,null,12]
```

![样例1](https://assets.ryantech.ltd/20200603155313.png)

**提示：**

1. `1 <= preorder.length <= 100`
2. 先序 `preorder` 中的值是不同的。



****

## 🏹🎯解题思路

### 解题思路

> 以下思路来自 leetcode-cn 用户 [liweiwei1419 的题解](https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/solution/fen-zhi-si-xiang-java-by-liweiwei1419/)，这里作为摘抄，部分配图为我手写。
>
> 感谢他的精彩题解分析，几乎片片是精品。再次感谢~

![解析图示](https://assets.ryantech.ltd/20200603155739.jpg)

以样例 1 来举例，先序遍历顺序的第一个元素为 `root` 节点。而给定的树是二叉搜索树，其特性为：左子树的节点值小于 `root` 节点，右子树的节点值大于 `root` 节点。

而分叉点具有的特性是，第一个不小于 `root.val` 的点。在上图中为 `pivot + 1`。那么只需要找出这个分叉点，再进行递归操作即可。（二叉树的问题，很多时候采用递归算法编写起来较为简单。）



#### 代码实现

```java
// 分治思想
public TreeNode bstFromPreorder(int[] preorder) {
    int length = preorder.length;
    if (length == 0) {
        return null;
    }
    return buildBST(preorder, 0, length - 1);
}

public TreeNode buildBST(int[] preorder, int left, int right) {
    // 递归结束条件
    if (left > right) {
        return null;
    }
    TreeNode root = new TreeNode(preorder[left]);
    int pivot = left;
    // 找到“谷底”
    // 注意这里的 pivot 的循环
    while (pivot + 1 <= right && preorder[pivot + 1] < preorder[left]) {
        pivot++;
    }
    root.left = buildBST(preorder, left + 1, pivot);
    root.right = buildBST(preorder, pivot + 1, right);
    return root;
}
```



#### 复杂度分析

+ 时间复杂度：`O(n ^ 2)` 。最差情况就是顺序数组和倒序数组，这种情况相当于构建一个链表。
+ 空间复杂度： `O(n)` 。递归调用的方法栈的高度是 `O(log n)`，被忽略。



### 两分算法优化

但是可以发现，后面那一段其实是一个有「谷底」的数组，我们可以使用「二分查找」找到那个谷底，这里要注意边界条件。

> 关于两分查找，liweiwei1419 也有一篇很棒的文章，这里贴出链接：[用「排除法」（减治思想）写二分查找问题、与其它二分查找模板的比较 ](https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/) 。



#### 代码实现

```java
// 分治思想 + 两分优化
public TreeNode bstFromPreorder(int[] preorder) {
    int length = preorder.length;
    if (length == 0) {
        return null;
    }
    return buildBST(preorder, 0, length - 1);
}

public TreeNode buildBST(int[] preorder, int left, int right) {
    // 递归结束条件
    if (left > right) {
        return null;
    }
    TreeNode root = new TreeNode(preorder[left]);
    int leftPoint = left;
    int rightPoint = right;
    // 找到“谷底”
    // 重点逻辑：在区间 [left, right] 里找最后一个小于等于 preorder[left] 的下标
    // 注意这里设置区间的左边界为 left ，不能是 left + 1
    while (leftPoint < rightPoint) {
        int midPoint = leftPoint + (rightPoint - leftPoint + 1) / 2;
        if (preorder[midPoint] < preorder[left]) {
            leftPoint = midPoint;
        } else {
            rightPoint = midPoint - 1;
        }
    }
    root.left = buildBST(preorder, left + 1, leftPoint);
    root.right = buildBST(preorder, leftPoint + 1, right);
    return root;
}
```



#### 复杂度分析

+ 时间复杂度：`O(n log n)` 。二分查找优化了线性查找的时间复杂度。
+ 空间复杂度： `O(n)` 。递归调用的方法栈的高度是 `O(log n)`，被忽略。



## 💡总结

### 相似题目

[889. 根据前序和后序遍历构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/)

> 返回与给定的前序和后序遍历匹配的任何二叉树。
>
>  `pre` 和 `post` 遍历中的值是不同的正整数。
>
> 注意：可能有多个答案，返回一个答案即可。



[1028. 从先序遍历还原二叉树](https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/)

> 我们从二叉树的根节点 `root` 开始进行深度优先搜索。
>
> 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
>
> 如果节点只有一个子节点，那么保证该子节点为左子节点。
>
> 给出遍历输出 S，还原树并返回其根节点 `root`。



