package ltd.ryantech.hashmap.topKFrequentElements347;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.hashmap.topKFrequentElements347
 * @description 347. 前 K 个高频元素
 * @leetcode_CN_url // https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @leetcode_US_url // https://leetcode.com/problems/top-k-frequent-elements/
 * @hard_level Medium
 * @tag HashMap // https://leetcode-cn.com/tag/hash-table/
 * @create 2020/05/23 12:02
 **/

public class Solution1 {
    // 优先队列 最小堆
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hashMap.get(o1) - hashMap.get(o2);
            }
        });
        // 每次存入一个新的元素，优先队列头部是频次较小的元素
        // 出现频次在前 K 个的，被“沉淀”到优先队列的尾部
        for (Integer key : hashMap.keySet()) {
            priorityQueue.offer(key);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            res[index++] = priorityQueue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] res = new Solution1().topKFrequent(nums, 2);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
