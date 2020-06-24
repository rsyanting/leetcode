

# 15_ThreeSums_三数之和

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/3sum/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/3sum/)

📗Difficulty： **Medium**

🎯Tags：

+ **[排序](https://leetcode-cn.com/tag/sort/)**
+ **[数组](https://leetcode-cn.com/tag/array/)**

---

## 📃题目描述

给你一个包含 `n` 个整数的数组 `nums`，判断 `nums` 中是否存在三个元素 `a，b，c` ，使得 `a + b + c = 0` ？请你找出所有满足条件且不重复的三元组。

**注意：**答案中不可以包含重复的三元组。



**样例 1：**

```
给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```



****

## 🏹🎯解题思路

> 以下思路来自于 [leetcode-cn 用户 Krahets 的题解](https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/)，感谢他的精彩分析。

首先对数组进行排序，排序后，设置 3 个指针，一个指针从尾部开始，向后遍历，作为外循环。外循环有 `nums.lenght - 2`  次循环。另外 2 个指针，指向剩下的头尾，进行“查找”的操作。

需要注意的是：如果排除掉重复的元素，以满足题目要求？

![图解思路-1](https://assets.ryantech.ltd/20200624152156.png)

如上图所示，此时的 `sum` 不满足为 `0` 的条件，根据有序数组的特性，需要将 `i` 向前移动，增大 `sum` 的值。

如果 `sum` 大于 0，那么需要减小 `j`，以此减小 `sum` 的和。

![图解思路-2](https://assets.ryantech.ltd/20200624152249.png)

例如上面的情况，就找到了一个合法情况。

如果遇到了几个数字相同的情况，需要进行去重操作。

+ 首先判断 `nums[k]` 如果其重复，那么需要将 `k++`。
+ 如果是 `nums[i]` 或者 `nums[j]` 重复，需要移动 `i` 或者 `j` 到不重复的位置。
    + 在找到了合法元组后，还需要进行 `i` 和 `j` 的判重，再去掉重复的元素。



#### 代码实现

```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    if (nums == null || nums.length < 3) {
        return res;
    }

    Arrays.sort(nums);
    for (int k = 0; k < nums.length - 2; k++) {
        if (nums[k] > 0) break; // 三个数字均大于 0 ，不可能再产生符合条件的结果。
        if (k > 0 && nums[k] == nums[k - 1]) continue; // 元素有重复，跳过重复的元素
        int i = k + 1, j = nums.length - 1; // i 向右搜索，j 向左搜索
        while (i < j) {
            int sum = nums[k] + nums[i] + nums[j];
            if (sum < 0) {
                while (i < j && nums[i] == nums[++i]) ; // 跳过重复元素
            } else if (sum > 0) {
                while (i < j && nums[j] == nums[--j]) ; // 跳过重复元素
            } else {
                res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                while (i < j && nums[i] == nums[++i]) ; // 继续跳过重复元素
                while (i < j && nums[j] == nums[--j]) ; // 继续跳过重复元素
            }
        }
    }
    return res;
}
```



#### 复杂度分析

+ 时间复杂度：`O(n ^ 2)` 。
+ 空间复杂度：`O(1)` 。



---

## 💡总结

本题的遗漏点在于重复元素的去除，如果对整个循环理解不透彻，容易造成漏除元素，从而导致最终结果的重复。并且，由于循环很多，debug 过程也比较冗余。建议在思考时，将情况考察清楚，再进行代码编写。



### 相似题目

[16. 最接近的三数之和](https://leetcode-cn.com/problems/3sum-closest/)

