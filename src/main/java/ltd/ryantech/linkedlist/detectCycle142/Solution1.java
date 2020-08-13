package ltd.ryantech.linkedlist.detectCycle142;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.detectCycle142
 * @description 142. 环形链表 II
 * @leetcode_CN_url // https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @leetcode_US_url // https://leetcode.com/problems/linked-list-cycle-ii/
 * @hard_level Medium
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/08/11 10:54
 **/

public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 快慢指针相遇，说明链表存在环
            if (fast == slow) {
                // 此时 slow 指针距离环的起点的距离恰好为 a
                ListNode q = head;
                while (q != slow) {
                    slow = slow.next;
                    q = q.next;
                }
                // slow 和 q 相遇的位置一定是环的起点
                return slow;
            }
        }
        // 链表不存在环，返回 null
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        ListNode cycle = head.next;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = cycle;
        System.out.println(new Solution1().detectCycle(head).val);
    }
}
