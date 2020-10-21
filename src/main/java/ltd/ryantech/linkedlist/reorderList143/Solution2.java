package ltd.ryantech.linkedlist.reorderList143;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.reorderList143
 * @description 143. 重排链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/reorder-list/
 * @hard_level Medium
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/10/20 11:37
 **/

public class Solution2 {
    // 快慢指针 求中点
    // 嫁接合并
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode prev = head;
        while (prev != null) {
            ListNode nextTemp = prev.next;
            prev.next = cur;
            cur = prev;
            prev = nextTemp;
        }
        return cur;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution2 solution2 = new Solution2();
        solution2.reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
