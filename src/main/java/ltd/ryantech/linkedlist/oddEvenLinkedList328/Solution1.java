package ltd.ryantech.linkedlist.oddEvenLinkedList328;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.oddEvenLinkedList328
 * @description 奇偶链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/odd-even-linked-list/
 * @leetcode_US_url // https://leetcode.com/problems/odd-even-linked-list/
 * @hard_level Easy
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/05/17 22:50
 **/

public class Solution1 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenNode = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenNode;
        return dummyHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        ListNode res = new Solution1().oddEvenList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
