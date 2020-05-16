package ltd.ryantech.linkedlist.reverseNodesInKGroup25;

import ltd.ryantech.linkedlist.ListNode;


/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.reverseNodesInKGroup25
 * @description K 个一组翻转链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @leetcode_US_url // https://leetcode.com/problems/reverse-nodes-in-k-group/
 * @hard_level Medium
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/05/16 10:13
 **/

public class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode end = dummyHead;

        // 巧妙的是，如果是空链表，那么直接跳过 while 循环，返回 dummyHead
        while (end.next != null) {
            // 划分出 K 个节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 剩余不足 K 个，保持原样
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null; // 为 K 个 group 的翻转做准备，切分开来
            pre.next = reverse(start); // 翻转后 start 到了 K group 的末尾
            start.next = next; // 重新拼接 K group 到链表中去
            pre = start;
            end = start;
        }
        return dummyHead.next;
    }

    // 翻转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = new Solution1().reverseKGroup(head, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
