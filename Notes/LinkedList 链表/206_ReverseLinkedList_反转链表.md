# 206_ReverseLinkedList_反转链表

---

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

📗difficulty： **Easy** 

🎯Tags：

+ **[链表](https://leetcode-cn.com/tag/linked-list/)**



---

## 1. 题目描述📃

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。



**样例 1 ：**

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```



**限制：**

+ `0 <= 节点个数 <= 5000`



**注意：**

+ 本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/



---

## 2. 解题思路💡

### 迭代法

双指针思路。

对于链表的指针操作，可以借助画图来辅助理清指针的变换，容易理解且不容易出错。

巧妙的地方在于 `cur = null` 的设定。

![图解](https://assets.ryantech.ltd/20200615164534.jpg)

#### 代码实现

```java
// 迭代法
public ListNode reverseList(ListNode head) {
    ListNode cur = null;
    ListNode pre = head;
    ListNode t = null;
    // 若 head 为 null 则跳过 while 循环，返回 cur = null
    while (pre != null) {
        t = pre.next;
        pre.next = cur;
        cur = pre;
        pre = t;
    }
    return cur;
}
```



#### 复杂度分析

+ 时间复杂度：`O(n)` 。
+ 空间复杂度：`O(1)` 。



> 以下思路来自于 [leetcode-cn 用户 王尼玛 的题解](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/dong-hua-yan-shi-duo-chong-jie-fa-206-fan-zhuan-li/)，感谢其详实的分析。

### 递归解法

![递归图解](https://assets.ryantech.ltd/20200615165814.gif)

#### 代码实现

```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode cur = reverseList(head.next);
    head.next.next = head; // 绕回来了
    head.next = null; // 断开指针，防止循环
    return cur;
}
```

#### 复杂度分析

+ 时间复杂度：`O(n)` 。
+ 空间复杂度：`O(n)` 。



---

## 3. 总结🎯

### 相似题目

[面试题24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

