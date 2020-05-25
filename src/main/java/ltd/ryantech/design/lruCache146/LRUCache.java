package ltd.ryantech.design.lruCache146;

import java.util.HashMap;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.design.lruCache146
 * @description LRU 缓存机制
 * @leetcode_CN_url // https://leetcode-cn.com/problems/lru-cache/
 * @leetcode_US_url // https://leetcode.com/problems/lru-cache/
 * @hard_level Medium
 * @tag Design // https://leetcode-cn.com/tag/design/
 * @create 2020/05/25 15:27
 **/


public class LRUCache {

    public Node dummyHead;
    public Node dummyTail;
    public int maxSize;
    /**
     * LRUCache 已使用空间
     */
    public int lruSize;
    HashMap<Integer, Node> hashMap;


    public LRUCache(int capacity) {
        this.dummyHead = new Node();
        this.dummyTail = new Node();
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.pre = this.dummyHead;
        this.maxSize = capacity;
        this.lruSize = 0;
        this.hashMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = this.hashMap.get(key);
        if (node != null) {
            this.remove(node);
            this.addFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.hashMap.containsKey(key)) {
            Node node = this.hashMap.get(key);
            this.remove(node);
            node.value = value;
            this.addFirst(node);
        } else {
            Node node = new Node(key, value);
            if (this.lruSize < this.maxSize) {
                this.addFirst(node);
                this.hashMap.put(key, node);
                this.lruSize++;
            } else {
                this.removeLast();
                this.addFirst(node);
                this.hashMap.put(key, node);
            }
        }
    }

    // 添加一个 Node 到双向链表头
    public void addFirst(Node node) {
        node.pre = this.dummyHead;
        node.next = this.dummyHead.next;
        this.dummyHead.next.pre = node;
        this.dummyHead.next = node;
    }

    // 删除一个节点
    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // 删除最后一个节点
    public void removeLast() {
        Node lastNode = this.dummyTail.pre;
        remove(lastNode);
    }

    // 获得最后一个节点
    public Node getLast() {
        return this.dummyTail.pre;
    }


    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(2, 1);
//        lruCache.put(1, 1);
//        lruCache.put(2, 3);
//        lruCache.put(4, 1);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
