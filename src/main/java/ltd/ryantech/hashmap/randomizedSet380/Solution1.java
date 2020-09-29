package ltd.ryantech.hashmap.randomizedSet380;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.hashmap.randomizedSet380
 * @description 380. 常数时间插入、删除和获取随机元素
 * @leetcode_CN_url // https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * @leetcode_US_url // https://leetcode.com/problems/insert-delete-getrandom-o1/
 * @hard_level Medium
 * @tag HashMap // https://leetcode-cn.com/tag/hash-table/
 * @create 2020/09/29 15:24
 **/

public class Solution1 {
    public List<Integer> nums;
    Map<Integer, Integer> valToIndex;
    Random rand;

    public Solution1() {
        this.nums = new ArrayList<>();
        this.valToIndex = new HashMap<>();
        this.rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        // 如果已经存在，那么直接返回 true
        if (this.valToIndex.containsKey(val)) {
            return false;
        }

        this.nums.add(val);
        this.valToIndex.put(val, nums.size() - 1); // 先追加元素到 nums 数组中，再写入其下标，下标从 0 开始

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        // 如果要删除的元素不在数组中，则直接返回 true
        if (!this.valToIndex.containsKey(val)) {
            return false;
        }

        int lastElement = this.nums.get(this.nums.size() - 1);
        int index = this.valToIndex.get(val); // 待删除元素的 下标

        this.nums.set(index, lastElement); // 交换最后一个元素，用其值覆盖 val
        this.valToIndex.put(lastElement, index);
        this.nums.remove(nums.size() - 1);
        this.valToIndex.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
//        return this.nums.get(rand.nextInt(nums.size()));
        return this.nums.get((int) (Math.random() * this.nums.size()));
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.insert(1));
        System.out.println(solution1.remove(2));
        System.out.println(solution1.insert(2));
        System.out.println(solution1.getRandom());
        System.out.println(solution1.remove(1));
        System.out.println(solution1.insert(2));
        System.out.println(solution1.getRandom());
    }
}
