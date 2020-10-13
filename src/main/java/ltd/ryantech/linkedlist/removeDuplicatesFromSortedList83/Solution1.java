package ltd.ryantech.linkedlist.removeDuplicatesFromSortedList83;

import ltd.ryantech.linkedlist.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.removeDuplicatesFromSortedList83
 * @description 83. 删除排序链表中的重复元素
 * @leetcode_CN_url // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @leetcode_US_url // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * @hard_level Easy
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/10/04 17:40
 **/

public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    @Test
    public void testDeleteDuplicates() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(5);

        head = deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
