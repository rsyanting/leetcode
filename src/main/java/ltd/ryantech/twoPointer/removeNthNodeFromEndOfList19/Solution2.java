package ltd.ryantech.twoPointer.removeNthNodeFromEndOfList19;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.removeNthNodeFromEndOfList19
 * @description 19. 删除链表的倒数第N个节点
 * @leetcode_CN_url https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @hard_level medium
 * @tag Two Pointer // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/10/21 14:05
 **/

public class Solution2 {
    // 双指针
    // 遍历一次链表
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        // 拉开 n 的 gap
        while (fast != null && n > 0) {
            fast = fast.next;
            n--;
        }

        // slow 定位到倒数第 N 个元素的前一个元素
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = new Solution2().removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
