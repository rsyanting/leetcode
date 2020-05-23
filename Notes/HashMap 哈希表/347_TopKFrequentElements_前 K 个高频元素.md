

# 347_TopKFrequentElements_前 K 个高频元素

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/top-k-frequent-elements/)

[leetcode-cn 题目地址](https://leetcode.com/problems/top-k-frequent-elements/)

📗Difficulty：	**Medium**	

🎯Tags：

+ **[HashTable](https://leetcode.com/tag/hash-table/)** 
+ **[Heap](https://leetcode-cn.com/tag/heap/)**

---

## 📃题目描述：

给定一个非空的整数数组，返回其中出现频率前 **k** 高的元素。

**样例 1：**

```
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
```



**样例 2：**

```
输入: nums = [1], k = 1
输出: [1]
```

**提示：**

+ 你可以假设给定的 `k` 总是合理的，且 `1 ≤ k ≤ 数组中不相同的元素的个数`。
+ 你的算法的时间复杂度必须优于 `O(n log n)` , `n` 是数组的大小。
+ 题目数据保证答案唯一，换句话说，数组中前 `k` 个高频元素的集合是唯一的。
+ 你可以按任意顺序返回答案。

****

## 🏹🎯解题思路

### 排序法

先使用 HashMap 记录一下数字出现的频度。

再进行一次排序，按照出现频度从高到低的规则进行排序。



#### 代码实现

```java
// 统计频度 + 排序
public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int num : nums) {
        hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
    }
    List<HashMap.Entry<Integer, Integer>> list = new LinkedList<>(hashMap.entrySet());
    list.sort(new Comparator<HashMap.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            // 升序排序
            return o2.getValue() - o1.getValue();
        }
    });

    int index = 0;
    int[] res = new int[k];
    for (HashMap.Entry<Integer, Integer> entry : list) {
        res[index++] = entry.getKey();
        if (index >= k) {
            return res;
        }
    }
    return res;
}
```



#### 复杂度分析

+ 时间复杂度：遍历一遍数组计算频度，复杂度为 `O(n)` ; 排序复杂度为 `O(n log n)`；总的复杂度为 `O(n log n)`。
+ 空间复杂度：最坏情况下需要把全部的数组元素存入到 hashmap 中，复杂度为 `O(n)` 。



### 优先队列（最小堆）

和排序法一样，首先用 `HashMap` 计算一遍数字出现的频度。

再配合一个最小堆，将数字依次存入其中，保证出现频度最小的元素处于优先队列的头部，使得出现频度最高的 K 个元素“沉淀”到尾部。

最后将这个 K 个元素依次出队，加入到 `res` 数组中去即可。

#### 代码实现

```java
// 优先队列 最小堆
public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int num : nums) {
        hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return hashMap.get(o1) - hashMap.get(o2);
        }
    });
    // 每次存入一个新的元素，优先队列头部是频次较小的元素
    // 出现频次在前 K 个的，被“沉淀”到优先队列的尾部
    for (Integer key : hashMap.keySet()) {
        priorityQueue.offer(key);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
    }
    int[] res = new int[k];
    int index = 0;
    while (!priorityQueue.isEmpty()) {
        res[index++] = priorityQueue.poll();
    }
    return res;
}
```



#### 复杂度分析

+ 时间复杂度：遍历一遍数组计算频度，复杂度为 `O(n)` ; 堆化复杂度为 `O(log n)`；总的复杂度为 `O(n)`。
+ 空间复杂度：最坏情况下需要把全部的数组元素存入到 hashmap 中，复杂度为 `O(n)` ；同时需要一个堆来存储，消耗 `O(K)` 的空间。



## 💡总结：

API 的熟悉与否几乎是很重要的，熟悉掌握 API 可以做到又好又快解题，将短暂的时间专注于思路，而不是代码上。不信可以尝试用 C 语言写一波……

