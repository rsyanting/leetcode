package ltd.ryantech.linkedlist.swapNodesInPairs24;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.swapNodesInPairs24
 * @description K 个一组翻转链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @leetcode_US_url // https://leetcode.com/problems/swap-nodes-in-pairs/
 * @hard_level Medium
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/05/16 10:50
 **/

public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode firstNode = null;
        ListNode secondNode = null;
        ListNode preNode = dummyHead;

        while (head != null && head.next != null) {
            firstNode = head;
            secondNode = head.next;

            // 交换
            preNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // 向后移动 2 个位置
            preNode = firstNode;
            head = firstNode.next;
//            preNode = preNode.next.next;
//            head = head.next.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = new Solution1().swapPairs(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
