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
 * @create 2020/05/25 15:30
 **/

public class Node {
    public int key, value;
    public Node next, pre;

    public Node() {

    }

    public Node(int k, int v) {
        this.key = k;
        this.value = v;
    }
}
