package ltd.ryantech.hashmap.topKFrequentElements347;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.hashmap.topKFrequentElements347
 * @description 前 K 个高频元素
 * @leetcode_CN_url // https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @leetcode_US_url // https://leetcode.com/problems/top-k-frequent-elements/
 * @hard_level Medium
 * @tag HashMap // https://leetcode-cn.com/tag/hash-table/
 * @create 2020/05/23 13:38
 **/

public class Solution2 {
    // 统计频度 + 排序
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        List<HashMap.Entry<Integer, Integer>> list = new LinkedList<>(hashMap.entrySet());
        list.sort(new Comparator<HashMap.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // 升序排序
                return o2.getValue() - o1.getValue();
            }
        });

        int index = 0;
        int[] res = new int[k];
        for (HashMap.Entry<Integer, Integer> entry : list) {
            res[index++] = entry.getKey();
            if (index >= k) {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int[] res = new Solution2().topKFrequent(nums, 2);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
