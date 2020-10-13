package ltd.ryantech.hashmap.randomPickWithBlacklist710;

import java.util.*;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.hashmap.randomPickWithBlacklist710
 * @description 710. 黑名单中的随机数
 * @leetcode_CN_url // https://leetcode-cn.com/problems/random-pick-with-blacklist/
 * @leetcode_US_url // https://leetcode.com/problems/random-pick-with-blacklist/
 * @hard_level Hard
 * @tag HashMap // https://leetcode-cn.com/tag/hash-table/
 * @create 2020/09/29 16:08
 **/

/**
 * 白名单数字映射
 * 仅仅变动映射
 * 不进行数据的交换，以节约时间
 */
public class Solution1 {
    int N;
    int[] blacklist;
    int border;
    Map<Integer, Integer> map;
    Random random;

    public Solution1(int N, int[] blacklist) {
        this.N = N;
        this.blacklist = blacklist;
        this.map = new HashMap<>();
        this.random = new Random();

        border = this.N - this.blacklist.length;

        for (int j : this.blacklist) {
            this.map.put(j, Integer.MIN_VALUE);
        }

        int last = this.N - 1;
        for (int j : this.blacklist) {
            // 如果 j 已经在 [sz,N) 区间
            // 那么可以直接忽略掉
            if (j >= border) {
                continue;
            }

            while (this.map.containsKey(last)) {
                last--;
            }
            this.map.put(j, last);
            last--;
        }

    }

    public int pick() {
        int index = this.random.nextInt(this.border);

        if (this.map.containsKey(index)) {
            return this.map.get(index);
        }

        return index;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1(10, new int[]{1, 2, 4});
        System.out.println(solution1.pick());
        System.out.println(solution1.pick());
        System.out.println(solution1.pick());
        System.out.println(solution1.pick());

        Solution1 solution12 = new Solution1(10, new int[]{5});
        System.out.println(solution12.pick());

        Solution1 solution13 = new Solution1(10, new int[]{});
        System.out.println("Solution3 : " + solution13.pick());
    }
}
