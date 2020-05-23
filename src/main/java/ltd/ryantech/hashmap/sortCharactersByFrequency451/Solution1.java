package ltd.ryantech.hashmap.sortCharactersByFrequency451;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.hashmap.sortCharactersByFrequency451
 * @description 根据字符出现频率排序
 * @leetcode_CN_url // https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * @leetcode_US_url // https://leetcode.com/problems/sort-characters-by-frequency/
 * @hard_level Medium
 * @tag HashMap // https://leetcode-cn.com/tag/hash-table/
 * @create 2020/05/22 23:13
 **/

public class Solution1 {
    public String frequencySort(String s) {
        int[] counter = new int[128];
        for (char c : s.toCharArray()) {
            counter[(int) c]++;
        }
        PriorityQueue<Pair<Character, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Pair<Character, Integer>>() {
            @Override
            public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                priorityQueue.offer(new Pair<>((char) i, counter[i]));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Pair p = priorityQueue.poll();
            for (int i = 0; i < (int) p.getValue(); i++) {
                stringBuilder.append(p.getKey());
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s1 = "tree";
        System.out.println(new Solution1().frequencySort(s1));
    }
}
