package ltd.ryantech.linkedlist.deleteDodeInALinkedList237;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.deleteDodeInALinkedList237
 * @description 237. 删除链表中的节点
 * @leetcode_CN_url // https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @leetcode_US_url // https://leetcode.com/problems/delete-node-in-a-linked-list/
 * @hard_level Easy
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/06/02 16:53
 **/

public class Solution1 {
    // 覆写策略
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode q = head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new Solution1().deleteNode(q);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
