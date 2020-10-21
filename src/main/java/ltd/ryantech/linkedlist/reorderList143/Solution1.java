package ltd.ryantech.linkedlist.reorderList143;

import ltd.ryantech.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.reorderList143
 * @description 143. 重排链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/reorder-list/
 * @hard_level Medium
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/10/20 10:32
 **/

public class Solution1 {
    // 双端链表
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode p = head;
        while (p != null) {
            deque.addLast(p);
            p = p.next;
        }

        while (!deque.isEmpty()) {
            if (!deque.isEmpty()) {
                head.next = deque.removeFirst();
                head = head.next;
            }

            if (!deque.isEmpty()) {
                head.next = deque.removeLast();
                head = head.next;
            }
        }

        head.next = null;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution1 solution1 = new Solution1();
        solution1.reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
