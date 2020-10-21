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
 * @create 2020/10/21 14:00
 **/

public class Solution1 {
    // 计算出 链表 的长度
    // 再删除倒数第 N 个元素
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        int length = 0;
        ListNode first = dummyHead;
        while (first != null) {
            first = first.next;
            length++;
        }
        // 结束后 length 的长度为实践的 length + 1
        first = dummyHead;
        length = length - 1 - n;
        while (length > 0) {
            first = first.next;
            length--;
        }
        first.next = first.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = new Solution1().removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
