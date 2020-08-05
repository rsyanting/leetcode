package ltd.ryantech.linkedlist.twoSums2;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.twoSums2
 * @description 两数之和的链表版本
 * @leetcode_CN_url // https://leetcode-cn.com/problems/add-two-numbers/
 * @leetcode_US_url // https://leetcode.com/problems/add-two-numbers/
 * @hard_level Medium
 * @tag listed list ; math
 * @create 2020/08/03 15:23
 **/

public class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null && l2 != null) {
            ListNode cur = new ListNode(0);
            int sum = l2.val + l1.val + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode cur = new ListNode(0);
            int sum = l1.val + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode cur = new ListNode(0);
            int sum = l2.val + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            l2 = l2.next;
        }

        if (carry != 0) {
            prev.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode sums = new ListNode(0);
        sums.next = addTwoNumbers(l1, l2);
        while (sums.next != null) {
            sums = sums.next;
            System.out.print(sums.val);
        }
    }
}
