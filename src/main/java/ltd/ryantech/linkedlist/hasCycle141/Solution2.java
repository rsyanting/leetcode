package ltd.ryantech.linkedlist.hasCycle141;

import ltd.ryantech.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.hasCycle141
 * @description 141. 环形链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/linked-list-cycle/
 * @leetcode_US_url // https://leetcode.com/problems/linked-list-cycle/
 * @hard_level Easy
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/08/11 10:51
 **/

public class Solution2 {
    public boolean hasCycle(ListNode head) {
        // 记录已访问过的结点
        Set<ListNode> seen = new HashSet<>();
        for (ListNode q = head; q != null; q = q.next) {
            if (seen.contains(q)) {
                // 遇到已访问过的结点，确定链表存在环
                return true;
            }
            seen.add(q);
        }
        // 遍历循环正常退出，链表不存在环
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        ListNode cycle = head.next;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = cycle;
        System.out.println(new Solution2().hasCycle(head));
    }
}
