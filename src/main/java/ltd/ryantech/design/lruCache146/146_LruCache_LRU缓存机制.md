

# 146_LruCache_LRU缓存机制

## 📌题目详情

[leetcode 题目地址](https://leetcode.com/problems/lru-cache/)

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/lru-cache/)

📗Difficulty：	**Medium** 

🎯Tags：

+ **[Linked List](https://leetcode.com/tag/linked-list/)**
+ **[HashTable](https://leetcode.com/tag/hash-table/)** 

---

## 📃题目描述

运用你所掌握的数据结构，设计和实现一个 `LRU (最近最少使用)` 缓存机制。它应该支持以下操作： 获取数据 `get` 和 写入数据 `put` 。

获取数据 `get(key)` - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 `-1`。

写入数据 `put(key, value)` - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数。



**样例 1：**

```
LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得关键字 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得关键字 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
```



进阶：

+ 你是否可以在 `O(1)` 时间复杂度内完成这两种操作？

****

## 🏹🎯解题思路

### 思路解析

> 以下思路参考了 leetcode-cn 用户 [labuladong](https://leetcode-cn.com/u/labuladong/) 的[题解](https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/)，感谢其带来的精彩解析。

很明显在在暗示使用 hashmap，键值的描述指向性很明显。

查询 get 可以使用 hashmap 做到 O(1) 的复杂度，那么 put 呢？实现数据的快捷插入和删除，使用链表是一个好的方案。其又分为单向链表和双链表。双链表可以做到在 O(1) 时间内获取前面一个或后面一个元素。如果可以获取一个元素在双向链表中的位置，那么可以在 O(1) 时间内在这个元素的末尾插入元素，或者在 O(1) 时间内删除这个元素。也就是对应了：在已知链表头的情况下，在链表头部插入元素；在已知链表尾部的情况，删除链表的尾部节点。

定义一个 `Node` 类，其存储了 `key` 和 `value` 。

```java
public class Node {
    public int key, value;
    public Node next, pre;

    public Node() {

    }

    public Node(int k, int v) {
        this.key = k;
        this.value = v;
    }
}
```

最后一个需要解决的问题是，如何获取一个 node 在链表中的位置？—— HashMap 的 key 存储 给定的 key，value 存储 node 即可。

![HashLinkedList](https://assets.ryantech.ltd/9201fabe4dfdb5a874b43c325d39857182c8ec267f830649a52dda90a63d6671-file_1562356927818)



现在，问题都解决了。

可以使用 Java 内建的 LinkedList 来存储 Node，但是如果可以自己封装一个双向链表，可以获得加分~~



对于 `get(key)` 方法，在 hashmap 里查找是否存在 key。

+ 如果存在，获取 `node.val`。此时不要直接返回 `node.val`，需要把这个 node 移动到链表头部。可以设计一个 `remove(Node node)` 方法，移除 node，再设计一个 `addFirst(Node node)` 方法，将 node 添加到链表头部。
+ 如果不存在，返回 -1。

对于 `put(key)` 方法，分为 key 是否在 hashmap 中与否。

+ 如果 key 已经存在，那么需要做的是更新操作，更新 `node.value` 。同时，需要把 node 移动到链表头部。
+ 如果 key 不存在，需要添加 node。
    + 如果 lruCache 没有满，那么将 node 添加到 lruCache 中即可，同时保证这个 node 节点在链表的头部。更新 hashmap 中的映射。
    + 如果 lruCache 满了。需要移除最后一个节点 node，同时移除其在 hashmap 中的映射。再添加新的 node 到链表头部，在 hashmap 中建立映射。

### 手写双向链表 + HashMap 

对于链表问题，使用 `dummyHead` 是一个好的设计 ，这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。



#### 代码实现

```java
public Node dummyHead;
public Node dummyTail;
public int maxSize;
/**
     * LRUCache 已使用空间
     */
public int lruSize;
HashMap<Integer, Node> hashMap;


public LRUCache(int capacity) {
    this.dummyHead = new Node();
    this.dummyTail = new Node();
    this.dummyHead.next = this.dummyTail;
    this.dummyTail.pre = this.dummyHead;
    this.maxSize = capacity;
    this.lruSize = 0;
    this.hashMap = new HashMap<>();
}

public int get(int key) {
    Node node = this.hashMap.get(key);
    if (node != null) {
        this.remove(node);
        this.addFirst(node);
        return node.value;
    }
    return -1;
}

public void put(int key, int value) {
    if (this.hashMap.containsKey(key)) {
        Node node = this.hashMap.get(key);
        this.remove(node);
        this.addFirst(node);
        node.value = value;
    } else {
        Node node = new Node(key, value);
        if (this.lruSize < this.maxSize) {
            this.addFirst(node);
            this.hashMap.put(key, node);
            this.lruSize++;
        } else {
            Node lastNode = this.getLast();
            this.remove(lastNode);
            this.hashMap.remove(lastNode.key); // 移除在 hashmap 的映射
            this.addFirst(node);
            this.hashMap.put(key, node);
        }
    }
}

// 添加一个 Node 到双向链表头
public void addFirst(Node node) {
    node.next = this.dummyHead.next;
    node.pre = this.dummyHead;
    this.dummyHead.next.pre = node;
    this.dummyHead.next = node;
}

// 删除一个节点
public void remove(Node node) {
    node.pre.next = node.next;
    node.next.pre = node.pre;
}

// 删除最后一个节点
public void removeLast() {
    Node lastNode = this.dummyTail.pre;
    remove(lastNode);
}

// 获得最后一个节点
public Node getLast() {
    return this.dummyTail.pre;
}
```



#### 复杂度分析

+ 时间复杂度：`O(1)`。
+ 空间复杂度：`O(k)`。k 为 lruCache 的大小。



### LinkedList 快速实现

思路不做赘述了。

#### 代码实现

```java
public class LRUCache1 {

    HashMap<Integer, Node> hashMap;
    LinkedList<Node> linkedList;
    int lruSize;
    int maxSize;

    public LRUCache1(int capacity) {
        this.hashMap = new HashMap<>();
        this.linkedList = new LinkedList<>();
        this.maxSize = capacity;
        this.lruSize = 0;
    }

    public int get(int key) {
        Node node = this.hashMap.get(key);
        if (node != null) {
            this.linkedList.remove(node);
            this.linkedList.addFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 需要加入的 K-V 已经存在，此时需要更新数据
        if (this.hashMap.containsKey(key)) {
            Node node = this.hashMap.get(key);
            // 移动 node 到头部
            this.linkedList.remove(node);
            this.linkedList.addFirst(node);
            node.value = value;
        } else {
            Node node = new Node(key, value);
            // 空间未满
            if (this.lruSize < this.maxSize) {
                this.hashMap.put(key, node);
                this.linkedList.addFirst(node);
                this.lruSize++;
            } else {
                // 空间已满，删除链表中的 node ，同时移除 hashmap 中的 key
                Node lastNode = this.linkedList.getLast();
                this.hashMap.remove(lastNode.key);
                this.linkedList.remove(lastNode);

                this.hashMap.put(key, node);
                this.linkedList.addFirst(node);
            }
        }
    }
}
```



### LinkedHashMap LRU 实现

直接实现了 LRU 的策略。

```java
/**
 * 使用 LinkedHashMap 实现 LRU 算法
 */
public class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    int lruSize;

    public LRUCache2(int capacity) {
        super(capacity, 0.75f, true);
        this.lruSize = capacity;
    }

    public int get(int key) {
        Integer value = super.get(key);
        return (value == null) ? -1 : value;
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > lruSize; //must override it if used in a fixed cache
    }
}
```



## 💡总结

总的来说，本题的思路并不复杂，但是实现过程中，需要对细节有很好的把握，否则很容易造成错误，无法通过测试。

给出几个优秀的题解。

[LRU 策略详解和实现](https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/) by [labuladong](https://leetcode-cn.com/u/labuladong/)

[LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/) by [leetcode-cn](https://leetcode-cn.com/u/leetcode-solution/) 





