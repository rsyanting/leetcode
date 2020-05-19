package ltd.ryantech.linkedlist.palindromeLinkedList234;

import ltd.ryantech.linkedlist.ListNode;


/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.palindromeLinkedList234
 * @description 回文链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/palindrome-linked-list/
 * @leetcode_US_url // https://leetcode.com/problems/palindrome-linked-list/
 * @hard_level Easy
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/05/19 20:07
 **/

public class Solution1 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = head;
        ListNode fast = head.next; // if 特判 否则会抛出 null 指针异常
        ListNode pre = null;
        ListNode tmp = null;
        // 结束 while 循环后
        // 节点数为奇数，slow 位于 前半部分链表的尾部的后一个，即中轴点，fast 等于 null
        // 节点数为偶数，slow 位于 前半部分链表的尾部，fast.next 等于 null
        // 边移动快慢指针，边反转 前半部分链表
        while (fast != null && fast.next != null) {
            pre = slow;
            // 移动快慢指针
            fast = fast.next.next;
            slow = slow.next;
            // 反转链表
            pre.next = tmp;
            tmp = pre;
        }
        ListNode endHead = slow.next;
        // 为下面的 slow.next 正确判断，将整个链表 “断开” 来
        slow.next = pre;
        ListNode frontHead = (fast == null) ? slow.next : slow;
        // 此时前半部分 和 后半部分 长度是相等的
        while (frontHead != null) {
            if (frontHead.val != endHead.val) {
                return false;
            }
            frontHead = frontHead.next;
            endHead = endHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(new Solution1().isPalindrome(head));
    }
}
