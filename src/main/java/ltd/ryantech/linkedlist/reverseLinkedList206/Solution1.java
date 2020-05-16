package ltd.ryantech.linkedlist.reverseLinkedList206;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.reverseLinkedList206
 * @description 反转链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/reverse-linked-list/
 * @leetcode_US_url // https://leetcode.com/problems/reverse-linked-list/
 * @hard_level Easy
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/05/16 16:23
 **/

public class Solution1 {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = new Solution1().reverseList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
