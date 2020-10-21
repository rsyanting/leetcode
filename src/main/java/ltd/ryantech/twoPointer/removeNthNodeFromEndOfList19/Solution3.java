package ltd.ryantech.twoPointer.removeNthNodeFromEndOfList19;

import ltd.ryantech.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.removeNthNodeFromEndOfList19
 * @description 19. 删除链表的倒数第N个节点
 * @leetcode_CN_url https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @hard_level medium
 * @tag Two Pointer // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/10/21 14:13
 **/

public class Solution3 {
    // 栈
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;

        // 将节点依次入栈
        while (p != null) {
            stack.addLast(p);
            p = p.next;
        }

        // 弹出后 N 个元素
        while (n > 0) {
            stack.removeLast();
            n--;
        }

        // 此时栈顶元素为倒数前 N 个元素的前面一个节点
        p = stack.removeLast();
        p.next = p.next.next; // 移除第 N 个节点

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = new Solution3().removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
