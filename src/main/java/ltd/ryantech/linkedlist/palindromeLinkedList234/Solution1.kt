package ltd.ryantech.linkedlist.palindromeLinkedList234

import ltd.ryantech.linkedlist.ListNodeKT

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.linkedlist.palindromeLinkedList234
 * @description 回文链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/palindrome-linked-list/
 * @leetcode_US_url // https://leetcode.com/problems/palindrome-linked-list/
 * @hard_level Easy
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/05/20 18:32
 **/

fun isPalindrome(head: ListNodeKT?): Boolean {
    if (head?.next == null) {
        return true
    }
    val dummyHead: ListNodeKT = ListNodeKT(-1)
    dummyHead.next = head
    var slow: ListNodeKT = head     // slow 不可空
    var fast: ListNodeKT? = head.next       // fast 可空
    var pre: ListNodeKT? = null     // 毫无疑问可空。加上 ? 符号
    var tmp: ListNodeKT? = null

    while (fast?.next != null) {    //等同于 Java 的 fast != null && fast.next != null
        pre = slow
        fast = fast.next!!.next     // fast 可空
        slow = slow.next!!          // slow 不可空
        pre.next = tmp
        tmp = pre
    }
    var endHead = slow.next
    slow.next = pre
    var frontHead = if (fast == null) slow.next else slow   // Kotlin 中的三元表达式
    while (frontHead != null) {
        if (frontHead.`val` != endHead!!.`val`) {
            return false
        }
        frontHead = frontHead.next
        endHead = endHead.next
    }
    return true
}

fun main(args: Array<String>) {
    val head: ListNodeKT = ListNodeKT(1)
    head.next = ListNodeKT(2)
    head.next!!.next = ListNodeKT(2)
    head.next!!.next!!.next = ListNodeKT(1)
    println(isPalindrome(head))
}