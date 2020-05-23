

# 451_SortCharactersByFrequency_根据字符出现的频率排序

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/sort-characters-by-frequency/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/sort-characters-by-frequency/)

📗Difficulty：	**Medium**	

🎯Tags：

+ **[HashTable](https://leetcode.com/tag/hash-table/)** 
+ **[String](https://leetcode.com/tag/string/)**

---

## 📃题目描述：

给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

**样例 1：**

```
输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
```



**样例 2：**

```
输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
```



**样例 3：**

```
输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```



****

## 🏹🎯解题思路

### 优先队列 + 哈希表

新建一个数组，对其中的每个字符出现的频度进行统计。`int[] counter = new counter[128]` 。下标 `i` 代表字符的 ASCII 码，数值代表其出现频次。

新建一个 优先队列，按照字符出现频度的大小进行排序，频度出现高的在队列前面。

依次出队元素，将字符依次加入 `stringBuilder` 中去。

### 代码实现

```java
public String frequencySort(String s) {
        int[] counter = new int[128];
        for (char c : s.toCharArray()) {
            counter[(int) c]++;
        }
        PriorityQueue<Pair<Character, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Pair<Character, Integer>>() {
            @Override
            public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                priorityQueue.offer(new Pair<>((char) i, counter[i]));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Pair p = priorityQueue.poll();
            for (int i = 0; i < (int) p.getValue(); i++) {
                stringBuilder.append(p.getKey());
            }
        }
        return stringBuilder.toString();
    }
```



#### 复杂度分析

+ 时间复杂度：
+ 空间复杂度：`O(n)`。最坏情况下需要将全部的元素加入优先队列中。但本题给定的为 ASCII 码，其数值有限。看成 O(1) 也未尝不可。



## 💡总结：



相似题目：

#### [387. 字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string/)

> 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
>
> 样例：
>
> ```
> s = "leetcode"
> 返回 0.
> 
> s = "loveleetcode",
> 返回 2.
> ```
>
> 假定只出现 小写 字母。

```java
public int firstUniqChar(String s) {
    int[] keys = new int[26];
    for (char key : s.toCharArray()) {
        keys[key - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
        if (keys[s.charAt(i) - 'a'] == 1) {
            return i;
        }
    }
    return -1;
}
```



#### [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)

> 给定一个非空的整数数组，返回其中出现频率前 ***k\*** 高的元素。
>
> 示例 1：
>
> ```
> 输入: nums = [1,1,1,2,2,3], k = 2
> 输出: [1,2]
> ```
>
> 示例 2：
>
> ```
> 输入: nums = [1], k = 1
> 输出: [1]
> ```

