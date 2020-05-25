package ltd.ryantech.design.lruCache146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.design.lruCache146
 * @description LRU 缓存机制
 * @leetcode_CN_url // https://leetcode-cn.com/problems/lru-cache/
 * @leetcode_US_url // https://leetcode.com/problems/lru-cache/
 * @hard_level Medium
 * @tag Design // https://leetcode-cn.com/tag/design/
 * @create 2020/05/25 10:37
 **/

/**
 * 使用 LinkedHashMap 实现 LRU 算法
 */
public class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    int lruSize;

    public LRUCache2(int capacity) {
        super(capacity, 0.75f, true);
        this.lruSize = capacity;
    }

    public int get(int key) {
        Integer value = super.get(key);
        return (value == null) ? -1 : value;
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > lruSize; //must override it if used in a fixed cache
    }

    public static void main(String[] args) {
        LRUCache2 lruCache = new LRUCache2(2);
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
