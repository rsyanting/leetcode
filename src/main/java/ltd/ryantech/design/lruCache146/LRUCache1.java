package ltd.ryantech.design.lruCache146;


import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.design.lruCache146
 * @description LRU 缓存机制
 * @leetcode_CN_url // https://leetcode-cn.com/problems/lru-cache/
 * @leetcode_US_url // https://leetcode.com/problems/lru-cache/
 * @hard_level Medium
 * @tag Design // https://leetcode-cn.com/tag/design/
 * @create 2020/05/25 11:07
 **/

/**
 * 使用内建的 LinkedList 进行操作
 */

public class LRUCache1 {

    HashMap<Integer, Node> hashMap;
    LinkedList<Node> linkedList;
    int lruSize;
    int maxSize;

    public LRUCache1(int capacity) {
        this.hashMap = new HashMap<>();
        this.linkedList = new LinkedList<>();
        this.maxSize = capacity;
        this.lruSize = 0;
    }

    public int get(int key) {
        Node node = this.hashMap.get(key);
        if (node != null) {
            this.linkedList.remove(node);
            this.linkedList.addFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 需要加入的 K-V 已经存在，此时需要更新数据
        if (this.hashMap.containsKey(key)) {
            Node node = this.hashMap.get(key);
            // 移动 node 到头部
            this.linkedList.remove(node);
            this.linkedList.addFirst(node);
            node.value = value;
        } else {
            Node node = new Node(key, value);
            // 空间未满
            if (this.lruSize < this.maxSize) {
                this.hashMap.put(key, node);
                this.linkedList.addFirst(node);
                this.lruSize++;
            } else {
                // 空间已满，删除链表中的 node ，同时移除 hashmap 中的 key
                Node lastNode = this.linkedList.getLast();
                this.hashMap.remove(lastNode.key);
                this.linkedList.remove(lastNode);

                this.hashMap.put(key, node);
                this.linkedList.addFirst(node);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache1 lruCache = new LRUCache1(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
//        lruCache.put(4, 4);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));
    }
}
