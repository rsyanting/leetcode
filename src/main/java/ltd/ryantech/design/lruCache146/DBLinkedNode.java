package ltd.ryantech.design.lruCache146;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.design.lruCache146
 * @description LRU 缓存机制
 * @leetcode_CN_url // https://leetcode-cn.com/problems/lru-cache/
 * @leetcode_US_url // https://leetcode.com/problems/lru-cache/
 * @hard_level Medium
 * @tag Design // https://leetcode-cn.com/tag/design/
 * @create 2020/05/25 15:32
 **/

public class DBLinkedNode {
    Node dummyHead;
    Node dummyTail;

    public DBLinkedNode() {
        this.dummyHead = new Node();
        this.dummyTail = new Node();
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.pre = this.dummyHead;
    }

    public void addFirst(Node node) {
        this.dummyHead.next.pre = node;
        node.next = this.dummyHead.next;
        this.dummyHead.next = node;
        node.pre = this.dummyHead;
    }
}
