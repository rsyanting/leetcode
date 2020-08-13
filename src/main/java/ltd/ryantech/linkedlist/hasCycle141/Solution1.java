package ltd.ryantech.linkedlist.hasCycle141;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.hasCycle141
 * @description 141. 环形链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/linked-list-cycle/
 * @leetcode_US_url // https://leetcode.com/problems/linked-list-cycle/
 * @hard_level Easy
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/08/11 10:37
 **/

public class Solution1 {
    // 快慢双指针 解法
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        ListNode cycle = head.next;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = cycle;
        System.out.println(new Solution1().hasCycle(head));
    }
}
